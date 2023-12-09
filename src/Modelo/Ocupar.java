package Modelo;

public class Ocupar implements Estado {
	
	@Override
	    public void ocupar() {
	        System.out.println("La mesa ya está ocupada");
	return;    
	
	}

	    @Override
	    public void liberar() {	    	
	        System.out.println("Mesa liberada");
	    }

	    @Override
	    public void reservar() {
	        System.out.println("No se puede reservar una mesa ocupada");
	    }

		@Override
		public String SetState() {
			return "OCUPADO";
			
		}
	
}
