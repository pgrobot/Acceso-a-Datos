package aplicacionFCT.servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aplicacionFCT.bd.OpenConnection;
import aplicacionFCT.dao.DaoFecha;
import aplicacionFCT.modelo.Fecha;

public class FechaService {

	private DaoFecha dF;
	private OpenConnection oc;

	public FechaService() {
		this.oc = new OpenConnection();
		this.dF = new DaoFecha();
	}

	public List<Fecha> consultarListaRegistro(Long id) {
		List<Fecha> lista = new ArrayList<>();
		Connection conn = null;
		try {
			conn = oc.getConnection();
			lista = dF.consultarFechas(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;

	}
}
