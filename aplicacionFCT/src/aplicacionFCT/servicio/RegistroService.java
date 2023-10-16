package aplicacionFCT.servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aplicacionFCT.bd.OpenConnection;
import aplicacionFCT.dao.DaoRegistro;
import aplicacionFCT.exceptions.FCTServiceException;
import aplicacionFCT.modelo.Registro;

public class RegistroService {

	private DaoRegistro dR;
	private OpenConnection oc;

	public RegistroService() {
		this.oc = new OpenConnection();
		this.dR = new DaoRegistro();
	}

	public void nuevoRegistro(Registro reg) throws FCTServiceException {
		Registro regi;

		Connection conn = null;
		try {
			conn = oc.getConnection();
			regi = dR.consultarRegistro(conn, reg);
			if (regi == null) {
				dR.insertarRegistro(reg, conn);
			} else {
				throw new FCTServiceException("Hay un registro de este usuario ese dia");
			}

		} catch (SQLException e) {
			throw new FCTServiceException("Hay algun error con la base de datos" + e, e);
		} finally {

			try {
				conn.close();
			} catch (SQLException e) {

			}

		}

	}

	public List<Registro> consultarListaRegistro(Long idUsuario) throws FCTServiceException {
		List<Registro> lista = new ArrayList<>();
		Connection conn = null;
		try {
			conn = oc.getConnection();
			lista = dR.consultarListaRegistro(idUsuario, conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FCTServiceException("Hay un error en la base de datos" + e, e);
		}

		return lista;

	}

}
