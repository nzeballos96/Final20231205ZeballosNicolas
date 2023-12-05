package Modelo;


	public class Mesa implements Estado {


		
	    public Mesa() {
			super();
		}

		private int nroMesa;
	    private int capacidad;
	    private double consumo;
	    private EEstado estado;

	    public Mesa(int nroMesa, int capacidad) {
	        this.nroMesa = nroMesa;
	        this.capacidad = capacidad;
	        this.consumo = 0;
	       this.estado = EEstado.Libre;
	    }

	    public int getNroMesa() {
	        return nroMesa;
	    }

	    public int getCapacidad() {
	        return capacidad;
	    }

	    public double getConsumo() {
	        return consumo;
	    }

	    public EEstado getEstado() {
	        return estado;
	    }


	    public void setNroMesa(int nroMesa) {
			this.nroMesa = nroMesa;
		}

		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}

		public void setConsumo(double consumo) {
			this.consumo = consumo;
		}

		public void setEstado(EEstado estado) {
			this.estado = estado;
		}

		@Override
		public void liberar(Mesa m) {
			this.estado =  EEstado.Libre;
			
		}

		@Override
		public void reservar(Mesa m) {
			this.estado =  EEstado.Reservado;
			
		}

		@Override
		public void ocupar(Mesa m) {
			this.estado =  EEstado.Ocupado;
			
		}

		@Override
		public boolean setSate(Estado state) {
			// TODO Auto-generated method stub
			return false;
		}



	    }

