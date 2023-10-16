package aplicacionFCT.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aplicacionFCT.modelo.Registro;

public class DaoRegistro {

	public Registro consultarRegistro(Connection conn, Registro reg) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Registro regi = new Registro();
		try {

			String sql = "SELECT * FROM REGISTROS WHERE FECHA=? AND ID_USUARIO=?";
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(reg.getFecha()));
			stmt.setLong(2, reg.getIdUsuario());
			rs = stmt.executeQuery();
			if (rs.next()) {
				regi.setDescripcion(rs.getString("descripcion"));
				regi.setIdRegistro(rs.getLong("id_registro"));
				regi.setIdUsuario(rs.getLong("id_usuario"));
				regi.setNumHoras(rs.getDouble("num_horas"));
				regi.setFecha(rs.getDate("fecha").toLocalDate());
				return regi;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		}

		finally {

			try {
				stmt.close();
			} catch (Exception e) {

			}

		}
		return null;

	}

	public void insertarRegistro(Registro reg, Connection conn) throws SQLException {
		PreparedStatement stmt = null;

		try {
			String sql = "INSERT INTO REGISTROS (ID_USUARIO, FECHA, NUM_HORAS, DESCRIPCION) values (?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, reg.getIdUsuario());
			stmt.setDate(2, Date.valueOf(reg.getFecha()));
			stmt.setDouble(3, reg.getNumHoras());
			stmt.setString(4, reg.getDescripcion());
			stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {

				}
			}

		}
	}

	public List<Registro> consultarListaRegistro(Long id, Connection conn) throws SQLException {
		List<Registro> lista = new ArrayList<>();

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM REGISTROS WHERE ID_USUARIO=?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Registro reg = new Registro();
				reg.setDescripcion(rs.getString("descripcion"));
				reg.setFecha(rs.getDate("Fecha").toLocalDate());
				reg.setIdRegistro(rs.getLong("id_registro"));
				reg.setIdUsuario(rs.getLong("id_usuario"));
				reg.setNumHoras(rs.getDouble("num_horas"));
				lista.add(reg);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		}

		return lista;

	}

}
