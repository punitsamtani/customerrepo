package rimac.api.definition;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.ibm.icu.impl.InvalidFormatException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jcifs.smb.NtlmPasswordAuthentication;
import net.thucydides.core.annotations.Steps;
import rimac.api.inout.SECotizacionInout;
import rimac.api.inout.SECotizacionInout.CotizacionSAS;
import rimac.api.request.ServicioCotizacion.CotizacionFlexiVida;
import rimac.api.response.ServicioCotizacion.BodyCotizacion;
import rimac.api.step.CotizacionStep;
import rimac.api.step.CotizacionStep.ResponseCotizacion;
import rimac.api.util.UtilReport;
import rimac.api.util.Variables;
import rimac.util.ExcelUtil;

public class RealizarCotizacionFlexividaDefinition {
	
	@Steps
	private CotizacionStep cotizacionStep;
	
	private BodyCotizacion jsonResponse;
	private String jsonRequest ="";
	String ideProd="";
	String idePlan="";
	String idpMoneda="";
	String ideCanal="";
	String ideUsuario="";
	String ideVendedor="";
	String codRamo="";
	String nombre="";
	String descripcion="";
	String ideTipoRelTer="";
	String nombreDPAseg="";
	String descripcionDPAseg="";
	
	String ideProdcony="";
	String idePlancony="";
	String idpMonedacony="";
	String ideVendedorcony="";
	
	////////////////////////////
	//Ronald
	//Datos de la covertura
	String ideComp="";
	String nombreDPCober="";
	String descripcionDPCober="";
	
	
	String	ideTipoRelTercony="";
	String nombreDPAsegcony ="";
	String descripcionDPAsegcony ="";
	
	String ideCompcony ="";
	String nombreDPCobercony="";
	String descripcionDPCobercony ="";
	
	String ideTipoRelTerTit ="";
	String ideTipoRelTerCony ="";
	String ideTipoRelTerHij ="";
	String ideTipoRelTerPad ="";
	////////////////////////////
	
	static int contadorEscenario1=0;
	static int contadorEscenario2=0;
	static int contadorEscenario3=0;
	static int contadorEscenario4=0;
	ResponseCotizacion cotizacionRRGG;
	CotizacionSAS cotizacionSAS;
	SECotizacionInout sECotizacionInout = new SECotizacionInout();
	UtilReport utilReport= new UtilReport();
	ExcelUtil excelUtil = new ExcelUtil();

	
	
	@Given("^accedo al servicio de cotizacion$")
	public void accedo_al_servicio_de_cotizacion() {
	    // Write code here that turns the phrase above into concrete actions
		cotizacionStep.usuarioIngresaAlServicio("CrearCotizacion");
	}


	@When("^ingreso los datos del plan \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void ingreso_los_datos_del_plan(String oideProd, String oidePlan, String oidpMoneda) {
	    ideProd=oideProd;
	    idePlan=oidePlan;
	    idpMoneda=oidpMoneda;
	    contadorEscenario1++;
	    
	}

	@When("^ingreso los datos del usuario \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void ingreso_los_datos_del_usuario(String oideVendedor, String oideCanal, String oideUsuario) {
	    // Write code here that turns the phrase above into concrete actions
		ideVendedor=oideVendedor;
		ideCanal=oideCanal;
		ideUsuario=oideUsuario;
	}

	@When("^ingreso los datos particulares \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void ingreso_los_datos_particulares(String ocodRamo, String onombre, String odescripcion) {
	    // Write code here that turns the phrase above into concrete actions
		codRamo=ocodRamo;
		nombre=onombre;
		descripcion=odescripcion;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////

	@When("^ingreso los datos del parentesco \"([^\"]*)\"$")
	public void ingreso_los_datos_del_parentesco(String oideTipoRelTer) {
	    // Write code here that turns the phrase above into concrete actions
		ideTipoRelTer=oideTipoRelTer;
		
	}
	
	
	@When("^ingreso los parentescos \"([^\"]*)\",\"([^\"]*)\"$")
	public void ingreso_lo_parentescos(String oideTipoRelTer, String oideTipoRelTer2 ) {
	    // Write code here that turns the phrase above into concrete actions
		ideTipoRelTerTit=oideTipoRelTer;
		ideTipoRelTerCony=oideTipoRelTer2;
		
		
	}

	@When("^ingreso los datos particulares de los asegurados \"([^\"]*)\",\"([^\"]*)\"$")
	public void ingreso_los_datos_particulares_de_los_asegurados(String onombreDP, String odescripcionDP) {
	    // Write code here that turns the phrase above into concrete actions
		nombreDPAseg=onombreDP;
		descripcionDPAseg=odescripcionDP;
	}

	@When("^ingreso los componentes de los asegurados$")
	public void ingreso_los_componentes_de_los_asegurados() {
	    // Write code here that turns the phrase above into concrete actions
		jsonRequest= new CotizacionFlexiVida().crearJsonCotizacionFlexivida(ideProd, idePlan, idpMoneda, ideVendedor, ideCanal, ideUsuario, codRamo, nombre, descripcion, ideTipoRelTer, nombreDPAseg, descripcionDPAseg, ideComp, nombreDPCober, descripcionDPCober);
		System.out.println("REQUEST "  + jsonRequest);
	}
	
	@When("^ingreso los componentes de varios asegurados$")
	public void ingreso_los_componentes_de_varios_asegurados() {
	    // Write code here that turns the phrase above into concrete actions

		jsonRequest= new CotizacionFlexiVida().crearJsonCotizacionFlexividaVariosAsegurados(ideProd, idePlan, idpMoneda, ideVendedor, ideCanal, ideUsuario, codRamo, nombre, descripcion, ideTipoRelTerTit, nombreDPAseg, descripcionDPAseg, ideComp, nombreDPCober, descripcionDPCober, ideTipoRelTerCony, nombreDPAsegcony, descripcionDPAsegcony, ideCompcony, nombreDPCobercony, descripcionDPCobercony);
		System.out.println("CONYUGE  "  + nombreDPCobercony);
	}

	

	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	//Ronald
	///Datos de la cobertura
	

		@When("^ingreso los datos de la cobertura \"([^\"]*)\"$")
		public void ingreso_los_datos_de_la_cobertura(String oideComp) {
		    // Write code here that turns the phrase above into concrete actions
		    ideComp=oideComp;
		}
		
		
		@When("^ingreso los datos particulares de la cobertura \"([^\"]*)\",\"([^\"]*)\"$")
		public void ingreso_los_datos_particulares_de_la_cobertura(String onombre, String odescripcion) {
		    // Write code here that turns the phrase above into concrete actions
		    nombreDPCober=onombre;
		    descripcionDPCober=odescripcion;
		}
		
		
		@When("^ingreso los datos particulares varios asegurados \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
		public void ingreso_los_datos_particulares_varios_asegurados(String nombreDPasegTit, String descDPasegTit, String nombreDPasegCony, String descDPasegCony) {
		    // Write code here that turns the phrase above into concrete actions
			nombreDPAseg=nombreDPasegTit;
			descripcionDPAseg=descDPasegTit;
			nombreDPAsegcony=nombreDPasegCony;
			descripcionDPAsegcony=descDPasegCony;
		    
		}

		@When("^ingreso los datos de la cobertura de varios asegurados \"([^\"]*)\",\"([^\"]*)\"$")
		public void ingreso_los_datos_de_la_cobertura_de_varios_asegurados(String idecomptit, String idecompcony) {
		    // Write code here that turns the phrase above into concrete actions
		    ideComp=idecomptit;
		    ideCompcony=idecompcony;
		}
		
		@When("^ingreso los datos particulares de la cobertura de varios asegurados \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
		public void ingreso_los_datos_particulares_de_la_cobertura_de_varios_asegurados(String onombreDPCober, String odescripcionDPCober, String onombreDPCobercony, String odescripcionDPCobercony) {
		    // Write code here that turns the phrase above into concrete actions
			nombreDPCober=onombreDPCober;
		    descripcionDPCober=odescripcionDPCober;
		    nombreDPCobercony=onombreDPCobercony;
		    descripcionDPCobercony=odescripcionDPCobercony;

		}
	
	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	
	@When("^realizo la cotizacion del producto Flexivida$")
	public void realizo_la_cotizacion_del_producto_Flexivida() {
	    // Write code here that turns the phrase above into concrete actions
		jsonResponse = cotizacionStep.conexion(jsonRequest);
		ResponseCotizacion responseCotizacion =cotizacionStep.procesarResponse();
	}

	@Then("^se debe mostrar correctamente el cálculo de la prima para el titular$")
	public void se_debe_mostrar_correctamente_el_calculo_de_la_prima_para_el_titular() {
	    // Write code here that turns the phrase above into concrete actions
		Double primaNeta= cotizacionStep.obtenerPrimaNeta();
		String numCotizacion = cotizacionStep.obtenerCotizacion();
		//Ronald
		//Agregó la moneda tipomoneda y la profesión del asegurado
		String tipoMoneda = cotizacionStep.obtenerMoneda();
		String profesion = cotizacionStep.obtenerProfesion();
		String tiporenta = cotizacionStep.obtenerTiporenta();
		
		//Reporte
		utilReport.showStepMessage("Prima Neta "+primaNeta);
	    utilReport.showStepMessage("Cotizacion "+numCotizacion);
	    utilReport.showStepMessage("Moneda "+tipoMoneda);
	    utilReport.showStepMessage("Profesión "+profesion);
	    utilReport.showStepMessage("Tiporenta "+tiporenta);
	    
	 
	    //Almacena valores de numero de cotizacion y prima neta en el excel de data de prueba
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
			ExcelUtil.WriteCellName("NumCotizacion", contadorEscenario1, ""+numCotizacion);
			ExcelUtil.WriteCellName("PrimaNeta", contadorEscenario1, ""+primaNeta);
			ExcelUtil.WriteCellName("Moneda", contadorEscenario1, ""+tipoMoneda);
			ExcelUtil.WriteCellName("Profesion", contadorEscenario1, ""+profesion);
			ExcelUtil.WriteCellName("TipoRenta", contadorEscenario1, ""+tiporenta);
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
	    
	}
	
	@Then("^se debe mostrar correctamente el cálculo de la prima para el titular sin coberturas$")
	public void se_debe_mostrar_correctamente_el_calculo_de_la_prima_para_el_titular_sin_coberturas() {
	    // Write code here that turns the phrase above into concrete actions
		contadorEscenario2++;
		Double primaNeta= cotizacionStep.obtenerPrimaNeta();
		String numCotizacion = cotizacionStep.obtenerCotizacion();
		//Ronald
		//Agregó la moneda tipomoneda y la profesión del asegurado
		//Reporte
		utilReport.showStepMessage("Prima Neta "+primaNeta);
	    utilReport.showStepMessage("Cotizacion "+numCotizacion);
 
	    //Almacena valores de numero de cotizacion y prima neta en el excel de data de prueba
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
	    	
			excelUtil.inciarExcel(ruta, Variables.Escenario2);
			ExcelUtil.WriteCellName("NumCotizacion", contadorEscenario2, ""+numCotizacion);
			ExcelUtil.WriteCellName("PrimaNeta", contadorEscenario2, ""+primaNeta);

			ExcelUtil.CloseExcel();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("CONTADOR FILA contadorEscenario2 "  + contadorEscenario2);
	    
	}
	
	@Then("^se debe mostrar correctamente el cálculo de la prima para todos los asegurados$")
	public void se_debe_mostrar_correctamente_el_calculo_de_la_prima_para_todos_los_asegurados() {
	    // Write code here that turns the phrase above into concrete actions
		contadorEscenario3++;
		Double primaNeta= cotizacionStep.obtenerPrimaNeta();
		String numCotizacion = cotizacionStep.obtenerCotizacion();
		//Ronald
		//Agregó la moneda tipomoneda y la profesión del asegurado
		//Reporte
		utilReport.showStepMessage("Prima Neta "+primaNeta);
	    utilReport.showStepMessage("Cotizacion "+numCotizacion);
 
	    //Almacena valores de numero de cotizacion y prima neta en el excel de data de prueba
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
	    	
			excelUtil.inciarExcel(ruta, Variables.Escenario3);
			ExcelUtil.WriteCellName("NumCotizacion", contadorEscenario3, ""+numCotizacion);
			ExcelUtil.WriteCellName("PrimaNeta", contadorEscenario3, ""+primaNeta);

			ExcelUtil.CloseExcel();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("CONTADOR FILA contadorEscenario3 "  + contadorEscenario3);
	    
	}
	
	
	@Then("^se muestra la prima neta y el numero de cotizacion y el tipo de renta$")
	public void se_muestra_la_prima_neta_y_el_numero_de_cotizacion_y_el_tipo_de_renta() {
		
		contadorEscenario4++;
	    // Write code here that turns the phrase above into concrete actions
		Double primaNeta= cotizacionStep.obtenerPrimaNeta();
		String numCotizacion = cotizacionStep.obtenerCotizacion();
		String tipoMoneda = cotizacionStep.obtenerMoneda();
		String tiporenta = cotizacionStep.obtenerTiporenta();
		String rentaesperada =cotizacionStep.obtenerrentaesperada();
		//Reporte
		utilReport.showStepMessage("Prima Neta "+primaNeta);
	    utilReport.showStepMessage("Cotizacion "+numCotizacion);
	    utilReport.showStepMessage("Moneda "+tipoMoneda);
	    utilReport.showStepMessage("Tiporenta "+tiporenta);
	    utilReport.showStepMessage("TiporentaEsperado "+rentaesperada);
	    
	    assertEquals(rentaesperada, tiporenta);
	    //Almacena valores de numero de cotizacion y prima neta en el excel de data de prueba
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
	    	
			excelUtil.inciarExcel(ruta, Variables.Escenario4);
			ExcelUtil.WriteCellName("NumCotizacion", contadorEscenario4, ""+numCotizacion);
			ExcelUtil.WriteCellName("PrimaNeta", contadorEscenario4, ""+primaNeta);			
			ExcelUtil.WriteCellName("TipoRenta", contadorEscenario4, ""+tiporenta);
			ExcelUtil.WriteCellName("TipoRentaEsperado", contadorEscenario4, ""+rentaesperada);
			ExcelUtil.CloseExcel();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("CONTADOR FILA "  + contadorEscenario4);
	    
	}

		
	

}
