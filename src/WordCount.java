import java.util.*;

class WordCount {

    /** StringTokenizer class is used to split a string with a delimiter. By default **Space** is the delimiter, You can specify your own. **/
    public static void main (String args[]){

        String s = "The Quick brown fox jumps over the lazy dog.";
        StringTokenizer st = new StringTokenizer(s, " "); // Space is the delimiter
        while(st.hasMoreTokens()) 
        {
            System.out.println(st.nextToken());
        }
    }
}