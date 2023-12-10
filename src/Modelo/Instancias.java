package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Controlador.CMesa;

public class Instancias {

	CMesa cmesa = new CMesa();

	public Instancias() {

	}

	public void Menu(int idresto) {
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
				;

				Menu(idresto);
				break;
			case 2:
				cmesa.cargarmesas(idresto);
				ArrayList<Mesa> mesas = cmesa.getMesas();
				for (Mesa mesa : mesas) {
					System.out.println(
							"NUMERO DE MESA--> " + mesa.getNroMesa() + " CAPACIDAD MESA--> " +
									mesa.getCapacidad()
									+ " CONSUMO MESA--> " + mesa.getConsumo() // + " ESTADO MESA--> " +
					// mesa.getEstado()
					);
				}

				Menu(idresto);

				break;

			case 3:
				System.out.println("INGRESE NUMERO DE MESA");
				int NRO = scanner.nextInt();
				cmesa.cambiarEstado(NRO);

				Menu(idresto);
				break;
			case 4:
				// reserva.gestionarReserva();

				Menu(idresto);
				break;
			case 5:
				System.out.println("INGRESE NUMERO DE MESA");
				int NROE = scanner.nextInt();
				cmesa.eliminarMesa(NROE);

				Menu(idresto);
				break;

			case 6:
				/*
				 * System.out.println("Mesas ocupadas");
				 * mesa.listarMesasPorEstado(EEstado.Ocupado);
				 * System.out.println("Mesas Reservadas");
				 * mesa.listarMesasPorEstado(EEstado.Reservado);
				 * System.out.println("Mesas Libres");
				 * mesa.listarMesasPorEstado(EEstado.Libre);
				 */
				Menu(idresto);
				break;

			case 7:

				System.out.println("Capacidad total");
				// mesa.sumarCapacidadTotalMesas();

				System.out.println("Capacidad ocupada");
				// reserva.sumarCantidadComensalesTotalMesas();

				// int dispo = mesa.sumarCapacidadTotalMesas() -
				// reserva.getCantidadComensales();

				// System.out.println("Capacidad disponible" + dispo);

				Menu(idresto);
				break;

			case 8:

				cmesa.cargarmesas(idresto);
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
