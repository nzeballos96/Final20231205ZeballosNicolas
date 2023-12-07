package Modelo;

public class Ocupar implements Estado {
	    @Override
	    public void ocupar() {
	        System.out.println("La mesa ya está ocupada");
	    }

	    @Override
	    public void liberar() {
	        System.out.println("Mesa liberada");
	    }

	    @Override
	    public void reservar() {
	        System.out.println("No se puede reservar una mesa ocupada");
	    }
	
}
