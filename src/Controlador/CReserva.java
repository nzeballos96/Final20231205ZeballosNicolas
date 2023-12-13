package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Modelo.Conect;
import Modelo.Mesa;
import Modelo.Reserva;

public class CReserva {

	private ArrayList<Reserva> reservas;
	Conect cn = new Conect();
	CMesa cmesa = new CMesa();


	public CReserva() {
		reservas = new ArrayList<>();
	}

	 public void reservarMesa(int nroMesar, int idrestor, String fecha, String nombre, String apellido, int cantidadComensales) throws SQLException {
	        try {
	            cn.conexion();

	            String sqlVerMesa = "SELECT NUMMESA, CAPACIDAD FROM mesa WHERE IDRESTAURANT = ? AND NUMMESA = ? AND CAPACIDAD >= ?";
	            PreparedStatement statement = cn.conexion().prepareStatement(sqlVerMesa);
	            statement.setInt(1, idrestor);
	            statement.setInt(2, nroMesar);
	            statement.setInt(3, cantidadComensales);

	            ResultSet rs = statement.executeQuery();

	            if (!rs.next()) {
	                System.out.println("Error: La mesa no existe o no tiene suficiente capacidad para la cantidad de comensales.");
	                return;
	            }

	            Reserva reserva = new Reserva();
	            reserva.setFecha(fecha);
	            reserva.setNombre(nombre);
	            reserva.setApellido(apellido);
	            reserva.setCantidadComensales(cantidadComensales);
	            reserva.setNroMesar(nroMesar);
	            reserva.setIdrestor(idrestor);
	            reservas.add(reserva);

	            String sqlInsertar = "INSERT INTO reserva (FECH_RES, NOMBRE, APELLIDO,COMENSALES, IDMESA, IDRESTO) VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement statementInsertar = cn.conexion().prepareStatement(sqlInsertar);
	            statementInsertar.setString(1, reserva.getFecha());
	            statementInsertar.setString(2, reserva.getNombre());
	            statementInsertar.setString(3, reserva.getApellido());
	            statementInsertar.setInt(4, reserva.getCantidadComensales());
	            statementInsertar.setInt(5, reserva.getNroMesar());
	            statementInsertar.setInt(6, reserva.getIdrestor());

	            statementInsertar.executeUpdate();
	            
	            cmesa.reservarMesa(nroMesar, idrestor);

	            System.out.println("Mesa reservada con éxito.");
	        } catch (SQLException e) {
	            System.out.println("Error al reservar la mesa: " + e.getMessage());
	        } finally {
	            cn.cerrar();
	        }
	    }
	 
		public ArrayList<Reserva> reservasfecha(int idresto, String fecha) throws SQLException {
			Conect cn = new Conect();
			cn.conexion();

			String cargamesa = "SELECT FECH_RES,NOMBRE,APELLIDO,COMENSALES,IDMESA FROM reserva WHERE FECH_RES = ? AND IDRESTO = ? ";

			PreparedStatement statement = cn.conexion().prepareStatement(cargamesa);
			statement.setString(1, fecha);
			statement.setInt(2, idresto);

			ResultSet rs = statement.executeQuery();
			ArrayList<Reserva> reservasfechas= new ArrayList<>();

			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setFecha(rs.getString("FECHA"));
				reserva.setNombre(rs.getString("NOMBRE"));
				reserva.setApellido(rs.getString("APELLIDO"));
				reserva.setCantidadComensales(rs.getInt("COMENSALES"));
				reserva.setNroMesar(rs.getInt("MESA"));
				
				
				reservasfechas.add(reserva);
			}

			return reservasfecha(idresto,fecha);
		}

		public void imprimirreserva(ArrayList<Reserva> resrfechas) {
			System.out.println("| FECHA    | NOMBRE    | APELLIDO| COMENSALES | MESA    |");
			System.out.println("|----------|-----------|---------|------------|---------|");
			for (Reserva reserva : resrfechas) {
			System.out.printf(" | %2d      | %2d       | %2d     | %2d        | %2f     |%n", reserva.getFecha(), reserva.getNombrer(),
						reserva.getApellido(),reserva.getCantidadComensales(),reserva.getNroMesar());
			
		}
}
}
