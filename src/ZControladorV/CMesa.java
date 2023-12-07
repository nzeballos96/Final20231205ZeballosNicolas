package ZControladorV;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import ZModelov.Ateneo;
import ZModelov.EEstado;
import ZModelov.Estado;
import ZModelov.Mesa;
import ZModelov.Reserva;

public class CMesa{
	
	private Scanner scan;

	
	public CMesa() {		
	
		this.scan = new Scanner(System.in);

	
	}
	
	public void estadorMesa() {

		System.out.println("SELECCIONE UNA ACCION: ");
		System.out.println("1 LIBERAR: ");
		System.out.println("2 RESERVAR: ");
		System.out.println("3 OCUPAR: ");
		int op = new Scanner(System.in).nextInt();
		Mesa mesa = new Mesa();
		switch (op) {
		case 1:
			// Liberar la mesa
liberar(mesa);
			break;
		case 2:
			// Reservar la mesa
reservar(mesa);
			break;
		case 3:
			// Ocupar la mesa
	ocupar(mesa);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
	}

	
	public static ArrayList<Mesa> listarMesasPorEstado(EEstado estado) {
	    ArrayList<Mesa> mesas = new ArrayList<>();

	    for (Mesa mesa : mesas) {
	        if (mesa.getEstado() == estado) {
	            mesas.add(mesa);
	        }
	    }

	    return mesas;
	}
	public static int sumarCapacidadTotalMesas() {
	    int capacidadTotal = 0;

	    Mesa[] mesas = null;
		for (Mesa mesa : mesas) {
	        capacidadTotal += mesa.getCapacidad();
	    }

	    return capacidadTotal;

}
	
	public static void eliminarMesa() throws Exception {
		Mesa mesa = new Mesa();
		System.out.println("INGRESE NUMERO DE MESA");
		int nroMesa = new Scanner(System.in).nextInt();

	    if (mesa.getEstado() != EEstado.Liberar) {
	    	mesa.setEstado(EEstado.Baja);
			System.out.println("La mesa " + mesa.getNroMesa() + " se ha dado de baja");
		   
	    }else {
	    	throw new Exception("No se puede eliminar una mesa que no est� libre");
	}
}

	

	
	}