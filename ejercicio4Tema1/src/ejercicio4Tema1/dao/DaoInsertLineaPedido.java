package ejercicio4Tema1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicio4Tema1.modelo.LineaPedido;

public class DaoInsertLineaPedido {

	
	
	
	public void insertarLinea(Connection conn,LineaPedido linea ) throws SQLException {
		
		PreparedStatement stmt = null;
		
		try {
			String sql = "INSERT INTO PEDIDOS_LINEAS values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, linea.getIdPedido());
			stmt.setInt(2,linea.getNumeroLinea());
			stmt.setString(3, linea.getArticulo());
			stmt.setBigDecimal(4, linea.getPrecio());
			stmt.execute();
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}

		}
		
		
		
	}
	
	
}
