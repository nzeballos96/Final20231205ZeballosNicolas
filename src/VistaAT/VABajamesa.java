package VistaAT;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Modelo.Conect;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VABajamesa extends JPanel {
	private JTextField texbajamesa;

	/**
	 * Create the panel.
	 */
	public VABajamesa() {
		setLayout(null);
		
		JLabel lblIngreseNumeroDe = new JLabel("INGRESE NUMERO DE MESA A DAR DE BAJA O LIBERAR");
		lblIngreseNumeroDe.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblIngreseNumeroDe.setBounds(282, 131, 677, 44);
		add(lblIngreseNumeroDe);
		
		texbajamesa = new JTextField();
		texbajamesa.setBounds(368, 267, 415, 20);
		add(texbajamesa);
		texbajamesa.setColumns(10);
		
		JButton btnbajamesa = new JButton("DAR MESA DE BAJA");
		btnbajamesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Conect conexion = new Conect();
				int nroMesa = Integer.parseInt(texbajamesa.getText());
	            String query = "UPDATE atemesa SET estado = 'BAJA' where ESTADO = 'LIBRE' and idmesa = ? ";
	            PreparedStatement ps2 = conexion.conexion().prepareStatement(query);
	            ps2.setInt(1, nroMesa);
            	ps2.executeUpdate();
	            JOptionPane.showConfirmDialog(btnbajamesa, "DESEA DAR DE BAJA LA MESA: " + nroMesa);
					// resultSet = statement.executeQuery();11111
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "MESA IMPOSIBLE DAR DE BAJA, CONTIENE RESERVAS O ESTA OCUPADA");
					
				}
				
			}
		});
		btnbajamesa.setBounds(494, 498, 173, 23);
		add(btnbajamesa);
		
		JButton liberar = new JButton("LIBERAR MESA");
		liberar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
				Conect conexion = new Conect();
				int nroMesa = Integer.parseInt(texbajamesa.getText());
	            String query = "UPDATE atemesa SET estado = 'LIBRE' where idmesa = ? ";
	            PreparedStatement ps2 = conexion.conexion().prepareStatement(query);
	            ps2.setInt(1, nroMesa);
            	ps2.executeUpdate();
	            JOptionPane.showConfirmDialog(btnbajamesa, "DESEA LIBERAR LA MESA: " + nroMesa);
					// resultSet = statement.executeQuery();
	            limpiartex();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERROR AL LIBERAR");
					
				}
			
			
			}
		});
		liberar.setBounds(516, 402, 124, 21);
		add(liberar);

	}
	
	public void limpiartex() {
	    // Obtiene los JTextFields que deseas limpiar.
	    JTextField[] jTextFields = {
	        texbajamesa
	    };
	    
}
}
