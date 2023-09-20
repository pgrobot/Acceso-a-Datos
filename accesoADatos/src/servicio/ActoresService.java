package servicio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Actor;

public class ActoresService {

	
	
	
	public List<Actor> consultarActores() throws ActorServiceException, SQLException{
		
		List<Actor> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			OpenConnection op = new OpenConnection();
			conn = op.getConnection();

			String sql = "SELECT * FROM ACTOR";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Actor equipo = new Actor();
				equipo.setId(rs.getInt("actor_id"));
				equipo.setNombre(rs.getString("first_name"));
				equipo.setApellido(rs.getString("last_name"));
				lista.add(equipo);
			}
		} catch (SQLException e) {
			throw new ActorServiceException("Hay algun error con los actores");
		}

		finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		}

		return lista;
	}
	}


	

