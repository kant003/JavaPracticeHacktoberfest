// Java Program to find a power of given number
	
// import Scanner class from java.utils
import java.util.Scanner;

// Power class
class Power
{

	// Main class
   public static void main(String arg[])
	
   {
	// n for input
	// p for power
	// r for result
	   
       long n,p,r=1;
	
       Scanner sc=new Scanner(System.in);
 
       System.out.println("enter number");
	  
       n=sc.nextLong();
 
       System.out.println("enter power");
	  
       p=sc.nextLong();
	   
	   //Logic
 
       if(n>=0&&p==0)
       {   
          r =1;
       }
       else if(n==0&&p>=1)
	{   
            r=0;
	} 
       else
	{ 
              for(int i=1;i<=p;i++)
	       { 
                   r=r *n;
 	 	}    
  	 }    
 
	   // output
    	  System.out.println(n+"^"+p+"="+r);
 
    }
 
}
