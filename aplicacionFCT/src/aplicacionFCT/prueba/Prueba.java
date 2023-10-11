package aplicacionFCT.prueba;

import aplicacionFCT.exceptions.FCTServiceException;
import aplicacionFCT.modelo.Usuario;
import aplicacionFCT.servicio.UsuarioService;

public class Prueba {
	public static void main(String[] args) {
		UsuarioService uSe = new UsuarioService();
		Usuario us = new Usuario();

		try {
			us = uSe.login("prueba", "password");
			uSe.alta(us);
			System.out.println(us);
		} catch (FCTServiceException e) {
			e.printStackTrace();
		}
	}
}
