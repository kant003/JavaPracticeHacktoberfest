class restar{

    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer número:");			
        numero1 = sc.nextInt();
			
        System.out.println("Introduce el segundo número:");
        numero2 = sc.nextInt();

        resultado = numero1-numero2;

        System.out.println("La resta es " + numero1 + " - " + numero2 + " = " + resultado);
    }
}