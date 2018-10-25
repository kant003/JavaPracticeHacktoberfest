import java.util.Scanner;
public class calculadora {

	public static void main(String[] args) {
		
			int menu;
			double a,b,resul;
			
			//recogemos conun escaner la operacion que el usuario quiere realizar
			  do{
				  
			Scanner sc = new Scanner (System.in);
			
				System.out.println("Bienvenido a su calculadora ");
				System.out.println();
				System.out.println();
				System.out.println("Para hacer una suma pulse 1 "); 		 
				System.out.println("Para hacer una resta pulse 2 "); 		 
			    System.out.println("Para hacer una multiplicación pulse 3 "); 		 
				System.out.println("Para hacer una division pulse 4 "); 		 
				System.out.println("Para  salir del programa pulse 0 "); 		
			 
			  menu=sc.nextInt();
			  
			  //hacemos un do while con un swith que decida que operaciones se van a realizar en funcion del valor recogido en el escaner.
			  
			
				  switch (menu){
				  
					 case 1:
						 System.out.println("Usted ha seleccionado realizar una suma");
						 System.out.println("Introduzca el primer operador a sumar");
						 	a=sc.nextInt();
						 
						 System.out.println("introduzca el segundo operador a sumar: ");
						 	b=sc.nextInt();
						 	
						 	resul=a+b;
						 	System.out.println("El resultado de la suma es: " + resul);
						 	 System.out.println();
						 	 System.out.println();
						 	
						 
						 break;
					 
					 case 2:
						 System.out.println("Usted ha seleccionado realizar una resta");
						 System.out.println("Introduzca el primer operador a restar");
						 	a=sc.nextInt();
						 
						 System.out.println("introduzca el segundo operador a restar: ");
						 	b=sc.nextInt();
						 	
						 	resul=a-b;
						 	System.out.println("El resultado de la resta es: " + resul);
						 	 System.out.println();
						 	 System.out.println();
						 break;
						 
						 
					 case 3:
						 System.out.println("Usted ha seleccionado realizar una multiplicación");	
						 System.out.println("Introduzca el primer operador a multiplicar");
						 	a=sc.nextInt();
						 
						 System.out.println("introduzca el segundo operador a multiplicar: ");
						 	b=sc.nextInt();
						 	
						 	resul=a*b;
						 	System.out.println("El resultado de la multiplicación es: " + resul);
						 	 System.out.println();
						 	 System.out.println();
						 break;
						 
					 case 4:
						 System.out.println("Usted ha seleccionado realizar una division");
						 System.out.println("Introduzca el primer operador a dividir");
						 	a=sc.nextInt();
						 
						 System.out.println("introduzca el segundo operador a dividir: ");
						 	b=sc.nextInt();
						 	
						 	resul=a/b;
						 	System.out.println("El resultado de la division es: " + resul);
						 	 System.out.println();
						 	 System.out.println();
						 break;
						 
					 case 0:
						 System.out.println("Usted ha salido del programa");
						 break;		
						 
						 default:
							 System.out.println("No ha introducido un número valido para realizar alguna operacion");
							 System.out.println();
							 
				  }
				  
			  }while(menu!=0);
			
		}

	}
