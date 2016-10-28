public class UtilidadesString {
     
     
    public static int longitud(String s){
         
        int l;
        l = s.length();
         
        return l;        
    }
     
    public static int contar(String s, Character a){
         
        int contar = 0;
        int i;
         
        for(i=0;i<s.length();i++){
            if (s.charAt(i) == a){
                contar = contar + 1;
            }
        }
        return contar;
    }
     
    public static int contarVocales(String s){
         
        int vocales = 0;
        int i;
        String voc = "aeiouAEIOU";
        for(i=0;i<s.length();i++){
            String letra = String.valueOf(s.charAt(i));
            if (voc.contains(letra)){
                vocales = vocales + 1;
            }
        }
         
        return vocales;
    }
}
