package aplicacionFCT.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aplicacionFCT.modelo.Fecha;

public class DaoFecha {

	public List<Fecha> consultarFechas(Connection conn) throws SQLException {

		List<Fecha> lista = new ArrayList<>();

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM FECHAS";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Fecha fecha = new Fecha();
				fecha.setFecha(rs.getDate("fecha").toLocalDate());
				fecha.setAño(rs.getInt("año"));
				fecha.setEvaluacion(rs.getInt("evaluacion"));
				fecha.setDisponibilidad(rs.getBoolean("disponibilidad"));
				lista.add(fecha);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		}

		return lista;

	}

}
