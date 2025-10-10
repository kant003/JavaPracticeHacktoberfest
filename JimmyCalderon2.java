public class JimmyCalderon2 {
    public static void main(String[] args) {
        PlanetaTarea p1 = new PlanetaTarea();
        p1.setNombre("Pluton");
        p1.setCantidadSatelites(1);
        p1.setMasa(1231.12);
        p1.setVolumen(123.3333);
        p1.setDiametro(123);
        p1.setDistancia(112333);
        p1.setVistadePlaneta(false);
        p1.setTipo(PlanetaTarea.TipoPlaneta.ENANO);

        System.out.println(p1.toString());
        System.out.println("La densidad de: " + p1.getNombre() + " es de: " + p1.CalcularDensidad());
        System.out.println("Es " + p1.getNombre() + " un planeta exterior?" + p1.esPlanetaExteriorOInterior());

        PlanetaTarea p2 = new PlanetaTarea("Saturno", 1, 553355, 5555, 3223, 12, false,
                PlanetaTarea.TipoPlaneta.GASEOSO);
        System.out.println(p2.toString());
        System.out.println("La densidad de: " + p2.getNombre() + " es de: " + p2.CalcularDensidad());
        System.out.println("Es " + p2.getNombre() + " un planeta exterior?" + p2.esPlanetaExteriorOInterior());

    }
}// fin class
