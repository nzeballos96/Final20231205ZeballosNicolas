package Modelo;

import java.util.Date;

public class Reserva extends Restaurant {
		private String fecha;
		private String nombrer;
		private String apellido;
		private int cantidadComensales;
		private int nroMesar;
		private int idrestor;
	
	

		public Reserva(String nombre, String domicilio, int id, String fecha, String nombrer, String apellido,
				int cantidadComensales, int nroMesar, int idrestor) {
			super(nombre, domicilio, id);
			this.fecha = fecha;
			this.nombrer = nombrer;
			this.apellido = apellido;
			this.cantidadComensales = cantidadComensales;
			this.nroMesar = nroMesar;
			this.idrestor = idrestor;
		}



		public String getFecha() {
			return fecha;
		}



		public void setFecha(String fecha) {
			this.fecha = fecha;
		}



		public String getNombrer() {
			return nombrer;
		}



		public void setNombrer(String nombrer) {
			this.nombrer = nombrer;
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



		public int getNroMesar() {
			return nroMesar;
		}



		public void setNroMesar(int nroMesar) {
			this.nroMesar = nroMesar;
		}



		public int getIdrestor() {
			return idrestor;
		}



		public void setIdrestor(int idrestor) {
			this.idrestor = idrestor;
		}



		public Reserva() {
			super();
		}

	
}
