package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class SecretariaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecretariaView window = new SecretariaView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecretariaView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 78, 176, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblConsulta = new JLabel("Consultas");
		lblConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsulta.setBounds(211, 66, 85, 14);
		frame.getContentPane().add(lblConsulta);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(297, 78, 176, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnMarcar = new JButton("Marcar");
		btnMarcar.setBounds(61, 133, 89, 23);
		frame.getContentPane().add(btnMarcar);
		
		JButton btnDesmarcar = new JButton("Desmarcar");
		btnDesmarcar.setBounds(196, 133, 116, 23);
		frame.getContentPane().add(btnDesmarcar);
		
		JButton btnRemarcar = new JButton("Remarcar");
		btnRemarcar.setBounds(350, 133, 99, 23);
		frame.getContentPane().add(btnRemarcar);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(29, 240, 186, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblExames = new JLabel("Exames");
		lblExames.setHorizontalAlignment(SwingConstants.CENTER);
		lblExames.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExames.setBounds(215, 228, 77, 14);
		frame.getContentPane().add(lblExames);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(287, 240, 186, 2);
		frame.getContentPane().add(separator_3);
		
		JButton btnBaseDeExames = new JButton("Base de Exames");
		btnBaseDeExames.setBounds(181, 287, 144, 23);
		frame.getContentPane().add(btnBaseDeExames);
	}
}
