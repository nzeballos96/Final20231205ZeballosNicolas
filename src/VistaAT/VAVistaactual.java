package VistaAT;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.ClientPreparedStatement;

import Modelo.Conect;
import java.awt.Color;

public class VAVistaactual extends JPanel {
	private JTable tableact;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public VAVistaactual() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VISTA DE MESAS ACTUAL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(71, 34, 1020, 67);
		add(lblNewLabel);
		
		tableact = new JTable();
		tableact.setBounds(345, 208, 490, 279);
		add(tableact);
		try {
			cargar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargar() throws SQLException {
		
		
				
		String sqlmc = "SELECT * FROM atemesa where estado <> 'baja' ";
        //Statement st;
		
		
		Conect conexion = new Conect();
        
        DefaultTableModel visac = new DefaultTableModel();
       
        
        visac.addColumn("MESA");
        visac.addColumn("CAPACIDAD");

        visac.addColumn("CONSUMO");
        visac.addColumn("ESTADO");
        tableact.setModel(visac);
        
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
                
                tableact.getColumnModel().getColumn(3).setCellRenderer(new ColorRenderer());
            }	
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGA" + e.toString());
        }
               
	
	
}
	
	
	public class ColorRenderer extends DefaultTableCellRenderer {
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

