public class StringReverser {

    public static String reverseString(String stringIn) {
        return new java.lang.StringBuilder(stringIn).reverse().toString();
    }
    
    public static void main(String[] args) {
        String stringToReverse = "abcdefghijklmnopqrstuvwxyz";
        if (args.length > 0) stringToReverse = args[0];
        System.out.println("Original string: " + stringToReverse + "\nReversed string: " + reverseString(stringToReverse));
    }
    
}
