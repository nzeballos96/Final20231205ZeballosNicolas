package Modelo;

public class Liberar implements Estado {
	
	 // Estado estado;

	@Override
	    public void ocupar() {
	        System.out.println("Mesa ocupada");
	    }

	    @Override
	    public void liberar() {
	        System.out.println("La mesa ya está libre");
	    }

	    @Override
	    public void reservar() {
	        System.out.println("Mesa reservada");
	    }
	    
		@Override
		public String SetState() {
			return "LIBRE";
			
		}
}
