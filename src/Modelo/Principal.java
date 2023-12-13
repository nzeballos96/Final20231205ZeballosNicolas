package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Controlador.CMesa;
import Controlador.CRestaurant;

public class Principal {

	static CRestaurant resto = new CRestaurant();
	static CMesa cmesa = new CMesa();

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("BIENVENIDO AL SISTEMA, SELECCIONE UNA OPCION");
		System.out.println("1- INGRESAR A UN RESTAURANT");
		System.out.println("2- CARGAR RESTAURANT");
		System.out.println("0- SALIR");
		int opcion = new Scanner(System.in).nextInt();

		switch (opcion) {
			case 1:

				System.out.println("<=========================================>");
				ArrayList<Restaurant> restos = resto.getRestaurants();
				System.out.println("RESERVAS POR FECHA");
				resto.imprimir(restos);
				System.out.println("<=========================================>");
				
				
				System.out.println("BIENVENIDO AL SISTEMA, SELECCIONE UN ID DEL RESTO AL CUAL INGRESAR");
				
				
				final int idresto = new Scanner(System.in).nextInt();
				Restaurant restaurante = resto.buscarResto(idresto);
				if (restaurante != null) {
					Instancia in = new Instancia();
					in.Menu(idresto);

				} else {
					System.out.println("RESTAURANT INEXISTENTE, CARGUE UNO");
					main(args);
				}
				break;

			case 2:

				System.out.println("INGRESE NOMBRE");
				String nombre = new Scanner(System.in).nextLine();
				System.out.println("INGRESE DOMICILIO");
				String domicilio = new Scanner(System.in).nextLine();

				resto.cargarresto(nombre, domicilio);
				main(args);

				break;
			case 0:
				System.out.println("Gracias por usar el menu");
				System.exit(0);
			default:
				System.out.println("Opcion invalida");
				break;
		}

	}
}