package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;

public class CadastroMedicoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_10;
	private ButtonGroup grupo1;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
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
					CadastroMedicoView window = new CadastroMedicoView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public CadastroMedicoView() throws ParseException {
		frame = new JFrame();
		frame.setBounds(100, 100, 733, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadstroDeMdicos = new JLabel("Cadastro de M\u00E9dicos");
		lblCadstroDeMdicos.setForeground(Color.BLACK);
		lblCadstroDeMdicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadstroDeMdicos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCadstroDeMdicos.setBounds(214, 52, 285, 34);
		frame.getContentPane().add(lblCadstroDeMdicos);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(44, 132, 616, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereo.setBounds(44, 104, 84, 17);
		frame.getContentPane().add(lblEndereo);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRua.setBounds(44, 146, 41, 14);
		frame.getContentPane().add(lblRua);
		
		textField = new JTextField();
		textField.setBounds(91, 144, 182, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNmero.setBounds(283, 146, 61, 14);
		frame.getContentPane().add(lblNmero);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(347, 145, 41, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCep.setBounds(409, 146, 41, 14);
		frame.getContentPane().add(lblCep);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new MaskFormatter("##.###-###"));
	  	formattedTextField.setBounds(447, 144, 192, 20);
	  	frame.getContentPane().add(formattedTextField);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBairro.setBounds(44, 174, 53, 14);
		frame.getContentPane().add(lblBairro);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(91, 172, 182, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComplemento.setBounds(345, 175, 105, 13);
		frame.getContentPane().add(lblComplemento);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(447, 171, 192, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCidade.setBounds(44, 199, 48, 14);
		frame.getContentPane().add(lblCidade);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(101, 199, 172, 20);
		frame.getContentPane().add(textField_5);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstado.setBounds(493, 205, 53, 14);
		frame.getContentPane().add(lblEstado);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>(siglasEstados);
	  	comboBox_1.setBounds(553, 202, 73, 20);
	  	frame.getContentPane().add(comboBox_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(44, 268, 616, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDadosPessoais.setBounds(44, 246, 113, 17);
		frame.getContentPane().add(lblDadosPessoais);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(44, 277, 41, 14);
		frame.getContentPane().add(lblNome);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(91, 275, 192, 20);
		frame.getContentPane().add(textField_7);
		
		JLabel lblTelefone = new JLabel("Celular:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone.setBounds(293, 277, 65, 14);
		frame.getContentPane().add(lblTelefone);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
	  	formattedTextField_1.setBounds(347, 275, 147, 20);
	  	frame.getContentPane().add(formattedTextField_1);
		
		JLabel lblCor = new JLabel("Etnia:");
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCor.setBounds(513, 277, 41, 14);
		frame.getContentPane().add(lblCor);
		
		JComboBox<Object> comboBox = new JComboBox<Object>(etnias);
		comboBox.setBounds(553, 275, 86, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCpf.setBounds(44, 303, 32, 14);
		frame.getContentPane().add(lblCpf);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
	  	formattedTextField_2.setBounds(91, 301, 192, 20);
	  	frame.getContentPane().add(formattedTextField_2);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRg.setBounds(291, 303, 32, 14);
		frame.getContentPane().add(lblRg);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(318, 301, 147, 20);
		frame.getContentPane().add(textField_10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBounds(513, 303, 41, 14);
		frame.getContentPane().add(lblSexo);
		
		JRadioButton rdbtnM = new JRadioButton("M", false);
		rdbtnM.setBounds(556, 300, 41, 23);
		frame.getContentPane().add(rdbtnM);
		
		JRadioButton rdbtnF = new JRadioButton("F", false);
		rdbtnF.setBounds(598, 300, 41, 23);
		frame.getContentPane().add(rdbtnF);
		
		grupo1 = new ButtonGroup();
		grupo1.add(rdbtnM);
	  	grupo1.add(rdbtnF);
	  	
	  	JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
	  	lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));
	  	lblDataDeNascimento.setBounds(44, 328, 134, 14);
	  	frame.getContentPane().add(lblDataDeNascimento);
	  	
	  	JLabel lblEstadoCivil = new JLabel("Estado Civil:");
	  	lblEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 13));
	  	lblEstadoCivil.setBounds(271, 328, 84, 14);
	  	frame.getContentPane().add(lblEstadoCivil);
	  	
	  	textField_11 = new JTextField();
	  	textField_11.setColumns(10);
	  	textField_11.setBounds(359, 326, 118, 20);
	  	frame.getContentPane().add(textField_11);
	  	
	  	JSeparator separator_2 = new JSeparator();
	  	separator_2.setForeground(Color.BLACK);
	  	separator_2.setBounds(44, 392, 616, 2);
	  	frame.getContentPane().add(separator_2);
	  	
	  	JLabel lblDadosDeTrabalho = new JLabel("Dados Corporativos");
	  	lblDadosDeTrabalho.setFont(new Font("Tahoma", Font.BOLD, 14));
	  	lblDadosDeTrabalho.setBounds(44, 372, 147, 17);
	  	frame.getContentPane().add(lblDadosDeTrabalho);
	  	
	  	JLabel lblCntps = new JLabel("CTPS:");
	  	lblCntps.setFont(new Font("Tahoma", Font.BOLD, 13));
	  	lblCntps.setBounds(44, 404, 41, 14);
	  	frame.getContentPane().add(lblCntps);
	  	
	  	textField_12 = new JTextField();
	  	textField_12.setColumns(10);
	  	textField_12.setBounds(91, 402, 147, 20);
	  	frame.getContentPane().add(textField_12);
	  	
	  	JLabel lblCrm = new JLabel("CRM:");
	  	lblCrm.setFont(new Font("Tahoma", Font.BOLD, 13));
	  	lblCrm.setBounds(248, 404, 41, 14);
	  	frame.getContentPane().add(lblCrm);
	  	
	  	textField_13 = new JTextField();
	  	textField_13.setColumns(10);
	  	textField_13.setBounds(283, 402, 134, 20);
	  	frame.getContentPane().add(textField_13);
	  	
	  	JLabel lblEspecialidade = new JLabel("Especialidade:");
	  	lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 13));
	  	lblEspecialidade.setBounds(427, 405, 93, 14);
	  	frame.getContentPane().add(lblEspecialidade);
	  	
	  	textField_14 = new JTextField();
	  	textField_14.setColumns(10);
	  	textField_14.setBounds(526, 402, 134, 20);
	  	frame.getContentPane().add(textField_14);
	  	
	  	JLabel lblLogin = new JLabel("Login:");
	  	lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
	  	lblLogin.setBounds(44, 457, 41, 14);
	  	frame.getContentPane().add(lblLogin);
	  	
	  	textField_15 = new JTextField();
	  	textField_15.setColumns(10);
	  	textField_15.setBounds(91, 455, 147, 20);
	  	frame.getContentPane().add(textField_15);
	  	
	  	JLabel lblSenha = new JLabel("Senha:");
	  	lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
	  	lblSenha.setBounds(248, 458, 53, 14);
	  	frame.getContentPane().add(lblSenha);
	  	
	  	textField_16 = new JTextField();
	  	textField_16.setColumns(10);
	  	textField_16.setBounds(293, 455, 147, 20);
	  	frame.getContentPane().add(textField_16);
	  	
	  	JButton button = new JButton("Cadastrar");
	  	button.setBounds(308, 529, 109, 23);
	  	frame.getContentPane().add(button);
	  	
	  	JDateChooser dateChooser = new JDateChooser();
	  	dateChooser.setBounds(182, 326, 84, 20);
	  	frame.getContentPane().add(dateChooser);
	}
}
