package aplicacionFCT.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aplicacionFCT.modelo.Fecha;

public class DaoFecha {

	public List<Fecha> consultarFechas(Connection conn) throws SQLException {

		List<Fecha> lista = new ArrayList<>();

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM FECHAS WHERE AÑO=? AND EVALUACION=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, LocalDate.now().getYear());
			if (LocalDate.now().getMonthValue() >= 9 || LocalDate.now().getMonthValue() <= 12) {
				stmt.setInt(2, 1);
			} else if (LocalDate.now().getMonthValue() == 1 || LocalDate.now().getMonthValue() == 2) {
				stmt.setInt(2, 2);
			} else if (LocalDate.now().getMonthValue() > 2 || LocalDate.now().getMonthValue() <= 6) {
				stmt.setInt(2, 3);
			} else {
				stmt.setInt(2, 4);
			}
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
