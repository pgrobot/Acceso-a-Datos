package ejercicio1Tema1.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ejercicio1Tema1.dao.Dao;
import ejercicio1Tema1.modelo.Pelicula;

public class PeliculaService {

	public List<Pelicula> consultarPeliculas() throws PeliculaServiceException {
		List<Pelicula> lista = new ArrayList<>();

		OpenConnection oc = new OpenConnection();
		Dao dao = new Dao();
		Connection conn = null;
		try {
			conn = oc.getConnection();
		} catch (SQLException e) {
			throw new PeliculaServiceException("Hay algun error con las peliculas");
		}
		lista = dao.consultarPeliculas(conn);

		for (Iterator<Pelicula> iterator = lista.iterator(); iterator.hasNext();) {
			Pelicula pelicula = (Pelicula) iterator.next();
			if (pelicula.getLongitud() >= 100) {
				iterator.remove();
			}
		}

		return lista;

	}

}
