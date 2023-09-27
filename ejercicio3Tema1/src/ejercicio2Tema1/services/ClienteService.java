package ejercicio2Tema1.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio2Tema1.dao.Dao;
import ejercicio2Tema1.modelo.Cliente;
import ejercicio2Tema1.modelo.Pago;

public class ClienteService {

	public Map<String, List<Pago>> consultarPagos() throws ClienteServiceException {

		List<Cliente> listaCliente = new ArrayList<>();
		Map<String, List<Pago>> mapa = new HashMap<>();

		Dao dao = new Dao();
		OpenConnection oc = new OpenConnection();
		Connection conn = null;
		try {
			conn = oc.getConnection();
			listaCliente = dao.consultarclientes(conn);
			for (Cliente cliente : listaCliente) {
				List<Pago> listaPagos = new ArrayList<>();
				listaPagos = dao.consultarPagos(conn, cliente.getId());
				mapa.put(cliente.getEmail(), listaPagos);
			}

		} catch (SQLException e) {
			
			throw new ClienteServiceException("Problema con los clientes",e);
		}//cerrar conexion
		

		return mapa;
	}

}
