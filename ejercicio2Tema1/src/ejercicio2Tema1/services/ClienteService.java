package ejercicio2Tema1.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio2Tema1.dao.Dao;
import ejercicio2Tema1.modelo.Cliente;

public class ClienteService {

	public Map<String, Cliente> consultarCliente() throws ClienteServiceException {

		Map<String, Cliente> mapa = new HashMap<>();
		List<Cliente> lista = new ArrayList<>();
		Dao dao = new Dao();
		OpenConnection oc = new OpenConnection();
		Connection conn = null;
		try {
			conn = oc.getConnection();
			lista = dao.consultarclientes(conn);
		} catch (SQLException e) {
			throw new ClienteServiceException("Problema con los clientes");
		}

		for (Cliente cliente : lista) {
			mapa.put(cliente.getEmail(), cliente);
		}

		return mapa;
	}

}
