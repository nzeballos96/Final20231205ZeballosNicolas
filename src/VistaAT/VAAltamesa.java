package VistaAT;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Modelo.Conect;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VAAltamesa extends JPanel {
	private JTextField texcons;
	private JTextField texcap;
	private JTextField texmesa;
	private JTextField txtLibre;

	/**
	 * Create the panel.
	 */
	public VAAltamesa() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION DE ALTA MESA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(279, 79, 625, 45);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NUMERO DE MESA");
		lblNewLabel_1.setBounds(87, 234, 136, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CAPACIDAD");
		lblNewLabel_2.setBounds(87, 313, 136, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CONSUMO");
		lblNewLabel_3.setBounds(87, 390, 136, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ESTADO POR DEFECTO");
		lblNewLabel_4.setBounds(87, 459, 136, 14);
		add(lblNewLabel_4);
		
		texcons = new JTextField();
		texcons.setBounds(348, 387, 556, 20);
		add(texcons);
		texcons.setColumns(10);
		
		texcap = new JTextField();
		texcap.setBounds(351, 310, 553, 20);
		add(texcap);
		texcap.setColumns(10);
		
		texmesa = new JTextField();
		texmesa.setBounds(351, 231, 553, 20);
		add(texmesa);
		texmesa.setColumns(10);
		
		JButton btncargarmesa = new JButton("CONFIRMAR");
		btncargarmesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int nroMesa = Integer.parseInt(texmesa.getText());
				int capacidad = Integer.parseInt(texcap.getText());
				double consumo = Double.parseDouble(texcons.getText());
				String estado = txtLibre.getText();
				try {
	            Conect conexion = new Conect();
	            // Valida la mesa	            
	            PreparedStatement ps = conexion.conexion().prepareStatement("INSERT INTO atemesa "
	            		+ "(IdMesa, Capacidad, Consumo, Estado) "
	            		+ "VALUES (?, ?, ?, ?)");
	            
	            ps.setInt(1, nroMesa);
	            ps.setInt(2, capacidad);
	            ps.setDouble(3, consumo);
	            ps.setString(4, estado);

	            ps.executeUpdate();

	            JOptionPane.showMessageDialog(null, "mesa agregada correctamente");
	
		            /*if (LIBRE.isSelected()==true) {
		            	
		            	PreparedStatement ps1 = conexion.conexion().prepareStatement("UPDATE atmesa SET estado = 'LIBRE'  WHERE idmesa = ?");
		            	ps1.setInt(1, nroMesa);
		            	ps1.executeUpdate();
		            	JOptionPane.showMessageDialog(null, "MESA CREADA COMO LIBRE");
		            }else if(RESERVADO.isSelected()==true) {

		            	PreparedStatement ps2 = conexion.conexion().prepareStatement("UPDATE atmesa SET estado = 'RESERVADA'  WHERE idmesa = ?");
		            	ps2.setInt(1, nroMesa);
		            	ps2.executeUpdate();
		            	JOptionPane.showMessageDialog(null, "MESA CREADA COMO RESERVADA");
		            	
		            }else if(OCUPADO.isSelected()==true) {
		            	
		            	PreparedStatement ps3 = conexion.conexion().prepareStatement("UPDATE atmesa SET estado = 'OCUPADA'  WHERE idmesa = ?");
		            	ps3.setInt(1, nroMesa);
		            	ps3.executeUpdate();
		            	JOptionPane.showMessageDialog(null, "MESA CREADA COMO OCUPADA");
		            	
		            }*/
		            
		limpiartex();            
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "MESA IMPOSIBLE DE CARGAR, ID EXISTENTE");
					
					
				}

			
			}
		});
		btncargarmesa.setBounds(587, 615, 114, 23);
		add(btncargarmesa);
		
		txtLibre = new JTextField();
		txtLibre.setText("LIBRE");
		txtLibre.setBounds(348, 457, 556, 19);
		add(txtLibre);
		txtLibre.setColumns(10);

	}
	
	public void limpiartex() {
	    // Obtiene los JTextFields que deseas limpiar.
	    JTextField[] jTextFields = {
	        texcap,texcons,texmesa
	    };
	    
}

	
}