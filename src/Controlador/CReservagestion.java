package Controlador;

import Modelo.Reservagestion;
import Modelo.Conect;
import Modelo.Estado;
import Modelo.Mesa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class CReservagestion extends Reservagestion {

	private ArrayList<Reservagestion> reservas;

	public CReservagestion() {
		reservas = new ArrayList<>();
	}

	public void reservarmesa(int nroMmesa, int idresto, String fecha, String nombre, String apellido,
			int cantidadComensales) throws SQLException {

		Conect cn = new Conect();
		cn.conexion();

		String vermesa = "SELECT NUMMESA, CAPACIDAD, CONSUMO FROM mesa WHERE IDRESTAURANT = ? and NUMMESA = ? ";

		PreparedStatement statement = cn.conexion().prepareStatement(vermesa);
		statement.setInt(1, idresto);
		statement.setInt(2, nroMmesa);

		ResultSet rs = statement.executeQuery();

		if (rs != null) {
			System.out.println("SELECCIONE UNA MESA VALIDA");
			reservarmesa(nroMmesa, idresto, fecha, nombre, apellido, cantidadComensales);
		} else {
			System.out.println("INGRESE EL TOTAL DE COMENSALES");
			String vercomen = "SELECT NUMMESA, CAPACIDAD FROM mesa WHERE IDRESTAURANT = ? and NUMMESA = ? and CAPACIDAD >= ? ";

			PreparedStatement statement1 = cn.conexion().prepareStatement(vercomen);
			statement1.setInt(1, idresto);
			statement1.setInt(2, nroMmesa);
			statement1.setInt(3, cantidadComensales);

			ResultSet rs1 = statement.executeQuery();

			if (rs1 == null) {
				System.out.println("LA CANTIDAD DE COMENSALES NO PUEDE MAYOR A LA CAPACIDAD DE LA MESA");
				reservarmesa(nroMmesa, idresto, fecha, nombre, apellido, cantidadComensales);
			} else {

				try {
					Reservagestion reserva = new Reservagestion();
					reserva.setFecha(fecha);
					reserva.setNombre(nombre);
					reserva.setApellido(apellido);
					reserva.setCantidadComensales(cantidadComensales);
					reserva.setNroMesa(getNroMesa());
					reserva.setIdresto(getIdresto());
					reservas.add(reserva);

					cn.conexion();
					PreparedStatement ps = cn.conexion().prepareStatement("INSERT INTO reserva " +
							"(ID, FECH_RES, NOMBRE, APELLIDO, IDMESA, IDRESTO)" +
							" VALUES (null, ?, ?, ?, ?, ?)");

					((PreparedStatement) ps).setString(1, reserva.getFecha());
					((PreparedStatement) ps).setString(2, reserva.getNombre());
					((PreparedStatement) ps).setString(3, reserva.getApellido());
					((PreparedStatement) ps).setInt(4, reserva.getNroMesa());
					((PreparedStatement) ps).setInt(5, reserva.getIdresto());

					ps.execute();

				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		}

	}

}
