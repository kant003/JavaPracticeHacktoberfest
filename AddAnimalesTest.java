package testeoBBD2;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddAnimalesTest {
	Granja g ;
	int  numeroAnimales;
	@Given("^no hay ningun animal en la granja$")
	public void no_hay_ningun_animal_en_la_granja() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		g = new Granja();
	}

	@When("^a?ado (\\d+) cerdos en la granja$")
	public void a_ado_cerdos_en_la_granja(int cantidad) throws Throwable {
		   // Write code here that turns the phrase above into concrete actions
		for(int i = 0; i<cantidad;i++) {
		Cerdo cerdo = new Cerdo();
	    g.add(cerdo);
		}
	}

	@Then("^en la granja habra (\\d+) cerdos$")
	public void en_la_granja_habra_cerdos(int cantidad) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   int numeroAnimalesGranja = g.getNumeroAnimales();
	   assertEquals(cantidad,numeroAnimalesGranja);
	}
	
	@When("^cuando verifico el numero de animales$")
	public void cuando_verifico_el_numero_de_animales() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	numeroAnimales =  g.getNumeroAnimales();
	   
	}

	@Then("^obtengo (\\d+) animales$")
	public void obtengo_animales(int cantidad) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(cantidad,numeroAnimales);
	}

}
