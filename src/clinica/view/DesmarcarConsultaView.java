package clinica.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class DesmarcarConsultaView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesmarcarConsultaView frame = new DesmarcarConsultaView();
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
	public DesmarcarConsultaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDesmarcarConsulta = new JLabel("Desmarcar Consulta");
		lblDesmarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesmarcarConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDesmarcarConsulta.setBounds(143, 11, 220, 26);
		contentPane.add(lblDesmarcarConsulta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 48, 404, 220);
		contentPane.add(scrollPane);
		
		JButton button = new JButton();
		button.setText("Desmarcar");
		button.setBounds(198, 295, 110, 23);
		contentPane.add(button);
	}

}
