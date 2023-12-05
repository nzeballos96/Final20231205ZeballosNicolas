package VistaLP;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import VistaAT.VAPrincipal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VLAcercade extends JPanel {

	/**
	 * Create the panel.
	 */
	public VLAcercade() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ZEBALLOS NICOLAS RUBEN. 20231205. EXAMEN FINAL.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(142, 178, 911, 333);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INICIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				VLPrincipal vn = new VLPrincipal();
				vn.main(null);
			}
		});
		btnNewButton.setBounds(329, 616, 503, 21);
		add(btnNewButton);

	}

}
