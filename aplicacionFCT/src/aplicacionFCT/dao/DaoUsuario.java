package aplicacionFCT.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aplicacionFCT.modelo.Usuario;

public class DaoUsuario {

	public Usuario consultarUsuario(Connection conn, String email) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario us = new Usuario();
		try {

			String sql = "SELECT * FROM USUARIOS WHERE email=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			if (rs.next()) {
				us.setEmail(rs.getString("email"));
				us.setActivo(rs.getBoolean("activo"));
				us.setApellidos(rs.getString("apellidos"));
				us.setCiclo(rs.getString("ciclo"));
				us.setPassword(rs.getString("password"));
				us.setNombre(rs.getString("nombre"));
				us.setIdUsuario(rs.getLong("id_usuario"));
				return us;
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

	public void insertarUsuario(Connection conn, Usuario us) throws SQLException {
		PreparedStatement stmt = null;

		try {
			String sql = "INSERT INTO USUARIOS (EMAIL, PASSWORD, NOMBRE, APELLIDOS, CICLO, ACTIVO) values (?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, us.getEmail());
			stmt.setString(2, us.getPassword());
			stmt.setString(3, us.getNombre());
			stmt.setString(4, us.getApellidos());
			stmt.setString(5, us.getCiclo());
			stmt.setBoolean(6, false);
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

}
