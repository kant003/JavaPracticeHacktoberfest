import java.util.Scanner;

public class iagocenteno {
    
    public static void main(String[] args) {
		double base;
		double altura;
		double perimetro;
		double area;
	    Scanner sc= new Scanner(System.in);
		System.out.println("Dame la base");
		base=sc.nextInt();
		System.out.println("Dame la altura");
		altura=sc.nextInt();
		perimetro= 2*(base+altura);
		area=base*altura;
		System.out.println("El perimetro es " + perimetro);
		System.out.println("El area es " + area);
		sc.close();

	}

}

