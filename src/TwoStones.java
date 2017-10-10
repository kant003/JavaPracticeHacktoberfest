import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Sample solution for https://open.kattis.com/problems/twostones

public class TwoStones {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int stones = Integer.parseInt(reader.readLine());

		System.out.println(stones % 2 == 1 ? "Alice" : "Bob");
	}
}
