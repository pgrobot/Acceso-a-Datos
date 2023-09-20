package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Actor;
import servicio.ActorServiceException;
import servicio.ActoresService;

public class App {

	
	public static void main(String[] args)  {
		ActoresService service = new ActoresService();

		
		List<Actor> actores = new ArrayList<>();
		try {
			actores = service.consultarActores();
		} catch (ActorServiceException | SQLException e) {
			e.printStackTrace();
		} 
		
		for (Actor actor : actores) {
			System.out.println(actor);
		}
		
	}
	
	
	
}
