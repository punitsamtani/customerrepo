package rimac.api.inout;

import java.util.ArrayList;
import java.util.List;



public class SECotizacionInout {
	
	public CotizacionSAS cotizarEnSAS (String claseVehiculo, String tipoVehiculo, String marca, String modelo, String placa, String uso, String anhoFabricacion, String suma, String zona) {
		
		CotizacionSAS responseSAS = new CotizacionSAS();
		
		responseSAS.idPlanes.add(532857);
		responseSAS.idPlanes.add(532831);
		responseSAS.idPlanes.add(532844);
		
		responseSAS.desPlanes.add("(ADVERTENCIA: FASE TEST) CANAL BANCO BBVA PERÚ - BESITO (05-12-2018) - SAS ");
		responseSAS.desPlanes.add("(ADVERTENCIA: FASE TEST) CANAL BANCO BBVA PERÚ - BESO FRANCÉS (05-12-2018) - SAS ");
		responseSAS.desPlanes.add("(ADVERTENCIA: FASE TEST) CANAL BANCO BBVA PERÚ - PIQUITO (05-12-2018) - SAS");
		
		responseSAS.primaNeta.add(431.25);
		responseSAS.primaNeta.add(552.69);
		responseSAS.primaNeta.add(248.4);
		
		return responseSAS;
	}
	
	public class CotizacionSAS {
		
		public List<Integer> idPlanes;
		public List<String> desPlanes;
		public List<Double> primaNeta;
		
		public CotizacionSAS(){
			idPlanes = new ArrayList<Integer>();
			desPlanes = new ArrayList<String>();
			primaNeta = new ArrayList<Double>();
		}
	}
}
