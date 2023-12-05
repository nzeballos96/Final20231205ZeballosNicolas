package Modelo;

import java.util.Date;

public class Reserva {

	private Date fecha;
	private String nombre;
	private String apellido;
	private int cantidadComensales;
	private int nroMesa;

	public Reserva() {
	}

	public Reserva(Date fecha, String nombre, String apellido, int cantidadComensales, int nroMesa) {
		this.fecha = fecha;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cantidadComensales = cantidadComensales;
		this.nroMesa = nroMesa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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

	@Override
	public String toString() {
		return "Reserva [fecha=" + fecha + ", nombre=" + nombre + ", apellido=" + apellido + ", cantidadComensales="
				+ cantidadComensales + ", nroMesa=" + nroMesa + "]";
	}
}