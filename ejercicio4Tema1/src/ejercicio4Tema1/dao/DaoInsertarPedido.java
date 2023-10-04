package ejercicio4Tema1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicio4Tema1.modelo.Pedido;

public class DaoInsertarPedido {
public Long insertarPedido(Connection conn,Pedido ped ) throws SQLException {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long num=0L;
		try {
			String sql = "INSERT INTO PEDIDOS (fecha_pedido, fecha_entrega, cliente) values (?,?,?)";
			stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stmt.setDate(1,  Date.valueOf(ped.getFechaPedido()));
			stmt.setDate(2,  Date.valueOf(ped.getFechaEntrega()));
			stmt.setString(3, ped.getCliente());
			stmt.execute();
			rs=stmt.getGeneratedKeys();
			rs.next();
			num = rs.getLong(1);
		
		} catch(Exception e){
			
		}finally {
			
			if (stmt != null) {
				try{
					stmt.close();
				}catch(SQLException e1) {
					
				}
			}

		}
		
		
		return num;
	}	
}
