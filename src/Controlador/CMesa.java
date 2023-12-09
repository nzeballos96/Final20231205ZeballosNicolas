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

	public void cargarMesa(int nroMesa, int capacidad, int idresto) {

		// Validar que el numero de mesa sea valido
		if (nroMesa < 1 || nroMesa > 100) {
			System.out.println("El numero de mesa debe ser un valor entre 1 y 100");
			return;
		}

		// // Inicializar la variable mesa
		Mesa mesa = new Mesa();

		// Validar que la mesa no exista
		for (Mesa m : mesas) {
			if (m.getNroMesa() == nroMesa && m.getRestoid() == idresto) {
				System.out.println("Ya existe una mesa con ese numero");
				return;
			}
		}

		int prueba = 0;
		int Idmesa = 0;
		double consumo = 0.0;

		// Validar que la capacidad sea valida
		if (capacidad < 1 || capacidad > 10) {
			System.out.println("La capacidad debe ser un valor entre 1 y 10");
			return;
		}

		// Agregar la mesa al arraylist
		mesa.setIdmesa(Idmesa);
		mesa.setNroMesa(nroMesa);
		mesa.setCapacidad(capacidad);
		mesa.setConsumo(consumo);
		mesa.setPrueba(prueba);
		mesa.setRestoid(idresto);
		;
		mesas.add(mesa);

		try {

			Conect cn = new Conect();
			cn.conexion();
			PreparedStatement ps = cn.conexion().prepareStatement("INSERT INTO mesa "
					+ "(IDMESA, NUMMESA, CAPACIDAD, CONSUMO, ESTADO, IDRESTAURANT) "
					+ "VALUES (?, ?, ?, ?, ?, ?)");

			((PreparedStatement) ps).setInt(1, mesa.getIdmesa());
			((PreparedStatement) ps).setInt(2, mesa.getNroMesa());
			((PreparedStatement) ps).setInt(3, mesa.getCapacidad());
			((PreparedStatement) ps).setDouble(4, mesa.getConsumo());
			((PreparedStatement) ps).setInt(5, mesa.getPrueba());
			((PreparedStatement) ps).setInt(6, mesa.getRestoid());

			ps.execute();

			System.out.println("Mesa cargada");
			cn.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Mesa> getMesas() {
		return mesas;
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

	public void cambiarEstado(int nroMesa) {

		// Buscar la mesa con el número especificado
		Mesa mesa = null;
		for (Mesa m : mesas) {
			if (m.getNroMesa() == nroMesa) {
				mesa = m;
				break;
			}
		}

		// Validar que la mesa exista
		if (mesa == null) {
			System.out.println("No se encontró la mesa");
			return;
		}

		// Obtener el estado actual de la mesa
		Estado estadoActual = mesa.getEstado();

		// Solicitar al usuario el estado nuevo
		System.out.println("Ingrese el estado nuevo de la mesa (1 = Ocupada, 2 = Reservada):");
		int estadoNuevo = new Scanner(System.in).nextInt();

		// Validar el estado nuevo
		if (estadoNuevo != 1 && estadoNuevo != 2) {
			System.out.println("El estado nuevo debe ser 1 o 2");
			return;
		}

		// Validar que la mesa no esté ocupada
		if (estadoActual == this.getEstado()) {
			System.out.println("La mesa ya está ocupada");
			return;
		}

		// Validar que la mesa no esté reservada
		if (estadoActual == this.getEstado()) {
			System.out.println("La mesa ya está reservada");
			return;
		}

		// Cambiar el estado de la mesa
		if (estadoNuevo == 1) {
			// mesa.setEstado(new Ocupar());
			System.out.println("Mesa ocupada");
		} else {
			mesa.setEstado(new Reservado());
			System.out.println("Mesa reservada");
		}
	}

	public ArrayList<Mesa> cargarmesas(int idresto) {
		// ArrayList<Mesa> mesas = new ArrayList<>();

		try {
			Conect cn = new Conect();
			cn.conexion();
			Mesa mesa = new Mesa();
			String cargamesa = "SELECT NUMMESA, CAPACIDAD, CONSUMO FROM mesa WHERE IDRESTAURANT = ?";

			PreparedStatement statement = cn.conexion().prepareStatement(cargamesa);
			statement.setInt(1, idresto);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				mesa.setNroMesa(rs.getInt("numMesa"));
				mesa.setCapacidad(rs.getInt("capacidad"));
				mesa.setConsumo(rs.getInt("consumo"));

				mesas.add(mesa);
			}
		} catch (SQLException e) {
			System.out.println("Error al cargar las mesas: " + e.getMessage());
		}

		return mesas;
	}
}
