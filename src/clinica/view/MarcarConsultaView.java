package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class MarcarConsultaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private String[] pessoas = { "Fulano", "Sicrano", "Beltrano"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcarConsultaView window = new MarcarConsultaView();
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
	public MarcarConsultaView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 528, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMarcarConsulta = new JLabel("Marcar Consulta");
		lblMarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcarConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMarcarConsulta.setBounds(145, 50, 220, 26);
		frame.getContentPane().add(lblMarcarConsulta);
		
		JLabel lblMdico = new JLabel("M\u00E9dico:");
		lblMdico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMdico.setBounds(49, 112, 66, 18);
		frame.getContentPane().add(lblMdico);
		
		JComboBox<Object> comboBox = new JComboBox<Object>(pessoas);
		comboBox.setBounds(109, 112, 95, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPaciente.setBounds(37, 151, 66, 18);
		frame.getContentPane().add(lblPaciente);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>(pessoas);
		comboBox_1.setBounds(109, 151, 95, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(319, 112, 42, 18);
		frame.getContentPane().add(lblHora);
		
		textField = new JTextField();
		textField.setBounds(362, 112, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDia.setBounds(319, 149, 42, 18);
		frame.getContentPane().add(lblDia);
		
		JButton btnMarcar = new JButton("Marcar");
		btnMarcar.setBounds(200, 230, 109, 23);
		frame.getContentPane().add(btnMarcar);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(351, 151, 97, 20);
		frame.getContentPane().add(dateChooser);
	}
}
