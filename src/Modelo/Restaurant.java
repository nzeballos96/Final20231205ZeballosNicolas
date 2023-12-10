package Modelo;

public class Restaurant {

	String nombre, domicilio;
	int id;

	public Restaurant(String nombre, String domicilio, int id, Mesa mesa, Reservar reserva) {
		super();
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.id = id;
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

}
