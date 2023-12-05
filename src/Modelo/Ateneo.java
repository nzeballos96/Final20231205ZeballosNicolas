package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import Controlador.CMesa;
import Controlador.CReserva;

public class Ateneo {
	
	Date fechaac;
	String Info;
	
	private CMesa mesa;
    private ArrayList<Mesa> mesas;
    private CReserva reserva;
    private ArrayList<Reserva> reservas;
    
    

    public Ateneo() {
    	   this.mesa = new CMesa();
    	   this.reserva = new CReserva();
           this.mesas = new ArrayList<>();
           this.reservas = new ArrayList<>();	
           this.Info = "'PAUCKE ATENEO INMACULADA' GRAL LOPEZ 2545";
           this.fechaac = new Date();
                  
           
          mesa.cargardeMesasAteneo();
           
    }
	public void Menu() throws Exception {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println(Info);
		System.out.println(fechaac);
		System.out.println("BIENVENIDO AL MENU");
		System.out.println("por favor seleccione una opcion");
		System.out.println("1--> Agregar mesa");
		System.out.println("2--> Listar mesa");
		System.out.println("3--> Modificar estado mesa");
		System.out.println("4--> Reservar mesa");
		System.out.println("5--> Listar reservas");
		System.out.println("6--> Listar estado de mesas");
		System.out.println("");
		
		
		
		
		  int opcion = scanner.nextInt();

	        switch (opcion) {
	            case 1:
	            	mesa.cargarMesa();;
	            	
	                Menu();
	                break;
	            case 2:
	 	           
	            	mesa.ListMesa();
	        		            	
	                Menu();
	                break;
	            case 3:
	            	
	            	mesa.estadorMesa();
	 	           
	                Menu();
	                break;
	            case 4:
	            	reserva.gestionarReserva();
	 	           
	                Menu();
	                break;
	            case 5:
	 	           
	            	reserva.listarReservas();
	            	
	                Menu();
	                break;
	                
	            case 6:
		 	        System.out.println("Mesas ocupadas");   
	            	mesa.listarMesasPorEstado(EEstado.Ocupado);
	            	System.out.println("Mesas Reservadas");   
	            	mesa.listarMesasPorEstado(EEstado.Reservado);
	            	System.out.println("Mesas Libres");   
	            	mesa.listarMesasPorEstado(EEstado.Libre);
	            	
	                Menu();
	                break;
	             
	            case 7:
		 	           
	            	System.out.println("Capacidad total");
	            	mesa.sumarCapacidadTotalMesas();
	                	
	            	System.out.println("Capacidad ocupada");
	            	reserva.sumarCantidadComensalesTotalMesas();
	            	
	            	
	            	int dispo = mesa.sumarCapacidadTotalMesas() - reserva.getCantidadComensales();
	            	
	            	System.out.println("Capacidad disponible" + dispo);
	            	
	                Menu();
	                break;  
	                
	            case 8:
		 	           
	            	mesa.eliminarMesa();
	            	
	                Menu();
	                break;
	                
	            case 0:
	                System.out.println("Gracias por usar el menú");
	                System.exit(0);
	            default:
	                System.out.println("Opción inválida");
	                break;
	        }
	        
	        
	}
	
}
