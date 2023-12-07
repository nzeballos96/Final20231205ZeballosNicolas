package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Controlador.CMesa;


public class Instancias {
		
	CMesa cmesa = new CMesa();
	
    public Instancias (){
               
    }
	public void Menu() 
			//throws Exception 
	{
		
		Scanner scanner = new Scanner(System.in);


		System.out.println("BIENVENIDO AL MENU");
		System.out.println("por favor seleccione una opcion");
		System.out.println("1--> CARGAR MESA");
		System.out.println("2--> LISTAR MESA");
		System.out.println("3--> Modificar estado mesa");
		System.out.println("4--> Reservar mesa");
		System.out.println("5--> ELIMINAR MESA");
		System.out.println("6--> Listar estado de mesas");
		System.out.println("");
		
		
		
		
		  int opcion = scanner.nextInt();

	        switch (opcion) {
	            case 1:
	            	cmesa.cargarMesa();;
	            	
	                Menu();
	                break;
	            case 2:
	 	           
	            	ArrayList<Mesa> mesas = cmesa.getMesas();
	                for (Mesa mesa : mesas) {
	                    System.out.println("NUMERO DE MESA--> " + mesa.getNroMesa() + " ESTADO MESA--> " + mesa.getEstado());
	                }            	
	                Menu();
	                
	                break;
	                
	            case 3:
	            	
	           // 	mesa.estadorMesa();
	 	           
	                Menu();
	                break;
	            case 4:
	         //   	reserva.gestionarReserva();
	 	           
	                Menu();
	                break;
	            case 5:
	 	           
	            	cmesa.eliminarMesa();
	            	
	                Menu();
	                break;
	                
	            case 6:
		/* 	        System.out.println("Mesas ocupadas");   
	            	mesa.listarMesasPorEstado(EEstado.Ocupado);
	            	System.out.println("Mesas Reservadas");   
	            	mesa.listarMesasPorEstado(EEstado.Reservado);
	            	System.out.println("Mesas Libres");   
	            	mesa.listarMesasPorEstado(EEstado.Libre);
	     */       	
	                Menu();
	                break;
	             
	            case 7:
		 	           
	            	System.out.println("Capacidad total");
	            //	mesa.sumarCapacidadTotalMesas();
	                	
	            	System.out.println("Capacidad ocupada");
	            //	reserva.sumarCantidadComensalesTotalMesas();
	            	
	            	
	            //	int dispo = mesa.sumarCapacidadTotalMesas() - reserva.getCantidadComensales();
	            	
	           // 	System.out.println("Capacidad disponible" + dispo);
	            	
	                Menu();
	                break;  
	                
	            case 8:
		 	           
	           // 	mesa.eliminarMesa();
	            	
	                Menu();
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
	


