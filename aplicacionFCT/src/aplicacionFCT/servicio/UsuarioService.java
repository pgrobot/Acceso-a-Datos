package aplicacionFCT.servicio;

import java.sql.Connection;
import java.sql.SQLException;

import aplicacionFCT.bd.OpenConnection;
import aplicacionFCT.dao.DaoUsuario;
import aplicacionFCT.exceptions.FCTServiceException;
import aplicacionFCT.modelo.Usuario;

public class UsuarioService {

	private DaoUsuario dU;
	private OpenConnection oc;

	public UsuarioService() {

		this.oc = new OpenConnection();
		this.dU = new DaoUsuario();
	}

	public Usuario login(String email, String password) throws FCTServiceException {
		Usuario us;
		Connection conn = null;

		try {
			conn = oc.getConnection();
			us = dU.consultarUsuario(conn, email);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FCTServiceException("Hay algun error con la base de datos" + e, e);
		}
		try {
			conn.close();
		} catch (SQLException e) {

		}

		return us;
	}

	public void alta(Usuario us) throws FCTServiceException {
		Connection conn = null;
		try {
			conn = oc.getConnection();
			conn.setAutoCommit(false);
			if (dU.consultarUsuario(conn, us.getEmail()) == null) {
				dU.insertarUsuario(conn, us);
			} else {
				throw new FCTServiceException("Hay un usuario con ese email");
			}
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {

				}
			}
			throw new FCTServiceException("Hay algun error con la base de datos" + e, e);
		} finally {

			try {
				conn.close();
			} catch (SQLException e) {

			}

		}

	}

}
