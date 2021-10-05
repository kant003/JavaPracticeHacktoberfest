package servidor1;

import java.net.*;
import java.io.*;

/**
 * Descripcion
 * 
 * un servidor simple que aceptará una conexión de cliente único y mostrará
 *  todo lo que el cliente dice en la pantalla. Si el usuario del cliente 
 *  escribe ".bye", el cliente y el servidor se cerrarán.
 *
 */

public class Servidor{  
   private Socket          socket   = null;
   private ServerSocket    server   = null;
   private DataInputStream streamIn =  null;

   public Servidor(int port)
   {  try
      {  System.out.println("Conectandose al puerto " + port + ", Espere por favor...");
         server = new ServerSocket(port);  
         System.out.println("Servidor iniciado: " + server);
         System.out.println("Esperando por un cliente..."); 
         socket = server.accept();
         System.out.println("Cliente aceptado: " + socket);
         open();
         boolean done = false;
         while (!done)
         {  try
            {  String line = streamIn.readUTF();
               System.out.println(line);
               done = line.equals(".bye");
            }
            catch(IOException ioe)
            {  done = true;
            }
         }
         close();
      }
      catch(IOException ioe)
      {  System.out.println(ioe); 
      }
   }
   public void open() throws IOException
   {  streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
   }
   public void close() throws IOException
   {  if (socket != null)    socket.close();
      if (streamIn != null)  streamIn.close();
   }
   public static void main(String args[]){  
	  Servidor server = null;
      //if (args.length != 1)
         //System.out.println("Usage: java ChatServer port");
     // else
         server = new Servidor(Integer.parseInt("30000"));
   }
}
