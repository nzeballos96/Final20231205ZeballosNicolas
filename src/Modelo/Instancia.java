package Modelo;


	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.Scanner;

	import Controlador.CMesa;
import Controlador.CReserva;
	//import Controlador.CReservagestion;

	public class Instancia {

		CMesa cmesa = new CMesa();
		CReserva reserva = new CReserva();

		public Instancia() {

		}

		public void Menu(int idresto) throws SQLException {
			Conect con = new Conect();
			Scanner scanner = new Scanner(System.in);

			System.out.println("BIENVENIDO AL MENU");
			System.out.println("por favor seleccione una opcion");
			System.out.println("1--> CARGAR MESA");
			System.out.println("2--> LISTAR MESA");
			System.out.println("3--> LIBERAR MESA");
			System.out.println("4--> CREAR RESERVA");
			System.out.println("5--> ELIMINAR MESA");
			System.out.println("6--> OCUPAR MESA");
			System.out.println("7--> RESERVAS POR FECHA");
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

					System.out.println("<=========================================>");
					ArrayList<Mesa> mesasOcupadas2 = cmesa.mesasOcupadas(idresto);
					System.out.println("Mesas libres:");
					cmesa.imprimirMesas(mesasOcupadas2);
					System.out.println("<=========================================>");
					System.out.println("<=========================================>");

					ArrayList<Mesa> mesasReservadas2 = cmesa.mesasReservadas(idresto);
					System.out.println("Mesas reservadas:");
					cmesa.imprimirMesas(mesasReservadas2);
					System.out.println("<=========================================>");
					System.out.println("<=========================================>");


					System.out.println("INGRESE NUMERO DE MESA");
					int nroMes = scanner.nextInt();
					cmesa.liberarMesa(nroMes, idresto);

					Menu(idresto);
					break;
				case 4:
					
					System.out.println("<=========================================>");
					ArrayList<Mesa> mesasLibres = cmesa.mesasLibres(idresto);
					System.out.println("Mesas libres:");
					cmesa.imprimirMesas(mesasLibres);
					System.out.println("<=========================================>");
					System.out.println("<=========================================>");
					
					  System.out.println("INGRESE NUMERO DE MESA");
					    int nroMesar = new Scanner(System.in).nextInt();
					    System.out.println("INGRESE CANTIDAD DE COMENSALES");
					    int cantidadComensales = new Scanner(System.in).nextInt();
					    System.out.println("INGRESE FECHA (DD/MM/AAAA)");
					    String fecha = new Scanner(System.in).nextLine();
					    System.out.println("INGRESE NOMBRE");
					    String nombre = new Scanner(System.in).nextLine();
					    System.out.println("INGRESE APELLIDO");
					    String apellido = new Scanner(System.in).nextLine();

					    // Reserva la mesa

					    reserva.reservarMesa(nroMesar, idresto, fecha, nombre, apellido, cantidadComensales);



					Menu(idresto);
					break;
				case 5:
					System.out.println(" MESAS DISPONIBLES A ELIMINAR");
					cmesa.mesasLibres(idresto);
					try {

						System.out.println("INGRESE NUMERO DE MESA");
						int NROE = scanner.nextInt();
						cmesa.eliminarMesa(NROE,idresto);
						
					} catch (Exception e) {
						// TODO: handle exception
					}

					Menu(idresto);
					break;

				case 6:
					System.out.println("<=========================================>");
					ArrayList<Mesa> mesasLibres2 = cmesa.mesasLibres(idresto);
					System.out.println("Mesas libres:");
					cmesa.imprimirMesas(mesasLibres2);
					System.out.println("<=========================================>");
					System.out.println("<=========================================>");

					ArrayList<Mesa> mesasReservadas = cmesa.mesasReservadas(idresto);
					System.out.println("Mesas reservadas:");
					cmesa.imprimirMesas(mesasReservadas);
					System.out.println("<=========================================>");
					System.out.println("<=========================================>");
					
					System.out.println("ingrese un numero de mesa a ocupar");
					int nroMesaa = new Scanner(System.in).nextInt();
					cmesa.ocuparMesa(nroMesaa, idresto);
					Menu(idresto);
					break;

				case 7:

					 System.out.println("INGRESE FECHA (DD/MM/AAAA)");
					    String fecha1 = new Scanner(System.in).nextLine();
					
					System.out.println("<=========================================>");
					ArrayList<Reserva> resrfechas= reserva.reservasfecha(idresto, fecha1);
					System.out.println("RESERVAS POR FECHA");
					reserva.imprimirreserva(resrfechas);
					System.out.println("<=========================================>");

					
					Menu(idresto);
					break;

				case 8:

					System.out.println("<=========================================>");
					ArrayList<Mesa> mesasOcupadas3 = cmesa.mesasOcupadas(idresto);
					System.out.println("Mesas ocupadas:");
					cmesa.imprimirMesas(mesasOcupadas3);
					System.out.println("<=========================================>");
					System.out.println("CARGUE UN CONSUMO A LA MESA");
					System.out.println("MESA");
					int nummesa = new Scanner(System.in).nextInt();
					System.out.println("CONSUMO");
					double consumo = new Scanner(System.in).nextInt();
cmesa.cargarConsumo(nummesa, idresto, consumo);
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
