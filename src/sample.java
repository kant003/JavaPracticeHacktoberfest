import java.io.*;    //importing IO Library
public class sample{
  public static void main(String[] args) throws IOException{
    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));   //Creating Input Reader
    System.out.println("Enter Your Name:");     //Displaying message to enter name
    String name=in.readLine();                  //Reading input
    System.out.println("Hello "+name+"\n");     //Displaying output
  }
}
