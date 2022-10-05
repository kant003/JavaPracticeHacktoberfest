import java.util.*;
import java.lang.*;
class Calculator
{
    static Scanner st = new Scanner(System.in);
    static int firstno, secondno;
    public static void add()
    {
        System.out.println("Enter the first number");
        firstno= st.nextInt();
        System.out.println("Enter the second number");
        secondno= st.nextInt();
        int sum;
        sum=firstno+secondno;
        System.out.println("The sum of two numbers"+sum);
    }
     public static void subtract()
    {
         System.out.println("Enter the first number");
        firstno= st.nextInt();
        System.out.println("Enter the second number");
        secondno= st.nextInt();
        int difference;
        difference =firstno-secondno;
        System.out.println("The difference of two numbers"+difference);
    }
     public static void multiply()
    {
        System.out.println("Enter the first number");
        firstno= st.nextInt();
        System.out.println("Enter the second number");
        secondno= st.nextInt();
        int product;
        product=firstno*secondno;
        System.out.println("The product of two numbers"+product);
    }
     public static void division()
    {
        System.out.println("Enter the first number");
        firstno= st.nextInt();
        System.out.println("Enter the second number");
        secondno= st.nextInt();
        double quotient;
        quotient=((double)firstno/secondno);
        System.out.println("The division of two numbers"+quotient);
    }
     public static void percent()
    {
        System.out.println("Enter the first number");
        firstno= st.nextInt();
        double percent;
        percent=((double)firstno/100);
        System.out.println("The percent of a number"+percent);
    }
     public static void square()
    {
        System.out.println("Enter the first number");
        firstno= st.nextInt();
        double square;
        square=firstno*firstno;
        System.out.println("The square of a number"+square);
    }
     public static void cube()
    {
        System.out.println("Enter the first number");
        firstno= st.nextInt();
        double cube;
        cube=firstno*firstno*firstno;
        System.out.println("The cube of a number"+cube);
    }
     public static void power()
    {
        System.out.println("Enter the first number");
        firstno= st.nextInt();
        System.out.println("Enter the second number");
        secondno= st.nextInt();
        double power;
        power = Math.pow(firstno, secondno);
        System.out.println("The power of two numbers"+power);
    }
     public static void round()
    {
        System.out.println("Enter the first number");
        double input;
        input=st.nextDouble();
        double rounded;
        rounded = Math.round(input);
        System.out.println(rounded);
    }
     public static void floor()
    {
        System.out.println("Enter the first number");
        double input;
        input=st.nextDouble();
        double floorno;
        floorno = Math.floor(input);
        System.out.println("The floor of a number"+floorno);
    }
     public static void ceil()
    {
    	System.out.println("Enter the first number");
    	double input;
        input=st.nextDouble();
        double ceilno;
        ceilno = Math.ceil(input);
        System.out.println("The ceil of a number"+ceilno);
    }
}
public class Calci {
    public static void main(String args[]) {
        
     Scanner sc = new Scanner(System.in);
     Calculator obj = new Calculator();
     
     System.out.println("Enter any digit between 1-9");
     while(sc.nextInt()!=0){
         
     System.out.println("Enter desired character");
     char ch;
     ch=sc.next().charAt(0);
     switch(ch)
     {
     case 'a':{
     obj.add();
     break;
     }
     case 's':{
     obj.subtract();
     break;
     }
     case 'm':{
     obj.multiply();
     break;
     }
     case 'd':{
     obj.division();
     break;
     }
     case 'p':{
     obj.percent();
     break;
      }
     case 'q':{
     obj.square();
     break;
     }
     case 'u':{
     obj.cube();
     break;
     }
     case 'w':{
     obj.power();
     break;
     }
     case 'r':{
     obj.round();
     break;
     }
     case 'f':{
     obj.floor();
     break;
     }
     case 'c':{
     obj.ceil();
     break;
     }
     }
    }
}
}
 
