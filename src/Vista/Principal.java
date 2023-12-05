package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import VistaAT.VAPrincipal;
import VistaLP.VLPrincipal;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1344, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECCIONE UN RESTAURANT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 57));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(257, 115, 828, 82);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ATENEO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VAPrincipal vn = new VAPrincipal();
				vn.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnNewButton.setBounds(301, 310, 744, 82);
		contentPane.add(btnNewButton);
		
		JButton btnLosPrimos = new JButton("LOS PRIMOS");
		btnLosPrimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VLPrincipal vn = new VLPrincipal();
				vn.main(null);
				
			}
		});
		btnLosPrimos.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnLosPrimos.setBounds(301, 512, 744, 82);
		contentPane.add(btnLosPrimos);
	}
}
