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
		Registro regi = new Registro();

		Connection conn = null;
		try {
			conn = oc.getConnection();
			conn.setAutoCommit(false);
			if (dR.consultarRegistro(conn, regi) == null) {
				dR.insertarRegistro(regi, conn);
			} else {
				throw new FCTServiceException("Hay un registro de este usuario ese dia");
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

	public List<Registro> consultarListaRegistro(Long id) {
		List<Registro> lista = new ArrayList<>();
		Connection conn = null;
		try {
			conn = oc.getConnection();
			lista = dR.consultarListaRegistro(id, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;

	}

}
