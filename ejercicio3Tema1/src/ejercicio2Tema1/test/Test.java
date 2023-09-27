package ejercicio2Tema1.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio2Tema1.modelo.Pago;
import ejercicio2Tema1.services.ClienteService;
import ejercicio2Tema1.services.ClienteServiceException;

public class Test {

	public static void main(String[] args) {
		ClienteService ce = new ClienteService();

		Map<String, List<Pago>> mapa = new HashMap<>();
		List<Pago> lista = new ArrayList<>();
		try {
			mapa = ce.consultarPagos();
		} catch (ClienteServiceException e) {
			e.printStackTrace();
		}
		
		lista =mapa.get("MARILYN.ROSS@sakilacustomer.org"); 
		for (Pago pago : lista) {
			System.out.println(pago);
		}

	}

}
