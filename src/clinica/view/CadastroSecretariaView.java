package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class CadastroSecretariaView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private String[] etnias = { "Branco(a)", "Pardo(a)", "Negro(a)", "Indígeno(a)"};
	private static String siglasEstados[] = {
			"AC",
			"AL",
			"AP",
			"AM",
			"BA",
			"CE",
			"DF",
			"ES",
			"GO",
			"MA",
			"MT",
			"MS",
			"MG",
			"PA",
			"PB",
			"PR",
			"PE",
			"PI",
			"RJ",
			"RN",
			"RS",
			"RO",
			"RR",
			"SC",
			"SP",
			"SE",
			"TO"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroSecretariaView window = new CadastroSecretariaView();
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
	public CadastroSecretariaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 733, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastroDeSecretrias = new JLabel("Cadastro de Secret\u00E1rias");
		lblCadastroDeSecretrias.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeSecretrias.setForeground(Color.BLACK);
		lblCadastroDeSecretrias.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCadastroDeSecretrias.setBounds(204, 52, 285, 34);
		frame.getContentPane().add(lblCadastroDeSecretrias);
		
		JLabel label = new JLabel("Endere\u00E7o");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(52, 111, 84, 17);
		frame.getContentPane().add(label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(52, 139, 616, 2);
		frame.getContentPane().add(separator);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(99, 151, 182, 20);
		frame.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("Rua:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(52, 153, 41, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Bairro:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(52, 181, 53, 14);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 179, 182, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel label_3 = new JLabel("Cidade:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(52, 206, 48, 14);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 206, 172, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel label_7 = new JLabel("Estado:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(514, 209, 53, 14);
		frame.getContentPane().add(label_7);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>(siglasEstados);
		comboBox_1.setBounds(574, 206, 73, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel label_4 = new JLabel("N\u00FAmero:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(291, 153, 61, 14);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(355, 152, 41, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel label_5 = new JLabel("CEP:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(417, 153, 41, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Complemento:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(353, 182, 105, 13);
		frame.getContentPane().add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(455, 178, 192, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(455, 152, 192, 20);
		frame.getContentPane().add(textField_6);
		
		JLabel label_8 = new JLabel("Dados Pessoais");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(52, 253, 113, 17);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Nome:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(52, 284, 41, 14);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("CPF:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(52, 310, 32, 14);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("Data de Nascimento:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(52, 335, 134, 14);
		frame.getContentPane().add(label_11);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(99, 308, 192, 20);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(99, 282, 192, 20);
		frame.getContentPane().add(textField_9);
		
		JLabel label_12 = new JLabel("Telefone:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(301, 284, 65, 14);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("RG:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_13.setBounds(299, 310, 32, 14);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("Estado Civil:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_14.setBounds(282, 335, 84, 14);
		frame.getContentPane().add(label_14);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(371, 333, 118, 20);
		frame.getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(326, 308, 147, 20);
		frame.getContentPane().add(textField_11);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(52, 275, 616, 2);
		frame.getContentPane().add(separator_1);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(364, 282, 147, 20);
		frame.getContentPane().add(textField_12);
		
		JComboBox<Object> comboBox = new JComboBox<Object>(etnias);
		comboBox.setBounds(564, 282, 83, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblEtnia = new JLabel("Etnia:");
		lblEtnia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEtnia.setBounds(521, 284, 41, 14);
		frame.getContentPane().add(lblEtnia);
		
		JLabel label_16 = new JLabel("Sexo:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_16.setBounds(521, 310, 41, 14);
		frame.getContentPane().add(label_16);
		
		JRadioButton radioButton = new JRadioButton("M", false);
		radioButton.setBounds(564, 307, 41, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("F", false);
		radioButton_1.setBounds(606, 307, 41, 23);
		frame.getContentPane().add(radioButton_1);
		
		JLabel label_17 = new JLabel("Dados Corporativos");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_17.setBounds(52, 381, 147, 17);
		frame.getContentPane().add(label_17);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(52, 401, 616, 2);
		frame.getContentPane().add(separator_2);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(99, 411, 147, 20);
		frame.getContentPane().add(textField_13);
		
		JLabel label_18 = new JLabel("CTPS:");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_18.setBounds(52, 413, 41, 14);
		frame.getContentPane().add(label_18);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(291, 411, 134, 20);
		frame.getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(99, 464, 147, 20);
		frame.getContentPane().add(textField_15);
		
		JLabel label_19 = new JLabel("Login:");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_19.setBounds(52, 466, 41, 14);
		frame.getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("Senha:");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_20.setBounds(256, 467, 53, 14);
		frame.getContentPane().add(label_20);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(301, 464, 124, 20);
		frame.getContentPane().add(textField_16);
		
		JLabel label_21 = new JLabel("CRM:");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_21.setBounds(256, 413, 41, 14);
		frame.getContentPane().add(label_21);
		
		JButton button = new JButton("Cadastrar");
		button.setBounds(326, 532, 109, 23);
		frame.getContentPane().add(button);
		
		JLabel lblHorrioDeEntrada = new JLabel("Hor\u00E1rio de Entrada:");
		lblHorrioDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorrioDeEntrada.setBounds(435, 414, 134, 14);
		frame.getContentPane().add(lblHorrioDeEntrada);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(564, 411, 93, 20);
		frame.getContentPane().add(textField_17);
		
		JLabel lblHorrioDeSada = new JLabel("Hor\u00E1rio de Sa\u00EDda:");
		lblHorrioDeSada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorrioDeSada.setBounds(435, 439, 118, 14);
		frame.getContentPane().add(lblHorrioDeSada);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(564, 437, 93, 20);
		frame.getContentPane().add(textField_18);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(188, 335, 84, 20);
		frame.getContentPane().add(dateChooser);
	}
}
