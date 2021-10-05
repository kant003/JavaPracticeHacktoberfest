package cliente4_2;

import java.net.*;

import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Applet es una clase que genera una ventana, por defecto ejecuta varios
//metodos, en este caso utilizamos init() que funciona como main
public class Cliente5 extends Applet {
	private Socket socket = null;
	private DataInputStream console = null;
	private DataOutputStream streamOut = null;
	private ChatClientThread client = null;
	private TextArea display = new TextArea();
	private TextField input = new TextField();
	private Button send = new Button("Send"), connect = new Button("Connect"), quit = new Button("Bye");
	private String serverName = "192.168.10.47";
	private int serverPort = 30000;

	public void init() {
		System.out.println("Entro en init()");

		Panel keys = new Panel();
		keys.setLayout(new GridLayout(1, 2));
		keys.add(quit);
		keys.add(connect);
		Panel south = new Panel();
		south.setLayout(new BorderLayout());
		south.add("West", keys);
		south.add("Center", input);
		south.add("East", send);
		Label title = new Label("Simple Chat Client Applet", Label.CENTER);
		title.setFont(new Font("Helvetica", Font.BOLD, 14));
		setLayout(new BorderLayout());
		add("North", title);
		add("Center", display);
		add("South", south);
		quit.disable();
		send.disable();
	}

	public boolean action(Event e, Object o) {
		System.out.println("Entro en action()");

		if (e.target == quit) {
			input.setText(".bye");
			send();
			quit.disable();
			send.disable();
			connect.enable();
		} else if (e.target == connect) {
			connect(serverName, serverPort);
		} else if (e.target == send) {
			send();
			input.requestFocus();
		}

		return true;

	}

	public void connect(String serverName, int serverPort) {
		System.out.println("Entro en connect()");

		println("Establishing connection. Please wait ...");
		try {
			socket = new Socket(serverName, serverPort);
			println("Connected: " + socket);
			open();
			send.enable();
			connect.disable();
			quit.enable();
		} catch (UnknownHostException uhe) {
			println("Host unknown: " + uhe.getMessage());
		} catch (IOException ioe) {
			println("Unexpected exception: " + ioe.getMessage());
		}

	}

	private void send() {
		System.out.println("Entro en send()");

		try {
			streamOut.writeUTF(input.getText());
			streamOut.flush();
			input.setText("");
		} catch (IOException ioe) {
			println("Sending error: " + ioe.getMessage());
			close();
		}

	}

	public void handle(String msg) {
		System.out.println("Entro en handle()");

		if (msg.equals(".bye")) {
			println("Good bye. Press RETURN to exit ...");
			close();
		} else
			println(msg);
	}

	public void open() {
		System.out.println("Entro en open()");

		try {
			streamOut = new DataOutputStream(socket.getOutputStream());
			client = new ChatClientThread(this, socket);
		} catch (IOException ioe) {
			println("Error opening output stream: " + ioe);
		}

	}

	public void close() {
		System.out.println("Entro en close()");

		try {
			if (streamOut != null)
				streamOut.close();
			if (socket != null)
				socket.close();
		} catch (IOException ioe) {
			println("Error closing ...");
		}
		client.close();
		client.stop();
	}

	private void println(String msg) {
		System.out.println("Entro en println()");
		display.appendText(msg + "\n");
	}
}

class ChatClientThread extends Thread {
	private Socket socket = null;
	private Cliente5 client = null;
	private DataInputStream streamIn = null;

	public ChatClientThread(Cliente5 _client, Socket _socket) {
		System.out.println("Entro en chatClientThread()");
		client = _client;
		socket = _socket;
		open();
		// Metodo del hilo que llama al metodo que la clase ChatClientThread
		// heredo de Thread y que implica que ejecuta el metodo llamado run()
		start();
	}

	public void open() {
		System.out.println("Entro en open()");
		try {
			streamIn = new DataInputStream(socket.getInputStream());
		} catch (IOException ioe) {
			System.out.println("Error getting input stream: " + ioe);
			client.stop();
		}
	}

	public void close() {
		System.out.println("Entro en close()");
		try {
			if (streamIn != null)
				streamIn.close();
		} catch (IOException ioe) {
			System.out.println("Error closing input stream: " + ioe);
		}
	}

	public void run() {
		System.out.println("Entro en run()");

		while (true) {
			System.out.println("Entro en el while()");
			try {
				client.handle(streamIn.readUTF());
			} catch (IOException ioe) {
				System.out.println("Listening error: " + ioe.getMessage());
				client.stop();
			}
		}

	}
}