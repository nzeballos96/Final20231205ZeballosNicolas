package Modelo;

import java.util.Date;

public class Reservagestion extends Restaurant{
	   private Date fecha;
	    private String nombre;
	    private String apellido;
	    private int cantidadComensales;
	    private Mesa nroMesa;
	    
	    public Reservagestion() {
	        super();
	    }
	    
	    public Reservagestion(Date fecha, String nombre, String apellido, int cantidadComensales, Mesa nroMesa) {
	        super();
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
	    
	    public Mesa getNroMesa() {
	        return nroMesa;
	    }
	    
	    public void setNroMesa(Mesa nroMesa) {
	        this.nroMesa = nroMesa;
	    }
	}
