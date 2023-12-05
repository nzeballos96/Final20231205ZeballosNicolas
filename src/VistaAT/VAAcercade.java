package VistaAT;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAAcercade extends JPanel {

	/**
	 * Create the panel.
	 */
	public VAAcercade() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("INICIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				VAPrincipal vn = new VAPrincipal();
				vn.main(null);
			
			}
		});
		btnNewButton.setBounds(367, 615, 503, 21);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ZEBALLOS NICOLAS RUBEN. 20231205. EXAMEN FINAL.");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(206, 232, 911, 333);
		add(lblNewLabel);

	}
	
	

}
