package ejercicio1Tema1.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicio1Tema1.dao.Dao;
import ejercicio1Tema1.modelo.Pelicula;

public class PeliculaService {

	
	
	
	public List<Pelicula> consultarPeliculas() throws SQLException, PeliculaServiceException{
		List<Pelicula> lista = new ArrayList<>();
		List<Pelicula> listadef = new ArrayList<>();
		OpenConnection oc = new OpenConnection();
		Dao dao = new Dao();
		Connection conn = null;
		conn= oc.getConnection();
		lista = dao.consultarPeliculas(conn);
		for (Pelicula pelicula : lista) {
			if(pelicula.getLongitud()<100) {
				listadef.add(pelicula);
			}
		}
		return listadef;
	}
	
}
