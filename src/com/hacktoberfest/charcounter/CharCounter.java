package charcounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This program reads text from a given file and count how many vowels are
 * within it.
 * 
 * @author Ivan Nieto
 *
 */

public class CharCounter {
	static File f;
	char[] charArray = new char[1000];

	public static void checkChars(File f) throws IOException {
		f = new File("charcounter.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		int counter = 0, counterConsonant = 0, counterVowels = 0;

		if (f.exists()) {
			String characters;
			// Reading file by chars while there are chars to read
			while ((characters = br.readLine()) != null) {
				char[] charArr = characters.toCharArray();
				for (int i = 1; i < charArr.length; i++) {
					if (charArr[i] == 'a' | charArr[i] == 'e' | charArr[i] == 'i' | charArr[i] == 'o'
							| charArr[i] == 'u') {
						counter++;
						counterVowels++;
					} else {
						counter++;
						counterConsonant++;
					}
				}
			}
		}

		fr.close();
		br.close();

		System.out.println(
				"Chars in file: " + counter + "\nConsonants: " + counterConsonant + "\nVowels: " + counterVowels);
	}

	public static void main(String[] args) throws IOException {
		checkChars(f);
	}
}

