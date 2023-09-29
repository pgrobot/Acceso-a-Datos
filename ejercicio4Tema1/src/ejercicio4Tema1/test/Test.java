package ejercicio4Tema1.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ejercicio4Tema1.modelo.LineaPedido;
import ejercicio4Tema1.modelo.Pedido;
import ejercicio4Tema1.services.PedidoServiceException;
import ejercicio4Tema1.services.PedidosServices;

public class Test {
	
	
	
	
	
	public static void main(String[] args) {

		
		Scanner scanner = new Scanner(System.in);
		
		PedidosServices pD = new PedidosServices();
		Pedido ped = new Pedido();
		List<LineaPedido> listaPedidos = new ArrayList<>(); 
		System.out.println("Dime el id del pedido");
		ped.setIdPedido(scanner.nextLong());
		ped.setFechaPedido(LocalDate.now());
		ped.setFechaEntrega(LocalDate.now());
		ped.setCliente("El pepe");
		
		System.out.println("Cuantas lineas tiene tu epdido");
		Integer num = scanner.nextInt();
		for (int i = 0; i < num; i++) {
			LineaPedido lP = new LineaPedido();
			lP.setIdPedido(ped.getIdPedido());
			lP.setNumeroLinea(i);
			lP.setPrecio(new BigDecimal(22.2));
			System.out.println("Dime el nombre");
			lP.setArticulo(scanner.nextLine());
			scanner.nextLine();
			listaPedidos.add(lP);
		}
		ped.setLineaPedidos(listaPedidos);
		try {
			pD.registrarPedido(ped);
		} catch (PedidoServiceException e) {
			
			e.printStackTrace();
		}
		
		
		scanner.close();
		
		
		
		

	
	}
}
