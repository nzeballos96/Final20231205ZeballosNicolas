package Modelo;

public class Restaurant {
    
    String nombre,domicilio;
    int id;
    Mesa mesa;
    Reserva reserva;
    
    public Restaurant(String nombre, String domicilio, int id, Mesa mesa, Reserva reserva) {
		super();
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.id = id;
		this.mesa = mesa;
		this.reserva = reserva;
	}
	public Restaurant() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	

}
