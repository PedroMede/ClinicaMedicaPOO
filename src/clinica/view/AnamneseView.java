package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class AnamneseView {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnamneseView window = new AnamneseView();
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
	public AnamneseView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadstroDeAnamnese = new JLabel("Cadastro de Anamnese");
		lblCadstroDeAnamnese.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadstroDeAnamnese.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadstroDeAnamnese.setBounds(140, 51, 220, 14);
		frame.getContentPane().add(lblCadstroDeAnamnese);
		
		JLabel lblCdigoDoExame = new JLabel("C\u00F3digo do Exame:");
		lblCdigoDoExame.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCdigoDoExame.setBounds(20, 104, 114, 14);
		frame.getContentPane().add(lblCdigoDoExame);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(144, 102, 61, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblSintomas = new JLabel("Sintomas:");
		lblSintomas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSintomas.setBounds(20, 150, 64, 14);
		frame.getContentPane().add(lblSintomas);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(114, 146, 322, 117);
		frame.getContentPane().add(textArea);
		
		JLabel lblPrescrio = new JLabel("Prescri\u00E7\u00E3o:");
		lblPrescrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrescrio.setBounds(20, 278, 73, 14);
		frame.getContentPane().add(lblPrescrio);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(114, 274, 322, 117);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(114, 402, 322, 117);
		frame.getContentPane().add(textArea_2);
		
		JLabel lblDiagnstico = new JLabel("Diagn\u00F3stico:");
		lblDiagnstico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDiagnstico.setBounds(20, 407, 86, 14);
		frame.getContentPane().add(lblDiagnstico);
		
		JButton button = new JButton("Cadastrar");
		button.setBounds(199, 548, 109, 23);
		frame.getContentPane().add(button);
	}

}
