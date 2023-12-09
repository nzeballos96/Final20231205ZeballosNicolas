package Modelo;


public class Mesa extends Restaurant{
 
	int  idmesa;
        public int getIdmesa() {
		return idmesa;
	}
	public void setIdmesa(int idmesa) {
		this.idmesa = idmesa;
	}

		int nroMesa;
	    int capacidad;
	    double consumo;
	    private Estado estado;
	    int restoid;
	    int Prueba;
	      
	    public int getPrueba() {
			return Prueba;
		}
		public void setPrueba(int prueba) {
			Prueba = prueba;
		}
		public int getRestoid() {
			return restoid;
		}
		public void setRestoid(int restoid) {
			this.restoid = restoid;
		}
		public Mesa() {
	        this.estado = setState();
	    }
		public Mesa(int nroMesa, int capacidad, double consumo, Estado estado) {
			super();
			this.nroMesa = nroMesa;
			this.capacidad = capacidad;
			this.consumo = consumo;
			this.estado = estado;
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

		    public Estado setState() {
				this.estado = estado;
		    	return estado;
		    }
}
