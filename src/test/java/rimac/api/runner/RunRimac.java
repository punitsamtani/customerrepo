package rimac.api.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import rimac.api.util.ExcelUtilPropio;

@RunWith(RunPersonalizar.class)

//@CucumberOptions(features = { "src/test/resources/features/" }, tags = { "@Regresion " }, glue = { "rimac.api.definition" })
@CucumberOptions(features = { "src/test/resources/features/" }, tags = { "@cotizacionFlexivida4" }, glue = { "rimac" })

public class RunRimac {

	@RunBefore
	public static void previo() {
		System.out.println("ENTRA AL PREVIO");
		
		
//		ExcelUtilPropio.getInstancia().escribirFeatures();
	}
}