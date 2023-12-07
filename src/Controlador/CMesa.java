package Controlador;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Mesa;

public class CMesa extends Mesa {

	private ArrayList<Mesa> mesas;
	
	public CMesa() {
	
		 mesas = new ArrayList<>();
	
	}
	
	public void cargarMesa() {

		System.out.println("INGRESE NUMERO DE MESA");
		int nroMesa = new Scanner(System.in).nextInt();

		// Validar que el numero de mesa sea valido
		if (nroMesa < 1 || nroMesa > 100) {
			System.out.println("El numero de mesa debe ser un valor entre 1 y 100");
			return;
		}

		// Inicializar la variable mesa
		Mesa mesa = new Mesa();	

		// Validar que la mesa no exista
		for (Mesa m : mesas) {
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

		// Validar que la capacidad sea valida
		if (capacidad < 1 || capacidad > 10) {
			System.out.println("La capacidad debe ser un valor entre 1 y 10");
			return;
		}

		// Validar que el consumo sea valido
		if (consumo < 0) {
			System.out.println("El consumo debe ser un valor no negativo");
			return;
		}

		// Agregar la mesa al arraylist
		mesa.setNroMesa(nroMesa);
		mesa.setCapacidad(capacidad);
		mesa.setConsumo(consumo);
		mesa.setEstado(getEstado());
		mesas.add(mesa);
		
		System.out.println("Mesa cargada");
	}
	
	   public ArrayList<Mesa> getMesas() {
	        return mesas;
	    }

	   public void eliminarMesa() {

			System.out.println("INGRESE NUMERO DE MESA A ELIMINAR");
			int nroMesa = new Scanner(System.in).nextInt();

			for (Mesa mesa : mesas) {
				if (mesa.getNroMesa() == nroMesa) {
					mesas.remove(mesa);
					System.out.println("Mesa eliminada");
					return;
				}
			}

			System.out.println("No se encontro la mesa");
	}	   

	   
		public void cargardeMesas()	{


}
		
}


