package Controlador;

import Modelo.Reservar;
import Modelo.Mesa;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

	public class CReserva extends Reservar {


	    public boolean existeMesa(int nroMesa) {
	        
	        ArrayList<Mesa> mesas = new ArrayList<>();
	        
	        for (Mesa mesa : mesas) {
	            if (mesa.getNroMesa() == nroMesa) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public boolean estaOcupada(int nroMesa, Date fecha) {

	        ArrayList<Reservar> reservas = new ArrayList<>();

	        for (Reservar reserva : reservas) {
	            if (reserva.getNroMesa().getNroMesa() == nroMesa && reserva.getFecha().equals(fecha)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public void crearReserva() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Ingrese el número de mesa: ");
	        int nroMesa = sc.nextInt();

	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        System.out.println("Ingrese la fecha en formato dd/MM/yyyy: ");
	        String fechaString = sc.next();
	        Date fecha = null;
	        try {
	            fecha = formatter.parse(fechaString);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        if (existeMesa(nroMesa) && !estaOcupada(nroMesa, fecha)) {
	            Reservar reserva = new Reservar(fecha, nombre, apellido, cantidadComensales, new Mesa(nroMesa));
	            System.out.println("Reserva creada con éxito.");
	        } else {
	            System.out.println("La mesa no existe o está ocupada.");
	        }
	    }
	}
		

