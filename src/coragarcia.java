import java.util.Scanner;

public class Ejemplo01 {
	public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        float num1, num2, resultado;
        int opcion;

        System.out.println("Dime un numero");
        num1=sc.nextFloat();
        System.out.println("Dime otro numero");
        num2=sc.nextFloat();

        System.out.println("Elige la operación");
        System.out.println("1-Sumar");
        System.out.println("2-Restar");
        System.out.println("3-Multiplicar");
        System.out.println("4-Dividir");
        opcion=sc.nextInt();

        switch(opcion){
            case 1:resultado=num1+num2;break;
            case 2:resultado=num1-num2;break;
            case 3:resultado=num1*num2;break;
            case 4:resultado=num1/num2;break;
        }

        System.out.println("El resultado es "+ resultado);




    }
}