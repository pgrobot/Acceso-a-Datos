package ejercicio2Tema1.test;

import java.util.HashMap;
import java.util.Map;

import ejercicio2Tema1.modelo.Cliente;
import ejercicio2Tema1.services.ClienteService;
import ejercicio2Tema1.services.ClienteServiceException;

public class Test {

	public static void main(String[] args) {
		ClienteService ce = new ClienteService();

		Map<String, Cliente> mapa = new HashMap<>();
		Cliente cli = new Cliente();
		try {
			mapa = ce.consultarCliente();
		} catch (ClienteServiceException e) {
			e.printStackTrace();
		}

		cli = mapa.get("MARILYN.ROSS@sakilacustomer.org");

		System.out.println(cli);

	}

}
