public class Variables {

	public static void main(String[] args) {

		
		byte a=7;
		System.out.println("la variable de tipo byte llamada a tiene asignado el valor: "+a);
		
		short b, c=3;
		System.out.println("valor de c: "+c);
		
		int d = -30;
		
		int e = 0xC125;
		System.out.println("valor de e: " +e);
		
		long bprim=434123 ;
		
		long bseg=5L ; /* la L en este caso indica Long*/
		
		System.out.println("vale :"+ bseg);
		
		char car1='c';
		
		char car2=12345;
		
		System.out.println("car1 vale: "+car1);
		System.out.println("car2 vale: "+car2);
		
		
		float pi= (float) 3.1416;
		System.out.println("pi vale: "+pi);
		
		//error de precision
		
		float piseg=3.1416f; /* la F en este caso indica Float*/
		System.out.println("piseg vale: "+piseg);
		
		float conf=1/2f; /*0.5*/
		System.out.println("conf: "+conf);
		
		float sinf= 1/2;
		System.out.println("sinf: "+sinf);
		
		double millon=1e6; /* 1x106 */
		
		double medioprim=1/2d; /*0.5 la D en este caso indica Double*/
		
		
	}

}