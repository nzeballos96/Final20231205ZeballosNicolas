package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Controlador.CMesa;
import Controlador.CReservagestion;

public class Instancias {

	CMesa cmesa = new CMesa();
	CReservagestion reserva = new CReservagestion();

	public Instancias() {

	}

	public void Menu(int idresto) throws SQLException {
		Conect con = new Conect();
		Scanner scanner = new Scanner(System.in);

		System.out.println("BIENVENIDO AL MENU");
		System.out.println("por favor seleccione una opcion");
		System.out.println("1--> CARGAR MESA");
		System.out.println("2--> LISTAR MESA");
		System.out.println("3--> MODIFICAR ESTADO");
		System.out.println("4--> Reservagestion mesa");
		System.out.println("5--> ELIMINAR MESA");
		System.out.println("6--> Listar estado de mesas");
		System.out.println("");

		int opcion = scanner.nextInt();

		switch (opcion) {
			case 1:

				System.out.println("INGRESE NUMERO DE MESA");
				int nroMesa = new Scanner(System.in).nextInt();
				System.out.println("INGRESE CAPACIDAD");
				int capacidad = new Scanner(System.in).nextInt();
				cmesa.cargarMesa(nroMesa, capacidad, idresto);

				Menu(idresto);
				break;
			case 2:

				cmesa.listarmesas(idresto);

				Menu(idresto);

				break;

			case 3:
				cmesa.listarmesas(idresto);
				System.out.println("INGRESE NUMERO DE MESA");
				int nroM = scanner.nextInt();
				cmesa.cambiarEstado(nroM, idresto, null);

				Menu(idresto);
				break;
			case 4:
				 reserva.reservarmesa(nroMesa, idresto, fecha, nombre, apellido, cantidadComensales)
				System.out.println("INGRESE NUMERO DE MESA");
				int nroMmesa = new Scanner(System.in).nextInt();
				System.out.println("INGRESE CAPACIDAD");
				int cantidadComensales = new Scanner(System.in).nextInt();
				System.out.println("INGRESE CAPACIDAD");
				String fecha = new Scanner(System.in).nextLine();
				System.out.println("INGRESE CAPACIDAD");
				String nombre = new Scanner(System.in).nextLine();
				System.out.println("INGRESE CAPACIDAD");
				String apellido = new Scanner(System.in).nextLine();

				Menu(idresto);
				break;
			case 5:
				System.out.println("INGRESE NUMERO DE MESA");
				int NROE = scanner.nextInt();
				cmesa.eliminarMesa(NROE);

				Menu(idresto);
				break;

			case 6:

				Menu(idresto);
				break;

			case 7:

				Menu(idresto);
				break;

			case 8:

				// mesa.eliminarMesa();

				Menu(idresto);
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
