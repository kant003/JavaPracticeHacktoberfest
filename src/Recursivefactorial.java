import java.util.Scanner;


public class findfactorial {
	static int fact(int j){
		
		if(j==0 || j==1)
			return 1;
		else 
			return j*fact(j-1);
	}
public static void main(String args[]){
	/*this is for recursive */
	int n;
	Scanner x=new Scanner(System.in);
	n=x.nextInt();
	System.out.println(fact(n));
}
}
