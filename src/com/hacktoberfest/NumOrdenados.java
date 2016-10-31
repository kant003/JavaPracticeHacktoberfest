
package com.hacktoberfest;
import java.util.Scanner;

public class NumOrdenados {
public static void main(String[] args) {
		
		int a,b,c;
		 
		 Scanner sc = new Scanner (System.in);
		 
		 System.out.println("Introduzca primer número: "); 
		 a=sc.nextInt();
		 
		 System.out.println("Introduzca segundo número: ");
		 b=sc.nextInt();
		 
		 System.out.println("Introduzca tercer número: ");
		 c=sc.nextInt();
		 
		 
		if(a>b && b>c)
        {System.out.println( a+", "+b+", "+ c);}  
      
		else{      
          
          if(a>c && c>b) 
            {System.out.println(a+", "+c+", "+b);}
          
          else{ 
               
                if(b>a && a>c)  
                    {System.out.println(b+", "+a+", "+c); }
                 
                else{           
                     
                        if(b>c && c>a)   
                            {System.out.println(b+", "+c+", "+a);}
                         
                        else{     
                             
                            if(c>a && a>b)
                                {System.out.println(c+", "+a+", "+b);}
                             
                            else{     
                                 
                                if(c>b && b>a)             
                                    {System.out.println(c+", "+b+", "+a); }
                                }  //else
                            }//else
                        }//else
              }//else
          }//else
          
    }
}


