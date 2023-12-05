package VistaLP;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Modelo.Conect;
import VistaAT.VAVistaactual.ColorRenderer;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

public class VLVistaporfechas extends JPanel {
	private JTable tablefechas;

	/**
	 * Create the panel.
	 */
	public VLVistaporfechas() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VISTA POR FECHAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 42, 1031, 59);
		add(lblNewLabel);
		
		tablefechas = new JTable();
		tablefechas.setBounds(1143, 624, -1069, -428);
		add(tablefechas);
		try {
			cargar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void cargar() throws SQLException {
		
		
		
		String sqlmc = "SELECT r.Fecha, r.id_mesa, r.Comensales, m.Estado\r\n"
				+ "FROM Atemesa AS m\r\n"
				+ "JOIN atereserva AS r\r\n"
				+ "ON m.IdMesa = r.id_mesa\r\n"
				+ "ORDER BY r.Fecha ASC";
        //Statement st;
		
		
		Conect conexion = new Conect();
        
        DefaultTableModel visac = new DefaultTableModel();
       
        
        visac.addColumn("FECHA");
        visac.addColumn("MESA");
        visac.addColumn("COMENSALES");
        visac.addColumn("ESTADO");
        tablefechas.setModel(visac);
        
        String [] datos = new String[5];
        try {
            PreparedStatement ps = conexion.conexion().prepareStatement(sqlmc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                

                visac.addRow(datos);
                
                tablefechas.getColumnModel().getColumn(3).setCellRenderer(new ColorRenderer());
            }	
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGA" + e.toString());
        }
               
	
	
}
	
	
	class ColorRenderer extends DefaultTableCellRenderer {
	    @Override
	    public void setValue(Object value) {
	        if ("OCUPADA".equalsIgnoreCase(value.toString())) {
	            setBackground(Color.RED);
	        } else {
		        if ("RESERVADA".equalsIgnoreCase(value.toString())) {
		            setBackground(Color.YELLOW);
		        }        else {      
	            setBackground(Color.WHITE);
	        }
		        }
	        
	        super.setValue(value);
	    }
	
}
}
