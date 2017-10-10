import java.util.Scanner;


public class findfactorial {
	static int fact(int j){
		
		if(j==0 || j==1)
			return 1;
		else 
			return j*fact(j-1);
	}
public static void main(String args[]){
	/*this is for iterative */
	int f=1;
	int n;
	Scanner x=new Scanner(System.in);
	n=x.nextInt();
	for(int i=2;i<=n;i++){
		f=f*i;
	}
	System.out.println(f);
	System.out.println(fact(n));
}
}
