package VistaLP;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import Modelo.Conect;
import VistaAT.VAVistaactual.ColorRenderer;

import javax.swing.JTable;

public class VLRegistrar extends JPanel {
	private JTextField mesar;
	private JTextField fecha;
	private JTextField nom;
	private JTextField ape;
	private JTextField comen;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VLRegistrar() {
		setLayout(null);
		
		mesar = new JTextField();
		mesar.setBounds(567, 529, 204, 20);
		add(mesar);
		mesar.setColumns(10);
		
		fecha = new JTextField();
		fecha.setBounds(567, 231, 204, 20);
		add(fecha);
		fecha.setColumns(10);
		
		nom = new JTextField();
		nom.setBounds(567, 300, 204, 20);
		add(nom);
		nom.setColumns(10);
		
		ape = new JTextField();
		ape.setBounds(567, 380, 204, 20);
		add(ape);
		ape.setColumns(10);
		
		comen = new JTextField();
		comen.setBounds(567, 446, 204, 20);
		add(comen);
		comen.setColumns(10);
		
		JRadioButton RESERADO = new JRadioButton("RESERVAR");
		RESERADO.setBounds(447, 619, 109, 23);
		add(RESERADO);
		
		JRadioButton OCUPAR = new JRadioButton("OCUPAR");
		OCUPAR.setBounds(729, 619, 109, 23);
		add(OCUPAR);
		
		JLabel lblNewLabel = new JLabel("FECHA A\u00D1O/MES/DIA");
		lblNewLabel.setBounds(120, 234, 176, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(120, 303, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO");
		lblNewLabel_2.setBounds(120, 383, 109, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("COMENSALES");
		lblNewLabel_3.setBounds(120, 449, 109, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NUMERO DE MESA");
		lblNewLabel_4.setBounds(120, 532, 97, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TIPO DE MOVIMIENTO");
		lblNewLabel_5.setBounds(120, 623, 109, 14);
		add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("CONFIRMAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fechare = Integer.parseInt(fecha.getText());
				String nombre= nom.getText();
				String apellido = ape.getText();
				int comensales = Integer.parseInt(comen.getText());
				int mesa = Integer.parseInt(mesar.getText());
				
				try {

				    Conect conexion = new Conect();

				    String query = "SELECT idmesa FROM PRImesa WHERE idMESA = ? AND estado = ? AND capacidad >= ?";
				    PreparedStatement statement = conexion.conexion().prepareStatement(query);
				    statement.setInt(1, mesa);
				    statement.setString(2, "Libre");
				    statement.setInt(3, comensales);
				    ResultSet resultSet = statement.executeQuery();

				    if (!resultSet.next()) {
				     
				      JOptionPane.showMessageDialog(null, "Mesa no encontrada o no está libre");
				    } else {
			            PreparedStatement ps = conexion.conexion().prepareStatement("INSERT INTO PRIreserva"
			            		+ "(Fecha, Nombre, Apellido, Comensales, id_mesa) "
			            		+ "VALUES (?, ?, ?, ?, ?)");
			            
			            ps.setInt(1, fechare);
			            ps.setString(2, nombre);
			            ps.setString(3, apellido);
			            ps.setInt(4, comensales);
			            ps.setInt(5, mesa);

		             if(RESERADO.isSelected()==true) {

		            	PreparedStatement ps2 = conexion.conexion().prepareStatement("UPDATE PRImesa SET estado = 'RESERVADA'  WHERE idmesa = ?");
		            	ps2.setInt(1, mesa);
		            	ps2.executeUpdate();
		            	JOptionPane.showMessageDialog(null, "MESA CREADA COMO RESERVADA");
		            	
		            }else if(OCUPAR.isSelected()==true) {
		            	
		            	PreparedStatement ps3 = conexion.conexion().prepareStatement("UPDATE PRImesa SET estado = 'OCUPADA'  WHERE idmesa = ?");
		            	ps3.setInt(1, mesa);
		            	ps3.executeUpdate();
		            	JOptionPane.showMessageDialog(null, "MESA CREADA COMO OCUPADA");
		            	
		            }
			            JOptionPane.showMessageDialog(null, "mesa agregada correctamente");
				    }

		            	 } catch (Exception ex) {
				    JOptionPane.showMessageDialog(null, "Error al reservar mesa: " + ex.getMessage());
				  }
		}
		});
	
		btnNewButton.setBounds(606, 706, 136, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("GESTION DE RESERVA LOS PRIMOS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_6.setBounds(244, 103, 794, 45);
		add(lblNewLabel_6);
		
		table = new JTable();
		table.setBounds(851, 231, 353, 318);
		add(table);
		try {
			cargar();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void cargar() throws SQLException {
		
		
		
		String sqlmc = "SELECT idMesa, capacidad, estado FROM PRImesa where estado = 'LIBRE' ";
        //Statement st;
		
		
		Conect conexion = new Conect();
        
        DefaultTableModel visac = new DefaultTableModel();
       
        
        visac.addColumn("MESA");
        visac.addColumn("CAPACIDAD");
        visac.addColumn("ESTADO");
        table.setModel(visac);
        
        String [] datos = new String[5];
        try {
            PreparedStatement ps = conexion.conexion().prepareStatement(sqlmc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
      
                

                visac.addRow(datos);
                limpiartex();
                
            }	
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CARGA" + e.toString());
        }
               
	
	
}
	
	public void limpiartex() {
	    // Obtiene los JTextFields que deseas limpiar.
	    JTextField[] jTextFields = {
	        ape,comen,fecha,mesar,nom
	    };
	    
}
	
}
