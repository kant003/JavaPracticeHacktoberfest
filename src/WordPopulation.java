import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.TreeMap;

/**
 * Prints out the most popular words used in a text
 * 
 * @author imodm
 *
 */
public class WordPopulation {
	public WordPopulation() {
		String str = "Did you know that the width of the earth is actually not constant despite the fact that in common languages and dictations "
				+ "we assume and assign despite the greatest fall of the British Empire regardless of the fact that this is perhaps the silliest"
				+ " thing to possibly do? That's correct! Regardless of the magical poweres of your gaming mouse, hacking is still pretty gosh dang cool!";

		Map<String, Integer> values = new TreeMap<>();
		for (String s : str.split(" ")) {
			values.put(s, values.getOrDefault(s, 0) + 1);
		}
		for (Entry<String, Integer> entry : values.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toList()))
			System.out.println(entry.getKey() + ": " + entry.getValue());
	}

	public static void main(String[] args) {
		new WordPopulation();
	}
}
