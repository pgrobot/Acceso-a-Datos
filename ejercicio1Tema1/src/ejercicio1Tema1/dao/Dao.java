package ejercicio1Tema1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicio1Tema1.modelo.Cliente;
import ejercicio1Tema1.services.PeliculaServiceException;

public class Dao {

	public List<Cliente> consultarPeliculas(Connection conn) throws PeliculaServiceException {

		List<Cliente> lista = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT * FROM FILM";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente peli = new Cliente();
				peli.setId(rs.getInt("film_id"));
				peli.setTitulo(rs.getString("title"));
				peli.setLongitud(rs.getInt("length"));
				lista.add(peli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PeliculaServiceException("Hay algun error con las peliculas");
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
