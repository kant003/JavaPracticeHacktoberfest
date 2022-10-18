public class SquareRoot{

    public static void main(String args[]) {
     
        Scanner scanner = new Scanner(System.in);
     
        System.out.println("Enter number to find square root in Java : ");
     
        //getting input number from user to calculate square root
        double square = scanner.nextDouble();
     
     
        //getting the square root of a number in Java
        double squareRoot = Math.sqrt(square);
     
        //printing number and its square root in Java
        System.out.printf("Square root of number: %f is : %f %n" , square, squareRoot);
   
    }
}