import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Sample solution to https://open.kattis.com/problems/simonsays

public class SimonSays {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int commands = Integer.parseInt(reader.readLine());

		for (int i = 0; i < commands; i++) {
			String line = reader.readLine();
			if (line.startsWith("Simon says")) {
				String command = line.split("Simon says ")[1];
				System.out.println(command);
			}
		}
	}
}
