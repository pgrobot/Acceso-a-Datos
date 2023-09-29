package ejercicio4Tema1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicio4Tema1.modelo.Pedido;

public class DaoInsertarPedido {
public void insertarPedido(Connection conn,Pedido ped ) throws SQLException {
		
		PreparedStatement stmt = null;
		
		try {
			String sql = "INSERT INTO PEDIDOS values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, ped.getIdPedido());
			stmt.setDate(2,  Date.valueOf(ped.getFechaPedido()));
			stmt.setDate(3,  Date.valueOf(ped.getFechaEntrega()));
			stmt.setString(4, ped.getCliente());
			stmt.execute();
			
		} catch(Exception e){
			
		}finally {
			if (stmt != null) {
				try{
					stmt.close();
				}catch(SQLException e1) {
					
				}
			}

		}
		
		
		
	}
}
