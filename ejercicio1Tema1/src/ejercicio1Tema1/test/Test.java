package ejercicio1Tema1.test;

import java.util.ArrayList;
import java.util.List;

import ejercicio1Tema1.modelo.Pelicula;
import ejercicio1Tema1.services.PeliculaService;
import ejercicio1Tema1.services.PeliculaServiceException;

public class Test {

	public static void main(String[] args) {

		List<Pelicula> lista = new ArrayList<>();
		PeliculaService peliser = new PeliculaService();

		try {
			lista = peliser.consultarPeliculas();
		} catch (PeliculaServiceException e) {
			e.printStackTrace();
		}

		for (Pelicula pelicula : lista) {
			System.out.println(pelicula);
		}

	}

}
