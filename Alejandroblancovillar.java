public class Alejandroblancovillar {


    public static char getLetras(){
    return (char)(Math.random()*26 + 'a');}
    
    public static void main(String[] args) {
        int numero=0;
        char c;
    //generamos 15 caracteres y los visualizamos
    for(int i=0;i<15;i++) {
        c=getLetras();
        System.out.println("generado: "+c);
            if ( (c=='a') || (c=='e') || (c=='i') || (c=='o') || (c=='u') ){
                numero++;
                System.out.println("vocal");
                }
            //else {System.out.println("consonante");}
    }						
            
        System.out.println("Hemos generado "+numero+ " vocales ");
        System.out.println("hemos generado "+(15-numero)+" consonantes");
        //Fin del bucle
        
        
    
        
        
        /*Condición para ser vocal
    (  if (c=='a') ||	(c=='e') ||	(c=='i') ||	(c=='0') ||	(c=='u') )
          cuento otra vocal
      else
          no cuento otra vocal
      */
    
    
}

}