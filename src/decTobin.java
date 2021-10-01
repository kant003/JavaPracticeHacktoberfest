// Program to convert decimal to binary number

import java.util.Scanner;

public class Test4 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int no = s.nextInt();
        int i;
        String st = "";
        while(no>0){
            st = st+(no%2);
            no = no/2;
        }
        for(i=st.length()-1;i>=0;i--){
            System.out.print(st.charAt(i));
        }
    }
}
