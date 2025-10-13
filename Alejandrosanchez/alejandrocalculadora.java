package Alejandrosanchez;

import java.util.Scanner;

public class calculadora {

    public static void main(String[] args) {
       int num1=5;
         int num2=10;
         int resultado=0;
         String operacion;
         Scanner teclado = new Scanner(System.in);

        System.out.println("calculadora");
        System.out.println("1.suma");
        System.out.println("2.resta");
        System.out.println("3.multiplicacion");
        System.out.println("4.division");
        System.out.println("ingrese la operacion a realizar (1,2,3,4)");
            operacion=teclado.next();
       System.out.println("ingrese el primer numero");
         num1=teclado.nextInt();
            System.out.println("ingrese el segundo numero");
            num2=teclado.nextInt();
            
            switch (operacion) {
                case "1":
                    resultado=num1+num2;
                    System.out.println("el resultado de la sumas es: "+resultado);
                    break;
                    case "2":
                    resultado=num1-num2;
                    System.out.println("el resultado de la resta es: "+resultado);
                    break;
                    case "3":
                    resultado=num1*num2;
                    System.out.println("el resultado de la  es: "+resultado);
                    break;
                    case "4":
                    if (num2!=0) {
                        resultado=num1/num2;
                    System.out.println("el resultado de la division es: "+resultado);
                    break;
                    }
                    else {
                        System.out.println("no se puede dividir por 0");
                    }
                    break;
            
                default:
                    break;
            }
    }
}
