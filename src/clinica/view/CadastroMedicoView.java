package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class CadastroMedicoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
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
					CadastroMedicoView frame = new CadastroMedicoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public CadastroMedicoView() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Cadastro de M\u00E9dicos");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(234, 60, 285, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Endere\u00E7o");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(64, 112, 84, 17);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(64, 140, 616, 2);
		contentPane.add(separator);
		
		JLabel label_2 = new JLabel("Rua:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(64, 151, 41, 14);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(111, 149, 182, 20);
		contentPane.add(textField);
		
		JLabel label_3 = new JLabel("Bairro:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(64, 180, 53, 14);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 178, 182, 20);
		contentPane.add(textField_1);
		
		JLabel label_4 = new JLabel("Cidade:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(64, 205, 48, 14);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(121, 205, 172, 20);
		contentPane.add(textField_2);
		
		JLabel label_5 = new JLabel("N\u00FAmero:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(303, 152, 61, 14);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(367, 151, 41, 20);
		contentPane.add(textField_3);
		
		JLabel label_6 = new JLabel("CEP:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(429, 152, 41, 14);
		contentPane.add(label_6);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new MaskFormatter("#####-###"));
		formattedTextField.setBounds(467, 150, 192, 20);
		contentPane.add(formattedTextField);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(467, 177, 192, 20);
		contentPane.add(textField_4);
		
		JLabel label_7 = new JLabel("Complemento:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(365, 181, 105, 13);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Estado:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(513, 211, 53, 14);
		contentPane.add(label_8);
		
		JComboBox<Object> comboBox = new JComboBox<Object>(siglasEstados);
		comboBox.setBounds(573, 208, 73, 20);
		contentPane.add(comboBox);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(111, 278, 192, 20);
		contentPane.add(textField_5);
		
		JLabel label_9 = new JLabel("Nome:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(64, 280, 41, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Dados Pessoais");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_10.setBounds(64, 249, 113, 17);
		contentPane.add(label_10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(64, 271, 616, 2);
		contentPane.add(separator_1);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		formattedTextField_1.setBounds(367, 278, 147, 20);
		contentPane.add(formattedTextField_1);
		
		JLabel label_11 = new JLabel("Celular:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(313, 280, 65, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Etnia:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(533, 280, 41, 14);
		contentPane.add(label_12);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>(etnias);
		comboBox_1.setBounds(573, 278, 86, 20);
		contentPane.add(comboBox_1);
		
		JRadioButton radioButton = new JRadioButton("M", false);
		radioButton.setBounds(576, 303, 41, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("F", false);
		radioButton_1.setBounds(618, 303, 41, 23);
		contentPane.add(radioButton_1);
		
		JLabel label_13 = new JLabel("Sexo:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_13.setBounds(533, 306, 41, 14);
		contentPane.add(label_13);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(338, 304, 147, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(379, 329, 118, 20);
		contentPane.add(textField_7);
		
		JLabel label_14 = new JLabel("RG:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_14.setBounds(311, 306, 32, 14);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("Estado Civil:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_15.setBounds(291, 331, 84, 14);
		contentPane.add(label_15);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		formattedTextField_2.setBounds(111, 304, 192, 20);
		contentPane.add(formattedTextField_2);
		
		JLabel label_16 = new JLabel("CPF:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_16.setBounds(64, 306, 32, 14);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("Data de Nascimento:");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_17.setBounds(64, 331, 134, 14);
		contentPane.add(label_17);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(202, 329, 84, 20);
		contentPane.add(dateChooser);
		
		JLabel label_18 = new JLabel("Dados Corporativos");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_18.setBounds(64, 369, 147, 17);
		contentPane.add(label_18);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(64, 389, 616, 2);
		contentPane.add(separator_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(111, 399, 147, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(303, 399, 134, 20);
		contentPane.add(textField_9);
		
		JLabel label_19 = new JLabel("CTPS:");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_19.setBounds(64, 401, 41, 14);
		contentPane.add(label_19);
		
		JLabel label_20 = new JLabel("CRM:");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_20.setBounds(268, 401, 41, 14);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel("Login:");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_21.setBounds(64, 454, 41, 14);
		contentPane.add(label_21);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(111, 452, 147, 20);
		contentPane.add(textField_10);
		
		JLabel label_22 = new JLabel("Senha:");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_22.setBounds(268, 455, 53, 14);
		contentPane.add(label_22);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(313, 452, 147, 20);
		contentPane.add(textField_11);
		
		JLabel label_23 = new JLabel("Especialidade:");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_23.setBounds(447, 402, 93, 14);
		contentPane.add(label_23);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(546, 399, 134, 20);
		contentPane.add(textField_12);
		
		JButton button = new JButton("Cadastrar");
		button.setBounds(328, 526, 109, 23);
		contentPane.add(button);
	}
}
