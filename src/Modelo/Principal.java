package Modelo;

import java.util.Scanner;

import Controlador.CMesa;
import Controlador.CRestaurant;

public class Principal {

	static CRestaurant resto = new CRestaurant();
	static CMesa cmesa = new CMesa();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("BIENVENIDO AL SISTEMA, SELECCIONE UNA OPCION");
		System.out.println("1- INGRESAR A UN RESTAURANT");
		System.out.println("2- CARGAR RESTAURANT");
		System.out.println("0- SALIR");
		int opcion = new Scanner(System.in).nextInt();

		switch (opcion) {
			case 1:

				System.out.println("BIENVENIDO AL SISTEMA, SELECCIONE UN RESTO AL CUAL INGRESAR");
				final int idresto = new Scanner(System.in).nextInt();
				Restaurant restaurante = resto.buscarResto(idresto);
				if (restaurante != null) {
					Instancias in = new Instancias();
					cmesa.cargarmesas(idresto);
					in.Menu(idresto);

				} else {
					System.out.println("RESTAURANT INEXISTENTE, CARGUE UNO");
					main(args);
				}

			case 2:

				System.out.println("INGRESE NOMBRE");
				String nombre = new Scanner(System.in).nextLine();
				System.out.println("INGRESE DOMICILIO");
				String domicilio = new Scanner(System.in).nextLine();

				resto.cargarresto(nombre, domicilio);
				main(args);

			case 0:
				System.out.println("Gracias por usar el menu");
				System.exit(0);
			default:
				System.out.println("Opcion invalida");
				break;
		}

	}
}
