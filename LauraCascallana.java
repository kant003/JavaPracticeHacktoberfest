public class LauraCascallana {
    public static char getLetras(){
        return (char)(Math.random()*26 + 'a');}
        
        public static void main(String[] args) {
            int numero=0;
            char c;
        for(int i=0;i<15;i++) {
            c=getLetras();
            System.out.println("generado: "+c);
                if ( (c=='a') || (c=='e') || (c=='i') || (c=='o') || (c=='u') ){
                    numero++;
                    System.out.println("vocal");
                    }
        }						
                
            System.out.println("Hemos generado "+numero+ " vocales ");
            System.out.println("hemos generado "+(15-numero)+" consonantes");
    }

}

