package Modelo;

public class Reservado implements Estado {
    
    @Override
    public void ocupar() {
        System.out.println("No se puede ocupar una mesa reservada");
    }

    @Override
    public void liberar() {
        System.out.println("No se puede liberar una mesa reservada");
    }

    @Override
    public void reservar() {
        System.out.println("La mesa ya está reservada");
    }
	
}
