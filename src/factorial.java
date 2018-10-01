// Enter number forwhich factorial to be calculated as argument 1
class Factorial  
 public static void main(String args[]){  
  int i,fact=1;  
  int number=args[1];
  for(i=1;i<=number;i++){    
      fact=fact*i;    
  }    
  System.out.println("Factorial of "+number+" is: "+fact);    
 }  
}  
