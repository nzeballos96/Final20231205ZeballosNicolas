package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

import Controlador.CMesa;

public class Principal {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

	System.out.println("POR FAVOR SELECCIONE UN RESTAUTANT A INGRESAR");
	System.out.println("1--------------ATENEO INMACULADA--------------");
	System.out.println("2--------------ATENEO LOS PRIMOS--------------");
	System.out.println("0--------------SALIR DEL SISTEMA--------------");	
		
	  Scanner scanner = new Scanner(System.in);
	  int opcion = scanner.nextInt();

      switch (opcion) {
      
      case 1:

		Ateneo mesa = new Ateneo();
		mesa.Menu();
	
		
		break;
		
		
		
      case 2:
    	  
    	  Primos mesa2 = new Primos();
    	  mesa2.Menu();
    	  
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
