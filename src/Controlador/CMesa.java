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

		// Agregar la mesa al arraylist
		mesa.setNroMesa(nroMesa);
		mesa.setCapacidad(capacidad);
		mesa.setConsumo(consumo);
		mesa.setEstado(getEstado());
		mesas.add(mesa);
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

}


