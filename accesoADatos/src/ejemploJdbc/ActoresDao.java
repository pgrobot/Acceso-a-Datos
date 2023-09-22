package ejemploJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Actor;
import servicio.ActorServiceException;

public class ActoresDao {
	public List<Actor> consultarActores(Connection conn) throws ActorServiceException {

		List<Actor> lista = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT * FROM ACTOR";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();
				actor.setId(rs.getInt("actor_id"));
				actor.setNombre(rs.getString("first_name"));
				actor.setApellido(rs.getString("last_name"));
				lista.add(actor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ActorServiceException("Hay algun error con los actores");
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
