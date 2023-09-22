package servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejemploJdbc.ActoresDao;
import modelo.Actor;

public class ActoresService {

	public List<Actor> consultarActores() throws ActorServiceException {
		OpenConnection connOpen = new OpenConnection();
		ActoresDao actorD = new ActoresDao();
		Connection conn = null;
		try {
			conn=connOpen.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<Actor> lista = new ArrayList<>();
		lista=actorD.consultarActores(conn);
			try {
				conn.close();
			} catch (Exception e) {

			}
		

		return lista;
	}
}
