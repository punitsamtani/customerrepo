package rimac.api.util;

public class Variables {


	
	public static int numeroColumnas = 0;
	
	// data driven y otros archivos
	public static final String usar = "X";
	private static final String res = "src/test/resources/dataDriven/";
	public static final String rutaPlantillas = res + "0_plantillas/";
	public static final String ruta = res + System.getProperty("user.name") + "/";


	// data driven y local
	
	private static final String RutaLocal ="src/test/resources/dataDriven/";
	
	// data driven y otros archivos

	private static final String RutaRemota = "smb://172.26.40.137//DataPuebaAutomatizacion//Proy_APIVIDA//datapool//";
	private static final String DataPrueba =  "DataPrueba.xlsx";
	public static final String UsarRemota="NO";
	public static final String Escenario1="01-SimularCotizacion";
	public static final String Escenario2="02-SimularCotizacion";
	public static final String Escenario3="03-SimularCotizacion";
	public static final String Escenario4="04-SimularCotizacion";
	
	//Data de prueba
	public static final String file_remota = RutaRemota + DataPrueba;
	//Data de prueba local
	public static final String file_local = RutaLocal + DataPrueba;
	
	
	public static final String dominioDP ="rimac"; 
	public static final String usuarioDP = "lretamoa"; 
	public static final String passwordDP = "Qatar2022."; 


}
