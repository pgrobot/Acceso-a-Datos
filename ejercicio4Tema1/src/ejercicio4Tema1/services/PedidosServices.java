package ejercicio4Tema1.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicio4Tema1.dao.DaoInsertLineaPedido;
import ejercicio4Tema1.dao.DaoInsertarPedido;
import ejercicio4Tema1.modelo.LineaPedido;
import ejercicio4Tema1.modelo.Pedido;

public class PedidosServices {

	
	
	public void registrarPedido(Pedido ped) throws PedidoServiceException {
	
		DaoInsertLineaPedido daoInsLinPed = new DaoInsertLineaPedido();
		DaoInsertarPedido daoInsPed = new DaoInsertarPedido();
		OpenConnection oc = new OpenConnection();
		Connection conn = null;
		List<LineaPedido> lP = new ArrayList<>();
		Long num;
		try {
			
			conn= oc.getConnection();
			conn.setAutoCommit(false);
			num=daoInsPed.insertarPedido(conn, ped);
			lP=ped.getLineaPedidos();
			for (LineaPedido lineaPedido : lP) {
				lineaPedido.setIdPedido(num);
				daoInsLinPed.insertarLinea(conn, lineaPedido);
			}
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {

				}
			}
			throw new PedidoServiceException("Hay un error con los pedidos"+e,e);
		}finally {
			
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
			
		}
		
		
		
	}
	
	
	
	
}
