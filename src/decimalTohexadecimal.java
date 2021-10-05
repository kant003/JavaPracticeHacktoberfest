// Program to convert a decimal number to hexadecimal equivalent of that number.

import java.util.HashMap;
import java.util.Scanner;

public class Test5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();                                  // Enter Decimal Number
        String st1 = "";
        HashMap<Integer, String> map = new HashMap<>();
        map.put(10,"A");
        map.put(11,"B");
        map.put(12,"C");
        map.put(13,"D");
        map.put(14,"E");
        map.put(15,"F");
        int i,sum=0,j=0;
        for(i=st.length()-1;i>=0;i--){
            sum+=Character.getNumericValue(st.charAt(i))*(Math.pow(2,j));
            j++;
            if(j==4) {
                if (sum > 9) {
                    st1 = st1 + map.get(sum);
                } else {
                    st1 = st1 + sum;
                }
                sum = 0;
                j = 0;
            }
        }
        if(st.length()%4!=0) {
            st1 = st1 + sum;
        }
        System.out.print("0X");
        for(i=st1.length()-1;i>=0;i--){
            System.out.print(st1.charAt(i));
        }
    }
}
