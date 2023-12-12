package Modelo;

import java.util.Date;

public class Reservagestion extends Restaurant {
	private String fecha;
	private String nombre;
	private String apellido;
	private int cantidadComensales;
	private int nroMesa;
	private int idresto;

	public Reservagestion() {
		super();
	}

	public Reservagestion(String fecha, String nombre, String apellido, int cantidadComensales, int nroMesa) {
		super();
		this.fecha = fecha;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cantidadComensales = cantidadComensales;
		this.nroMesa = nroMesa;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(int cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}

	public int getNroMesa() {
		return nroMesa;
	}

	public void setNroMesa(int nroMesa) {
		this.nroMesa = nroMesa;
	}

	public int getIdresto() {
		return idresto;
	}

	public void setIdresto(int idresto) {
		this.idresto = idresto;
	}

}
