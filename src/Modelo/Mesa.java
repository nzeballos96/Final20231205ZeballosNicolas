package Modelo;


public class Mesa extends Restaurant{
 
        int nroMesa;
	    int capacidad;
	    double consumo;
	    private Estado estado;
	      
		public Mesa() {
			super();
		}
		public Mesa(int nroMesa, int capacidad, double consumo, Estado estado) {
			super();
			this.nroMesa = nroMesa;
			this.capacidad = capacidad;
			this.consumo = consumo;
			this.estado = new Liberar();
		}
		public int getNroMesa() {
			return nroMesa;
		}
		public void setNroMesa(int nroMesa) {
			this.nroMesa = nroMesa;
		}
		public int getCapacidad() {
			return capacidad;
		}
		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}
		public double getConsumo() {
			return consumo;
		}
		public void setConsumo(double consumo) {
			this.consumo = consumo;
		}
		public Estado getEstado() {
			return estado;
		}
		public void setEstado(Estado estado) {
			this.estado = estado;
		}

		   public void cambiarEstado(Estado nuevoEstado) {
		        this.estado = nuevoEstado;
		    }

		    public void ocupar() {
		        estado.ocupar();
		    }

		    public void liberar() {
		        estado.liberar();
		    }

		    public void reservar() {
		        estado.reservar();
		    }
		
}
