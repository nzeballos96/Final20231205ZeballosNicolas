package Modelo;

public class Mesa implements Estado{
	private int idmesa;
	private int nroMesa;
	private int capacidad;
	private Double consumo;
	public Estado estado;
	private int idresto;
	
	   public enum Estado {
	        LIBRE,
	        RESERVADA,
	        OCUPADA;

			public String SetState() {
				// TODO Auto-generated method stub
				return null;
			}
	    }
	   
	public Mesa(int nroMesa, int capacidad, Double consumo) {
		this.nroMesa = nroMesa;
		this.capacidad = capacidad;
		this.consumo = consumo;
		this.estado = Estado.LIBRE; 
	}
	public Mesa(int nroMesa, int capacidad) {
		this.nroMesa = nroMesa;
		this.capacidad = capacidad;
		this.estado = Estado.LIBRE; 
	}
	public Mesa() {
		
	}
	
	public int getIdmesa() {
		return idmesa;
	}
	public void setIdmesa(int idmesa) {
		this.idmesa = idmesa;
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
	public Double getConsumo() {
		return consumo;
	}
	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	public int getIdresto() {
		return idresto;
	}
	public void setIdresto(int idresto) {
		this.idresto = idresto;
	}
	@Override
	public void liberar(Mesa m) {
		m.setState(Estado.LIBRE);
		this.consumo = 0.0; 
		
	}
	@Override
	public void reservar(Mesa m) throws Exception{

		if(m.getEstado().equals(Estado.OCUPADA)) {
			throw new Exception("No se puede reservar la mesa porque está OCUPADA.");
		} else if(m.getEstado().equals(Estado.RESERVADA)){
			throw new Exception("No se puede reservar la mesa porque está RESERVADA.");
		} else {		
		m.setState(Estado.RESERVADA);
		System.out.println("Mesa reservada con éxito!");
		}
		
	}
	@Override
	public void ocupar(Mesa m) {
		if( m.getEstado().equals(Estado.OCUPADA)) {
			throw new RuntimeException("No se puede ocupar una mesa ya ocupada.");
		}else {
			m.setState(Estado.OCUPADA);
		}
		
	}
	
	public void setState(Estado estado) {
		this.estado = estado;
	}
	
    public String SetState() {
        return this.estado.toString();
    }

}
