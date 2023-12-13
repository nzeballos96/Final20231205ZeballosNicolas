package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conect {

    String base = "BaseFinal20231205ZeballosNicolas";
    String url = "jdbc:mysql://localhost:3306/";
    String usuario = "root";
    String contra = "";
    String driver = "com.mysql.cj.jdbc.Driver";

    public Conect() {
    }

    

    Connection conect = null;

    public Connection conexion() {
        try {
            Class.forName(driver);
            conect = DriverManager.getConnection(url + base, usuario, contra);
     //       System.out.println("CONECTADO");
         //   JOptionPane.showMessageDialog(null, "INICIANDO BASE");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e);
       //     System.out.println("ERROR");
        }

        return conect;
    }

    public void cerrar() {
        try {
            conect.close();
         //   System.out.println("CONEXI�N CERRADA");
        } catch (Exception e) {
            System.out.println("ERROR AL CERRAR LA CONEXION");
        }
    }
	
}
