package ejercicio2Tema1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicio2Tema1.modelo.Cliente;
import ejercicio2Tema1.modelo.Pago;

public class Dao {
	public List<Cliente> consultarclientes(Connection conn) throws  SQLException {

		List<Cliente> lista = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT * FROM CUSTOMER";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setId(rs.getInt("customer_id"));
				cli.setFirstName(rs.getString("first_name"));
				cli.setLastName(rs.getString("last_name"));
				cli.setActivo(rs.getBoolean("active"));
				cli.setEmail(rs.getString("email"));
				lista.add(cli);
			}
		} 

		finally {

			try {
				stmt.close();
			} catch (Exception e) {

			}

		}

		return lista;
	}


	public List<Pago> consultarPagos(Connection conn, Integer id) throws  SQLException {

		List<Pago> lista = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT * FROM PAYMENT WHERE CUSTOMER_ID = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Pago cli = new Pago();
				cli.setFecha(rs.getDate("payment_date").toLocalDate());
				cli.setImporte(rs.getBigDecimal("amount"));
				lista.add(cli);
			}
		} 

		finally {

			try {
				stmt.close();
			} catch (Exception e) {

			}

		}

		return lista;
	}

}
