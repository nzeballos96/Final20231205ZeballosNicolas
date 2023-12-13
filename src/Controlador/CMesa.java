package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Conect;
import Modelo.Mesa;

public class CMesa extends Mesa {
	private ArrayList<Mesa> mesas;

	Conect cn = new Conect();

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
//		Estado estado = Estado.LIBRE;

		// Agregar la mesa al arraylist
		Mesa mesa = new Mesa();
		mesa.setIdmesa(Idmesa);
		mesa.setNroMesa(nroMesa);
		mesa.setCapacidad(capacidad);
		mesa.setConsumo(consumo);
		mesa.setEstado(Estado.LIBRE);
		mesa.setIdresto(idresto);

		// Insertar la mesa en la base de datos
		cn.conexion();
		PreparedStatement ps = cn.conexion().prepareStatement("INSERT INTO mesa "
				+ "(IDMESA, NUMMESA, CAPACIDAD, CONSUMO, ESTADO, IDRESTAURANT) " + "VALUES (?, ?, ?, ?, ? , ?)");

		ps.setInt(1, mesa.getIdmesa());
		ps.setInt(2, mesa.getNroMesa());
		ps.setInt(3, mesa.getCapacidad());
		ps.setDouble(4, mesa.getConsumo());
		ps.setString(5, mesa.getEstado().toString());
		ps.setInt(6, mesa.getIdresto());

		ps.execute();

		System.out.println("Mesa cargada");
		cn.cerrar();
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
			mesa.setConsumo((double) rs.getInt("consumo"));
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
			mesa.setConsumo((double) rs.getInt("consumo"));
			mesasReservadas.add(mesa);
		}

		return mesasReservadas;
	}

	public ArrayList<Mesa> mesasOcupadas(int idresto) throws SQLException {

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
			mesa.setConsumo((double) rs.getInt("consumo"));
			mesasOcupadas.add(mesa);
		}

		return mesasOcupadas;
	}

	public void imprimirMesas(ArrayList<Mesa> mesas) {
		System.out.println("| Nro Mesa | Capacidad | Consumo |");
		System.out.println("|----------|-----------|---------|");
		for (Mesa mesa : mesas) {
			System.out.printf(" | %2d      | %2d       | %2f     |%n", mesa.getNroMesa(), mesa.getCapacidad(),
					mesa.getConsumo());
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

	public void ocuparMesa(int nroMesa, int idresto) throws SQLException {
	    try {
	        cn.conexion();

	        String sqlControl = "SELECT * FROM mesa WHERE NUMMESA = ? AND IDRESTAURANT = ? AND (ESTADO = 'LIBRE' OR ESTADO = 'RESERVADA')";
	        PreparedStatement statementControl = cn.conexion().prepareStatement(sqlControl);
	        statementControl.setInt(1, nroMesa);
	        statementControl.setInt(2, idresto);
	        ResultSet rsControl = statementControl.executeQuery();

	        if (!rsControl.next()) {
	            System.out.println("Error: La mesa no está disponible.");
	            return;
	        }

	        String sqlOcupar = "UPDATE mesa SET ESTADO = 'OCUPADA' WHERE NUMMESA = ? AND IDRESTAURANT = ?";
	        PreparedStatement statement = cn.conexion().prepareStatement(sqlOcupar);
	        statement.setInt(1, nroMesa);
	        statement.setInt(2, idresto);

	        statement.executeUpdate();

	        System.out.println("Mesa " + nroMesa + " marcada como ocupada.");
	    } catch (SQLException e) {
	        System.out.println("Error al ocupar la mesa: " + e.getMessage());
	    } finally {
	        cn.cerrar();
	    }
	}

	public void reservarMesa(int nroMesa, int idresto) throws SQLException {
	    try {
	        cn.conexion();

	        String sqlControl = "SELECT * FROM mesa WHERE ESTADO = 'LIBRE' AND NUMMESA = ? AND IDRESTAURANT = ?";
	        PreparedStatement statementControl = cn.conexion().prepareStatement(sqlControl);
	        statementControl.setInt(1, nroMesa);
	        statementControl.setInt(2, idresto);
	        ResultSet rsControl = statementControl.executeQuery();

	        if (!rsControl.next()) {
	            System.out.println("Error: La mesa no está disponible.");
	            return;
	        }

	        String sqlReservar = "UPDATE mesa SET ESTADO = 'RESERVADA' WHERE nummesa = ? and IDRESTAURANT = ?";
	        PreparedStatement statement = cn.conexion().prepareStatement(sqlReservar);
	        statement.setInt(1, nroMesa);
	        statement.setInt(2, idresto);

	        statement.executeUpdate();

	        System.out.println("Mesa " + nroMesa + " reservada con éxito.");
	    } catch (SQLException e) {
	        System.out.println("Error al reservar la mesa: " + e.getMessage());
	    } finally {
	        cn.cerrar();
	    }
	}

	public void liberarMesa(int nroMesa, int idresto) throws SQLException {
		cn.conexion();
		
		String sqlControl = "SELECT * FROM mesa WHERE ESTADO <> 'LIBRE' AND NUMMESA = ? AND IDRESTAURANT = ?";
	    PreparedStatement statementControl = cn.conexion().prepareStatement(sqlControl);
	    statementControl.setInt(1, nroMesa);
	    statementControl.setInt(2, idresto);
	    ResultSet rsControl = statementControl.executeQuery();

	    if (!rsControl.next()) {
	        System.out.println("ERROR, MESA NO DISPONIBLE");
	        return;
	    }

	    // Liberar la mesa
	    String sqlLiberar = "UPDATE mesa SET estado = 'LIBRE' and consumo = 0 WHERE nummesa = ? AND IDRESTAURANT = ?";
	    PreparedStatement statement = cn.conexion().prepareStatement(sqlLiberar);
	    statement.setInt(1, nroMesa);
	    statement.setInt(2, idresto);

	    statement.executeUpdate(); // Usa executeUpdate para UPDATE

	    System.out.println("Mesa " + nroMesa + " marcada como libre.");
	}
	

	public void eliminarMesa(int nroMesa, int idresto) throws SQLException {
		
		cn.conexion();
		
		
		 try {
		        cn.conexion();

		        // Comprobar si la mesa está libre
		        String sqlControl = "SELECT * FROM mesa WHERE ESTADO = 'LIBRE' AND NUMMESA = ? AND IDRESTAURANT = ?";
		        PreparedStatement statementControl = cn.conexion().prepareStatement(sqlControl);
		        statementControl.setInt(1, nroMesa);
		        statementControl.setInt(2, idresto);
		        ResultSet rsControl = statementControl.executeQuery();

		        if (!rsControl.next()) {
		            System.out.println("ERROR, MESA NO DISPONIBLE");
		            return;
		        }

		        // Eliminar la mesa
		        String sqlEliminar = "DELETE FROM mesa WHERE nummesa = ? AND IDRESTAURANT = ?";
		        PreparedStatement statement = cn.conexion().prepareStatement(sqlEliminar);
		        statement.setInt(1, nroMesa);
		        statement.setInt(2, idresto);

		        int filasAfectadas = statement.executeUpdate();

		        if (filasAfectadas == 0) {
		            System.out.println("Error: La mesa no se pudo eliminar. La mesa puede estar ocupada o reservada.");
		        } else {
		            System.out.println("Mesa " + nroMesa + " eliminada con éxito.");
		        }
		    } catch (SQLException e) {
		        System.out.println("Error al eliminar la mesa: " + e.getMessage());
		    } finally {
		        cn.cerrar();
		    }
	}

	public void cargarConsumo(int nroMesa, int idresto, double consumo) throws SQLException {
	    try {
	        cn.conexion();

	        // Verifica que la mesa esté ocupada
	        String sqlVerificaOcupacion = "SELECT consumo FROM mesa WHERE nummesa = ? AND idrestaurante = ?";
	        PreparedStatement statementVerificaOcupacion = cn.conexion().prepareStatement(sqlVerificaOcupacion);
	        statementVerificaOcupacion.setInt(1, nroMesa);
	        statementVerificaOcupacion.setInt(2, idresto);

	        ResultSet rs = statementVerificaOcupacion.executeQuery();

	        if (!rs.next()) {
	            System.out.println("La mesa no existe o está libre.");
	            return;
	        }

	        // Obtiene el consumo actual de la mesa
	        double consumoActual = rs.getDouble("consumo");

	        // Suma el consumo nuevo al consumo actual
	        consumoActual += consumo;

	        // Actualiza el consumo de la mesa
	        String sqlActualizar = "UPDATE mesa SET consumo = ? WHERE nummesa = ? AND idrestaurante = ?";
	        PreparedStatement statementActualizar = cn.conexion().prepareStatement(sqlActualizar);
	        statementActualizar.setDouble(1, consumoActual);
	        statementActualizar.setInt(2, nroMesa);
	        statementActualizar.setInt(3, idresto);
	        statementActualizar.executeUpdate();

	        System.out.println("Consumo cargado con éxito.");
	    } catch (SQLException e) {
	        System.out.println("Error al cargar el consumo: " + e.getMessage());
	    } finally {
	        cn.cerrar();
	    }
	}

}


