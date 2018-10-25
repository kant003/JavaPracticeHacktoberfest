package capitulo.dos;

public class TestPajaro {

	public static void main(String[] args) {

		Pajaro pj1 = new Pajaro();
		Pajaro pj2 = new Pajaro("felipe", 2, 'v', true);

		pj1.setNombre("felipa");
		pj1.setColorPlumas('r');
		pj1.setEdad(2);
		pj1.setDomestico(true);

//		System.out.println("nombre: " + pj1.getNombre());
//		System.out.println("edad: " + pj1.getEdad());
//		System.out.println("domestico: " + pj1.isDomestico());
//		System.out.println("color: " + pj1.getColorPlumas());

//		System.out.println(pj1);

//		System.out.println("nombre: " + pj2.getNombre());
//		System.out.println("edad: " + pj2.getEdad());
//		System.out.println("domestico: " + pj2.isDomestico());
//		System.out.println("color: " + pj2.getColorPlumas());

		System.out.println(pj2);
		System.out.println(pj2.toString());
		
		pj2.printedad();
		pj2.printcolor();
		
		
		
		
	}

}
