package ejercicio2Tema1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicio2Tema1.modelo.Cliente;

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

}
