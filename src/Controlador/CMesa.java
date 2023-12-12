package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.mysql.cj.xdevapi.PreparableStatement;

import Modelo.*;

public class CMesa extends Mesa {

	private ArrayList<Mesa> mesas;

	public CMesa() {

		mesas = new ArrayList<>();

	}

	public void cargarMesa(int nroMesa, int capacidad, int idresto) throws SQLException {

		// Inicializar la variable mesas
		ArrayList<Mesa> mesas = new ArrayList<>();

		// Validar que el numero de mesa sea valido
		if (nroMesa < 1) {
			System.out.println("El numero de mesa debe ser mayor a 1");
			return;
		}

		// Validar que la mesa no exista
		Conect cn = new Conect();
		cn.conexion();

		String vermesa = "SELECT NUMMESA, CAPACIDAD, CONSUMO FROM mesa WHERE IDRESTAURANT = ? and NUMMESA = ? ";

		PreparedStatement statement = cn.conexion().prepareStatement(vermesa);
		statement.setInt(1, idresto);
		statement.setInt(2, nroMesa);

		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
			System.out.println("MESA YA EXISTE");
			return;
		}

		// Validar que la capacidad sea valida
		if (capacidad < 1) {
			System.out.println("La capacidad debe mayor a 1");
			return;
		}

		int Idmesa = 0;
		double consumo = 0.0;
		Estado estado = LIBRE;

		// Agregar la mesa al arraylist
		Mesa mesa = new Mesa();
		mesa.setIdmesa(Idmesa);
		mesa.setNroMesa(nroMesa);
		mesa.setCapacidad(capacidad);
		mesa.setConsumo(consumo);
		mesa.setEstado(estado);
		mesa.setRestoid(idresto);

		// Insertar la mesa en la base de datos
		cn.conexion();
		PreparedStatement ps = cn.conexion().prepareStatement("INSERT INTO mesa "
				+ "(IDMESA, NUMMESA, CAPACIDAD, CONSUMO, ESTADO, IDRESTAURANT) "
				+ "VALUES (?, ?, ?, ?, ?, ?)");

		((PreparedStatement) ps).setInt(1, mesa.getIdmesa());
		((PreparedStatement) ps).setInt(2, mesa.getNroMesa());
		((PreparedStatement) ps).setInt(3, mesa.getCapacidad());
		((PreparedStatement) ps).setDouble(4, mesa.getConsumo());
		((PreparedStatement) ps).setString(5, mesa.getEstado().SetState());
		((PreparedStatement) ps).setInt(6, mesa.getRestoid());

		ps.execute();

		System.out.println("Mesa cargada");
		cn.cerrar();
	}

	public void eliminarMesa(int nroMesa) {

		for (Mesa mesa : mesas) {
			if (mesa.getNroMesa() == nroMesa) {
				mesas.remove(mesa);
				System.out.println("Mesa eliminada");
				return;
			}
		}

		System.out.println("No se encontro la mesa");
	}

	public ArrayList<Mesa> mesasLibres(int idresto) throws SQLException {
		Conect cn = new Conect();
		cn.conexion();

		String cargamesa = "SELECT NUMMESA, CAPACIDAD, CONSUMO FROM mesa WHERE IDRESTAURANT = ? and ESTADO = 'LIBRE' ";

		PreparedStatement statement = cn.conexion().prepareStatement(cargamesa);
		statement.setInt(1, idresto);

		ResultSet rs = statement.executeQuery();
		ArrayList<Mesa> mesasLibres = new ArrayList<>();

		while (rs.next()) {
			Mesa mesa = new Mesa();
			mesa.setNroMesa(rs.getInt("numMesa"));
			mesa.setCapacidad(rs.getInt("capacidad"));
			mesa.setConsumo(rs.getInt("consumo"));
			mesasLibres.add(mesa);
		}

		return mesasLibres;
	}

	public ArrayList<Mesa> mesasReservadas(int idresto) throws SQLException {
		Conect cn = new Conect();
		cn.conexion();

		String cargamesa = "SELECT NUMMESA, CAPACIDAD, CONSUMO FROM mesa WHERE IDRESTAURANT = ? and ESTADO = 'RESERVADA' ";

		PreparedStatement statement = cn.conexion().prepareStatement(cargamesa);
		statement.setInt(1, idresto);

		ResultSet rs = statement.executeQuery();

		ArrayList<Mesa> mesasReservadas = new ArrayList<>();

		while (rs.next()) {
			Mesa mesa = new Mesa();
			mesa.setNroMesa(rs.getInt("numMesa"));
			mesa.setCapacidad(rs.getInt("capacidad"));
			mesa.setConsumo(rs.getInt("consumo"));
			mesasReservadas.add(mesa);
		}

		return mesasReservadas;
	}

	public ArrayList<Mesa> mesasOcupadas(int idresto) throws SQLException {
		Conect cn = new Conect();
		cn.conexion();

		String cargamesa = "SELECT NUMMESA, CAPACIDAD, CONSUMO FROM mesa WHERE IDRESTAURANT = ? and ESTADO = 'OCUPADA' ";

		PreparedStatement statement = cn.conexion().prepareStatement(cargamesa);
		statement.setInt(1, idresto);

		ResultSet rs = statement.executeQuery();

		ArrayList<Mesa> mesasOcupadas = new ArrayList<>();

		while (rs.next()) {
			Mesa mesa = new Mesa();
			mesa.setNroMesa(rs.getInt("numMesa"));
			mesa.setCapacidad(rs.getInt("capacidad"));
			mesa.setConsumo(rs.getInt("consumo"));
			mesasOcupadas.add(mesa);
		}

		return mesasOcupadas;
	}

	public void imprimirMesas(ArrayList<Mesa> mesas) {
		System.out.println("| Nro Mesa | Capacidad | Consumo |");
		System.out.println("|----------|-----------|---------|");
		for (Mesa mesa : mesas) {
			System.out.printf(" | %2d      | %2d       | %2f     |%n",
					mesa.getNroMesa(), mesa.getCapacidad(), mesa.getConsumo());
		}
	}

	public void listarmesas(int idresto) throws SQLException {
		System.out.println("<=========================================>");
		ArrayList<Mesa> mesasLibres = mesasLibres(idresto);
		System.out.println("Mesas libres:");
		imprimirMesas(mesasLibres);
		System.out.println("<=========================================>");
		System.out.println("<=========================================>");

		ArrayList<Mesa> mesasReservadas = mesasReservadas(idresto);
		System.out.println("Mesas reservadas:");
		imprimirMesas(mesasReservadas);
		System.out.println("<=========================================>");
		System.out.println("<=========================================>");

		ArrayList<Mesa> mesasOcupadas = mesasOcupadas(idresto);
		System.out.println("Mesas ocupadas:");
		imprimirMesas(mesasOcupadas);
		System.out.println("<=========================================>");
	}

	public void cambiarEstado(int nroMesa, int idresto, String estadoNuevo) throws SQLException {

		/*
		 * Mesa mesa = new Mesa();
		 * 
		 * // Validar que la mesa exista
		 * Conect cn = new Conect();
		 * cn.conexion();
		 * 
		 * String sql =
		 * "SELECT numMesa FROM mesa WHERE numMesa = ? AND idrestaurant = ?";
		 * PreparedStatement statement = cn.conexion().prepareStatement(sql);
		 * statement.setInt(1, nroMesa);
		 * statement.setInt(2, idresto);
		 * 
		 * // Ejecutar la consulta
		 * ResultSet rs = statement.executeQuery();
		 * 
		 * // Validar que la mesa exista
		 * if (!rs.next()) {
		 * System.out.println("No se encontró la mesa");
		 * return;
		 * }
		 * 
		 * // Obtener el estado actual de la mesa
		 * Estado estadoActual = Estado.valueOf(rs.getString("estado"));
		 * 
		 * // Cambiar el estado de la mesa
		 * switch (estadoNuevo) {
		 * case "Ocupada":
		 * if (estadoActual == Estado.LIBRE) {
		 * mesa.setEstado(new Ocupar());
		 * } else if (estadoActual == Estado.RESERVADA) {
		 * System.out.println("La mesa ya está reservada");
		 * return;
		 * }
		 * break;
		 * case "Reservada":
		 * if (estadoActual == Estado.LIBRE) {
		 * mesa.setEstado(new Reservar());
		 * } else if (estadoActual == Estado.OCUPADA) {
		 * System.out.println("La mesa ya está ocupada");
		 * return;
		 * }
		 * break;
		 * default:
		 * System.out.println("El estado nuevo debe ser 'Ocupada' o 'Reservada'");
		 * return;
		 * }
		 * 
		 * // Actualizar el estado de la mesa en la base de datos
		 * 
		 * sql = "UPDATE mesa SET estado = ? WHERE numMesa = ? AND idrestaurant = ?";
		 * statement = cn.conexion().prepareStatement(sql);
		 * statement.setString(1, mesa.getEstado().toString());
		 * statement.setInt(2, mesa.getNroMesa());
		 * statement.setInt(3, idresto);
		 * 
		 * statement.executeUpdate();
		 * 
		 * System.out.println("Estado de la mesa actualizado");
		 * 
		 * cn.cerrar();
		 * }
		 */
	}

}
