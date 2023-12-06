package ZControladorV;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import ZModelov.Ateneo;
import ZModelov.EEstado;
import ZModelov.Estado;
import ZModelov.Mesa;
import ZModelov.Reserva;

public class CMesa extends Mesa{
	
	private Scanner scan;
	private ArrayList<Mesa> mesass;
	
	public CMesa() {		
	
		this.scan = new Scanner(System.in);
		this.mesass = new ArrayList<>();
	
	}
	
	
	
	public void cargarMesa() {

		System.out.println("INGRESE NUMERO DE MESA");
		int nroMesa = new Scanner(System.in).nextInt();

		// Inicializar la variable mesa
		Mesa mesa = new Mesa();	

		// Validar que la mesa no exista
		for (Mesa m : mesass) {
			if (m.getNroMesa() == nroMesa) {
				System.out.println("Ya existe una mesa con ese n�mero");
				return;
			}
		}

		// Ingresar los datos de la mesa
		System.out.println("INGRESE CAPACIDAD");
		int capacidad = new Scanner(System.in).nextInt();

		System.out.println("INGRESE CONSUMO");
		double consumo = new Scanner(System.in).nextDouble();

		// Agregar la mesa al arraylist
		mesa.setNroMesa(nroMesa);
		mesa.setCapacidad(capacidad);
		mesa.setConsumo(consumo);
		mesa.setEstado(getEstado());
		mesass.add(mesa);
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

	public void ListMesa() {
		System.out.println("LISTA DE MESAS");
		for (Mesa mesa : mesass) {
			System.out.println("Numero de mesa: " + mesa.getNroMesa() +
					" - Capacidad: " + mesa.getCapacidad() +
					" - Estado: " + mesa.getEstado() +
					" - Consumo: " + mesa.getConsumo());
		}		}
	


	@Override
	public void liberar(Mesa m) {
		Mesa mesa = new Mesa();
		System.out.println("INGRESE NUMERO DE MESA");
		int nroMesa = new Scanner(System.in).nextInt();
			
		if (nroMesa == mesa.getNroMesa() && mesa.getEstado() != EEstado.Libre) {
			mesa.setEstado(EEstado.Libre);
			System.out.println("La mesa " + mesa.getNroMesa() + " se ha liberado");
		} else {
			System.out.println("no existe o La mesa ya est� libre");
		}
		
	}

	@Override
	public void reservar(Mesa m) {
		Mesa mesa = new Mesa();
		System.out.println("INGRESE NUMERO DE MESA");
		int nroMesa = new Scanner(System.in).nextInt();
			
		if (nroMesa == mesa.getNroMesa() && mesa.getEstado() != EEstado.Reservado) {
			mesa.setEstado(EEstado.Reservado);
			System.out.println("La mesa " + mesa.getNroMesa() + " se ha reservado");
		} else {
			System.out.println("La mesa ya est� reservada");
		}
		
	}

	@Override
	public void ocupar(Mesa m) {
		Mesa mesa = new Mesa();
		System.out.println("INGRESE NUMERO DE MESA");
		int nroMesa = new Scanner(System.in).nextInt();
			
		if (nroMesa == mesa.getNroMesa() && mesa.getEstado() != EEstado.Ocupado) {
			mesa.setEstado(EEstado.Ocupado);
			System.out.println("La mesa " + mesa.getNroMesa() + " se ha ocupado");
		} else {
			System.out.println("La mesa no est� libre");
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

	    if (mesa.getEstado() != EEstado.Libre) {
	    	mesa.setEstado(EEstado.Baja);
			System.out.println("La mesa " + mesa.getNroMesa() + " se ha dado de baja");
		   
	    }else {
	    	throw new Exception("No se puede eliminar una mesa que no est� libre");
	}
}
	public void cargardeMesasAteneo() {
	Mesa mesa = new Mesa();	
   	  Mesa mesa1 = new Mesa(1, 2);
   	  Mesa mesa2 = new Mesa(2, 2);
   	  Mesa mesa3 = new Mesa(3, 2);
   	  Mesa mesa4 = new Mesa(4, 2);
   	  Mesa mesa5 = new Mesa(5, 4);
   	  Mesa mesa6 = new Mesa(6, 4);
   	  Mesa mesa7 = new Mesa(7, 4);
   	  Mesa mesa8 = new Mesa(8, 4);
   	  Mesa mesa9 = new Mesa(9, 6);
   	  Mesa mesa10 = new Mesa(10, 6);
   	  Mesa mesa11 = new Mesa(11, 6);
   	  mesass.add(mesa1);
   	mesass.add(mesa2);
   	mesass.add(mesa3);
   	mesass.add(mesa4);
   	mesass.add(mesa5);
   	mesass.add(mesa6);
   	mesass.add(mesa7);
   	mesass.add(mesa8);
   	mesass.add(mesa9);
   	mesass.add(mesa10);
   	mesass.add(mesa11);
	}
	
	public void cargardeMesasPrimos() {
	Mesa mesa = new Mesa();	
   	  Mesa mesa1 = new Mesa(1, 10);
   	  Mesa mesa2 = new Mesa(2, 10);
   	  Mesa mesa3 = new Mesa(3, 10);
   	  Mesa mesa4 = new Mesa(4, 10);
   	  Mesa mesa5 = new Mesa(5, 6);
   	  Mesa mesa6 = new Mesa(6, 6);
   	  Mesa mesa7 = new Mesa(7, 6);
   	  Mesa mesa8 = new Mesa(8, 6);
   	  Mesa mesa9 = new Mesa(9, 6);
   	  Mesa mesa10 = new Mesa(10, 6);
   	  Mesa mesa11 = new Mesa(11, 5);
   	Mesa mesa12 = new Mesa(12, 5);
   	Mesa mesa13 = new Mesa(13, 5);
   	Mesa mesa14 = new Mesa(14, 5);
   	Mesa mesa15 = new Mesa(15, 5);
   	Mesa mesa16 = new Mesa(16, 5);
   	Mesa mesa17 = new Mesa(17, 5);
   	Mesa mesa18 = new Mesa(18, 5);
   	  mesass.add(mesa1);
   	mesass.add(mesa2);
   	mesass.add(mesa3);
   	mesass.add(mesa4);
   	mesass.add(mesa5);
   	mesass.add(mesa6);
   	mesass.add(mesa7);
   	mesass.add(mesa8);
   	mesass.add(mesa9);
   	mesass.add(mesa10);
   	mesass.add(mesa11);
   	mesass.add(mesa12);
   	mesass.add(mesa13);
   	mesass.add(mesa14);
   	mesass.add(mesa15);
   	mesass.add(mesa16);
   	mesass.add(mesa17);
   	mesass.add(mesa18);
	}
	
	}