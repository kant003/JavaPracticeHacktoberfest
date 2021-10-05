public static char generaLetras(){
		return (char)(Math.random()*26 + 'a');
	}
		public static void main(String[] args) {
			
			char a;
			
			boolean esVocal=false;
			char letra;
			letra=generaLetras();
			System.out.println("La letra generada es: "+letra);
			
			esVocal=(letra=='a' || letra=='e' || letra=='i' || letra=='o' || letra=='u');
			
			
			System.out.println("El caracter" +letra+ "es"+esVocal);
