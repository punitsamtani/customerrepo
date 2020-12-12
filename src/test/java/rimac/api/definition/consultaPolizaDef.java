package rimac.api.definition;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import rimac.app.step.consultaPolizaStep;

public class consultaPolizaDef {

	private consultaPolizaStep oConsultaPolizaStep = new consultaPolizaStep();
	private String jsonResponse;
	String request;

	@Given("^realizo la configuracion del request con los siguientes campos \"([^\"]*)\" y \"([^\"]*)\"$")
	public void realizo_la_configuracion_del_request_con_los_siguientes_campos_y(String nombre, String descripcion) {
		request = oConsultaPolizaStep.formarRequest(nombre, descripcion);
	}

	@When("^envio mi request$")
	public void envio_mi_request() {
		jsonResponse = oConsultaPolizaStep.enviarBody(request);
		System.out.println(jsonResponse.toString());
	}
	
	@Then("^Valida el primer valor \"([^\"]*)\" de la consulta$")
	public void valida_el_primer_valor_de_la_consulta(String valorEsperado) {
		assertEquals(oConsultaPolizaStep.obtenerPrimerValor(), valorEsperado);
	}
}
