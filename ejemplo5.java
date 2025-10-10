package P1Y1;

import java.util.Scanner;

public class ejemplo5 {
	public static void main(String[] args) {
		
		
		int m=2, n=5;
		Scanner sc = new Scanner(System.in);
		System.out.println("dame un entero m ");
		m=sc.nextInt();
		System.out.println("dame un entero n ");
		n=sc.nextInt();
		boolean res;
		res =m > n;//res=false
		System.out.println("m mayor que n: "+res);
		res =m < n;//res=true
		System.out.println("m menor que n: "+res);
		res =m >= n;//res=false
		System.out.println("m mayor o igual que n: "+res);
		res =m <= n;//res=true
		System.out.println("m menor o igual que n: "+res);
		res =(m == n);//res=false
		System.out.println("m igual que n: "+res);
		res =(m != n);//res=true
		System.out.println("m distinto que n: "+res);
		
		System.out.println("fin");
	}

}
