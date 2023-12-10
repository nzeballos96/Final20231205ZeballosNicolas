package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Conect;
import Modelo.Mesa;
import Modelo.Restaurant;

public class CRestaurant extends Restaurant {

    private ArrayList<Restaurant> resto;

    public CRestaurant() {

        resto = new ArrayList<>();

    }

    public void cargarresto(String nombre, String domicilio) {

        Restaurant rest = new Restaurant();

        int idrestore = 0;

        // Agregar la mesa al arraylist
        rest.setId(idrestore);
        rest.setNombre(nombre);
        rest.setDomicilio(domicilio);
        resto.add(rest);

        try {

            Conect cn = new Conect();
            cn.conexion();
            PreparedStatement ps = cn.conexion().prepareStatement("INSERT INTO restaurant " +
                    " (ID, NOMBRE, DOMICILIO) " +
                    "VALUES (?, ?, ?)");

            ((PreparedStatement) ps).setInt(1, rest.getId());
            ((PreparedStatement) ps).setString(2, rest.getNombre());
            ((PreparedStatement) ps).setString(3, rest.getDomicilio());

            ps.execute();

            System.out.println("RESTAURANT CREADO");
            cn.cerrar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Restaurant> getRestautant() {
        return resto;
    }

    public ArrayList<Restaurant> listarrestoArrayList() {
        try {
            Conect cn = new Conect();
            cn.conexion();
            Restaurant rest = new Restaurant();
            String cargarresto = "SELECT * FROM restaurant";

            PreparedStatement statement = cn.conexion().prepareStatement(cargarresto);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                rest.setId(rs.getInt("Id"));
                rest.setNombre(rs.getString("NOMBRE"));
                rest.setDomicilio(rs.getString("DOMICILIO"));

                resto.add(rest);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar las mesas: " + e.getMessage());
        }

        return resto;
    }

    public Restaurant buscarResto(int id) {
        Restaurant resto = null;
        try {
            Conect cn = new Conect();
            cn.conexion();
            String buscarresto = "SELECT * FROM restaurant WHERE Id = ?";

            PreparedStatement statement = cn.conexion().prepareStatement(buscarresto);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                resto = new Restaurant();
                resto.setId(rs.getInt("Id"));
                resto.setNombre(rs.getString("NOMBRE"));
                resto.setDomicilio(rs.getString("DOMICILIO"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el restaurante: " + e.getMessage());
        }

        return resto;
    }
}
