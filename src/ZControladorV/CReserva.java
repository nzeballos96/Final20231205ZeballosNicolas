package ZControladorV;


import java.util.ArrayList;
import java.util.Scanner;

import ZModelov.EEstado;
import ZModelov.Estado;
import ZModelov.Mesa;
import ZModelov.Reserva;

public class CReserva extends Reservar implements Estado{
	
	private CMesa mesa;
    private ArrayList<Mesa> mesas;

	private Scanner scan;
	private static ArrayList<Reservar> reservas;
	public CReserva() {
		this.scan = new Scanner(System.in);
		this.reservas = new ArrayList<>();	
		   this.mesa = new CMesa();
           this.mesas = new ArrayList<>();
	}
	
	
	public static void gestionarReserva() {

		System.out.println("SELECCIONE UNA OPCION");
		
		System.out.println("1 - Reservar mesa");
		System.out.println("2 - Ocupar mesa");
		System.out.println("3 - Cancelar reserva o liberar");
		
		int op = new Scanner(System.in).nextInt();
		Mesa mesa = new Mesa();
		switch (op) {
		case 1: 
			Scanner scanner = new Scanner(System.in);
			System.out.println("Ingrese la fecha de la reserva (dd/MM/yyyy): ");
			String fecha = scanner.nextLine();

			System.out.println("Ingrese el nombre del cliente: ");
			String nombre = scanner.nextLine();

			System.out.println("Ingrese el apellido del cliente: ");
			String apellido = scanner.nextLine();

			System.out.println("Ingrese la cantidad de comensales: ");
			int cantidadComensales = scanner.nextInt();

			System.out.println("Ingrese el n�mero de mesa reservada: ");
			int nroMesa = scanner.nextInt();
							
			if (nroMesa == mesa.getNroMesa() && mesa.getEstado() != EEstado.Reservado && mesa.getEstado() != EEstado.Ocupar && cantidadComensales < mesa.getCapacidad()) {
				mesa.setEstado(EEstado.Reservado);
				System.out.println("La mesa " + mesa.getNroMesa() + " se ha reservado");
			
				Reservar reserva = new Reservar();
				reservas.add(reserva);
			} else {
				System.out.println("La mesa ya est� reservada excede el numero de comensales. POR FAVOR INGRESER OTRA");
			}
			break;
		case 2: 

			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Ingrese la fecha de la reserva (dd/MM/yyyy): ");
			String fecha2 = scanner2.nextLine();

			System.out.println("Ingrese el nombre del cliente: ");
			String nombre2 = scanner2.nextLine();

			System.out.println("Ingrese el apellido del cliente: ");
			String apellido2 = scanner2.nextLine();

			System.out.println("Ingrese la cantidad de comensales: ");
			int cantidadComensales2 = scanner2.nextInt();

			System.out.println("Ingrese el n�mero de mesa a ocupar: ");
			int nroMesa2 = scanner2.nextInt();
								
			if (nroMesa2 == mesa.getNroMesa() && mesa.getEstado() != EEstado.Reservado && mesa.getEstado() != EEstado.Ocupar && cantidadComensales2 < mesa.getCapacidad()) {
				mesa.setEstado(EEstado.Reservado);
				System.out.println("La mesa " + mesa.getNroMesa() + " se ha ocupado");

				Reservar reserva = new Reservar();
				reservas.add(reserva);
			
			} else {
				System.out.println("La mesa ya est� reservada o excede el numero de comensales. POR FAVOR INGRESE OTRA ");
			}

			break;
		case 3: 
	
			System.out.println("INGRESE NUMERO DE MESA");
			int nroMesa3 = new Scanner(System.in).nextInt();
				
			if (nroMesa3 == mesa.getNroMesa() && mesa.getEstado() == EEstado.Reservado && mesa.getEstado() == EEstado.Ocupar) {
				mesa.setEstado(EEstado.Reservado);
				System.out.println("La mesa " + mesa.getNroMesa() + " se ha liberado");
			}	
			break;		
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}

}

	@Override
	public void liberar(Mesa m) {
		Reservar reserva = new Reservar();
		Mesa mesa = new Mesa();
		System.out.println("INGRESE NUMERO DE MESA");
		int nroMesa = new Scanner(System.in).nextInt();
			
		if (nroMesa == mesa.getNroMesa() && mesa.getEstado() == EEstado.Reservado && mesa.getEstado() == EEstado.Ocupar) {
			mesa.setEstado(EEstado.Reservado);
			System.out.println("La mesa " + mesa.getNroMesa() + " se ha liberado");
			
			reservas.remove(reserva);
		} else {
			System.out.println("La mesa ya est�ba libre ");
		}// TODO Auto-generated method stub
		
	}


	@Override
	public void reservar(Mesa m) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese la fecha de la reserva (dd/MM/yyyy): ");
		String fecha = scanner.nextLine();

		System.out.println("Ingrese el nombre del cliente: ");
		String nombre = scanner.nextLine();

		System.out.println("Ingrese el apellido del cliente: ");
		String apellido = scanner.nextLine();

		System.out.println("Ingrese la cantidad de comensales: ");
		int cantidadComensales = scanner.nextInt();

		System.out.println("Ingrese el n�mero de mesa reservada: ");
		int nroMesa = scanner.nextInt();
						
		if (nroMesa == mesa.getNroMesa() && mesa.getEstado() != EEstado.Reservado && mesa.getEstado() != EEstado.Ocupar) {
			mesa.setEstado(EEstado.Reservado);
			System.out.println("La mesa " + mesa.getNroMesa() + " se ha reservado");
		
			Reservar reserva = new Reservar();
			reservas.add(reserva);
		} else {
			System.out.println("La mesa ya est� reservada");
		}
		
	}


	@Override
	public void ocupar(Mesa m) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese la fecha de la reserva (dd/MM/yyyy): ");
		String fecha = scanner.nextLine();

		System.out.println("Ingrese el nombre del cliente: ");
		String nombre = scanner.nextLine();

		System.out.println("Ingrese el apellido del cliente: ");
		String apellido = scanner.nextLine();

		System.out.println("Ingrese la cantidad de comensales: ");
		int cantidadComensales = scanner.nextInt();

		System.out.println("Ingrese el n�mero de mesa a ocupar: ");
		int nroMesa = scanner.nextInt();
			
			
		if (nroMesa == mesa.getNroMesa() && mesa.getEstado() != EEstado.Reservado && mesa.getEstado() != EEstado.Ocupar) {
			mesa.setEstado(EEstado.Reservado);
			System.out.println("La mesa " + mesa.getNroMesa() + " se ha ocupado");

			Reservar reserva = new Reservar();
			reservas.add(reserva);
		
		} else {
			System.out.println("La mesa ya est� reservada");
		}
		
	}

	@Override
	public boolean setSate(Estado state) {
		return false;
	}
	
	public static ArrayList<Reservar> listarReservas() {
	    // Devuelve una lista de todas las reservas
	    return reservas;
	}
	
	public static int sumarCantidadComensalesTotalMesas() {
	    int cantidadComensalesTotal = 0;

	    for (Reservar reserva : reservas) {
	        cantidadComensalesTotal += reserva.getCantidadComensales();
	    }

	    return cantidadComensalesTotal;
	}
	
}
