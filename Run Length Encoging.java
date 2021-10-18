import java.util.Scanner;
class Main {
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//Declare Scanner
		System.out.print("Input Sequence of characters(In Uppercase): ");
		String input = sc.nextLine(); //User input sequence of characters

		float l1 = input.length();// Length of input string
		sc.close(); //closing scanner
		input = input + "B";// To ensure that last series of characters are considered
		String finalstr = "";//storessss final RLE string

		char current;
		int count=0;

		current = input.charAt(0);// initialising variables to first character

		finalstr = finalstr + current;//putting first char in final string

		for (int i = 1; i < input.length(); i++){//parsing through input string
			if (current == input.charAt(i)){//check if character is same
				count++;
			}
			else{// as new character is detected, it concatenates the final string and changes the value of current
				finalstr = finalstr + current + Integer.toString(count+1);
				current = input.charAt(i);
				count = 0;//re-initialise count 
			}
		}

		float l2 = finalstr.length();// Length of final string

		//outputing the RLE
		System.out.print("Run Length Encoding: ");
		for (int i = 1; i < finalstr.length(); i++){
			System.out.print(finalstr.charAt(i));
		}
		System.out.print("\n");

		float percentage = (((l1 - l2) / l1)*100);//calculating percentage compression

		System.out.print("Percentage Compression: " + percentage + " %");
  }
}