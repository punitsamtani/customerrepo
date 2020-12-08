package rimac.api.definition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.icu.impl.InvalidFormatException;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import junit.framework.Assert;
import net.thucydides.core.annotations.Steps;
import rimac.api.inout.SECotizacionInout;
import rimac.api.inout.SECotizacionInout.CotizacionSAS;

import rimac.api.request.ServicioFraccionamiento.FraccionamientoFlexiVida;
import rimac.api.response.ServicioCotizacion.BodyCotizacion;
import rimac.api.response.ServicioFraccionamiento.BodyFraccionamiento;
import rimac.api.step.CotizacionStep;
import rimac.api.step.CotizacionStep.ResponseCotizacion;
import rimac.api.step.FraccionamientoStep;
import rimac.api.step.FraccionamientoStep.ResponseFraccionamiento;
import rimac.api.util.ExcelUtilPropio;
import rimac.api.util.UtilReport;
import rimac.api.util.Variables;
import rimac.util.ExcelUtil;

public class RealizarFraccionamientoFlexividaDefinition {
	
	@Steps
	private FraccionamientoStep fraccionamientoStep;
	
	private BodyFraccionamiento jsonResponse;
	private String jsonRequest ="";
	
	
	String ideTransaccion ="";
	String idePlanFinanciamiento ="";
	
	
	////////////////////////////
	
	static int contadorEscenario1=0;
	static int contadorEscenario2=0;
	
	
	
	ResponseFraccionamiento responseFraccionamiento;
	
	//CotizacionSAS cotizacionSAS;
	//SECotizacionInout sECotizacionInout = new SECotizacionInout();
	UtilReport utilReport= new UtilReport();
	ExcelUtil excelUtil = new ExcelUtil();

	

	@Given("^accedo al servicio de fraccionamiento$")
	public void accedo_al_servicio_de_fraccionamiento() {
	    // Write code here that turns the phrase above into concrete actions	    
	    fraccionamientoStep.usuarioIngresaAlServicio("CrearFraccionamiento");
	}
	
	
	@When("^ingreso los datos de la cotizacion \"([^\"]*)\"$")
	public void ingreso_los_datos_de_la_cotizacion(String oidetransaacion) {
	    // Write code here that turns the phrase above into concrete actions
	    ideTransaccion=oidetransaacion;
	}
	
	@When("^ingreso el tipo de fraccionamiento \"([^\"]*)\"$")
	public void ingreso_el_tipo_de_fraccionamiento(String oideplanfinanciamiento) {
	    // Write code here that turns the phrase above into concrete actions
	    idePlanFinanciamiento=oideplanfinanciamiento;
	}
	
	@When("^ingreso los componentes del fraccionamiento$")
	public void ingreso_los_componentes_del_fraccionamiento() {
	    // Write code here that turns the phrase above into concrete actions
		 jsonRequest=new FraccionamientoFlexiVida().crearJsonFraccionamientoFlexivida(ideTransaccion, idePlanFinanciamiento);
		 System.out.println("REQUEST "  + jsonRequest);
	}
	
	@When("^realizo el fraccionamiento del producto Flexivida$")
	public void realizo_el_fraccionamiento_del_producto_Flexivida() {
	    // Write code here that turns the phrase above into concrete actions
	
		jsonResponse = fraccionamientoStep.conexion(jsonRequest);
		ResponseFraccionamiento responseFraccionamiento = fraccionamientoStep.procesarResponse();
		
	}
	
	@Then("^el numero de fraccionamieno$")
	public void el_numero_de_fraccionamieno() {
	    // Write code here that turns the phrase above into concrete actions
		
		
		String numFraccionamiento = fraccionamientoStep.obtenernumFinanciamiento();
		Double primaAhorro =fraccionamientoStep.obtenerPrimaAhorro();
	    Double primaNeta = fraccionamientoStep.obtenerPrimaNeta();
	    Double primaBruta = fraccionamientoStep.obtenerPrimaBruta();
	    Double mtoGiro = fraccionamientoStep.obtenerMontoGiro();
	    String fechaIni = fraccionamientoStep.obtenerFechaInicio();
	    String fechaFin = fraccionamientoStep.obtenerFechaFin();
	    
	    
	    utilReport.showStepMessage("Num Fraccionamiento "+numFraccionamiento);
	    utilReport.showStepMessage("Prima Ahorro "+primaAhorro);
	    utilReport.showStepMessage("Prima Neta "+primaNeta);
	    utilReport.showStepMessage("Prima Bruta "+primaBruta);
	    utilReport.showStepMessage("Monto Giro "+mtoGiro);
	    utilReport.showStepMessage("Fecha Inicio "+fechaIni);
	    utilReport.showStepMessage("Fecha Fin "+fechaFin);
	    
	    
	    String ruta="";

	    if(Variables.UsarRemota.compareTo("SI")==0) {
	    	ruta= Variables.file_remota;
	    	NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Variables.dominioDP, Variables.usuarioDP, Variables.passwordDP);
	    	ruta=excelUtil.absolutPath(auth,ruta);
	       	}else {
	    	ruta=Variables.file_local;	
	    	
	    	 }
	    System.out.println("RUTA "+  ruta);
	    
	    try {
	    		
				excelUtil.inciarExcel(ruta, Variables.Escenario1);
				ExcelUtil.WriteCellName("NumFraccionamiento", contadorEscenario1, ""+numFraccionamiento);
				ExcelUtil.WriteCellName("PrimaNeta", contadorEscenario1, ""+primaNeta);
				ExcelUtil.WriteCellName("PrimaAhorro", contadorEscenario1, ""+primaAhorro);
				ExcelUtil.WriteCellName("PRimaBruta", contadorEscenario1, ""+primaBruta);
				ExcelUtil.WriteCellName("mtoGiro", contadorEscenario1, ""+mtoGiro);
				ExcelUtil.WriteCellName("fechaIni", contadorEscenario1, ""+fechaIni);
				ExcelUtil.WriteCellName("fechaFin", contadorEscenario1, ""+fechaFin);				
				ExcelUtil.CloseExcel();
				
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("CONTADOR FILA "  + contadorEscenario1);
		
	    
		System.out.println("Ok");
		
	}

	
	
	
		
	

}


