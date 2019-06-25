package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CadastroPacienteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup grupo1;
	private JTextField rua;
	private JTextField numero;
	private JTextField bairro;
	private JTextField complemento;
	private JTextField cidade;
	private JTextField nome;
	private JTextField rg;
	private JTextField estadoCivil;
	private JFormattedTextField cpf;
	private JFormattedTextField celular;
	private JFormattedTextField cep;
	private JComboBox<Object> etnia;
	private JComboBox<Object> estados;
	private JRadioButton sexoM;
	private JRadioButton sexoF;
	private JDateChooser dataNascimento;
	private static String[] etnias = { "Branco(a)", "Pardo(a)", "Negro(a)", "Indígeno(a)"};
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
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPacienteView frame = new CadastroPacienteView();
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
	public CadastroPacienteView() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDePacientes = new JLabel("Cadastro de Pacientes");
		lblCadastroDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDePacientes.setForeground(Color.BLACK);
		lblCadastroDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCadastroDePacientes.setBounds(210, 46, 285, 34);
		contentPane.add(lblCadastroDePacientes);
		
		JLabel label_1 = new JLabel("Endere\u00E7o");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(54, 102, 84, 17);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(54, 130, 616, 2);
		contentPane.add(separator);

		JLabel label_3 = new JLabel("Rua:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(54, 144, 41, 14);
		contentPane.add(label_3);
		
		rua = new JTextField();
		rua.setColumns(10);
		rua.setBounds(101, 142, 182, 20);
		contentPane.add(rua);

		JLabel label_2 = new JLabel("N\u00FAmero:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(293, 144, 61, 14);
		contentPane.add(label_2);
		
		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(357, 143, 41, 20);
		contentPane.add(numero);
		
		JLabel label_6 = new JLabel("CEP:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(419, 144, 41, 14);
		contentPane.add(label_6);
		
		cep = new JFormattedTextField(new MaskFormatter("#####-###"));
		cep.setBounds(457, 142, 192, 20);
		contentPane.add(cep);

		JLabel label_4 = new JLabel("Bairro:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(54, 172, 53, 14);
		contentPane.add(label_4);

		bairro = new JTextField();
		bairro.setColumns(10);
		bairro.setBounds(101, 170, 182, 20);
		contentPane.add(bairro);

		JLabel label_7 = new JLabel("Complemento:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(355, 173, 105, 13);
		contentPane.add(label_7);
		
		complemento = new JTextField();
		complemento.setColumns(10);
		complemento.setBounds(457, 169, 192, 20);
		contentPane.add(complemento);

		JLabel label_5 = new JLabel("Cidade:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(54, 197, 48, 14);
		contentPane.add(label_5);

		cidade = new JTextField();
		cidade.setColumns(10);
		cidade.setBounds(111, 197, 172, 20);
		contentPane.add(cidade);

		JLabel label_8 = new JLabel("Estado:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(503, 203, 53, 14);
		contentPane.add(label_8);
		
		estados = new JComboBox<Object>(siglasEstados);
		estados.setBounds(563, 200, 73, 20);
		contentPane.add(estados);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(54, 259, 616, 2);
		contentPane.add(separator_2);

		JLabel label_9 = new JLabel("Dados Pessoais");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(54, 238, 113, 17);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Nome:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(54, 275, 41, 14);
		contentPane.add(label_10);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(101, 273, 192, 20);
		contentPane.add(nome);
		
		JLabel label_13 = new JLabel("Celular:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_13.setBounds(303, 275, 65, 14);
		contentPane.add(label_13);
		
		celular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		celular.setBounds(357, 273, 147, 20);
		contentPane.add(celular);
		
		JLabel label_17 = new JLabel("Etnia:");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_17.setBounds(523, 275, 41, 14);
		contentPane.add(label_17);
		
		etnia = new JComboBox<Object>(etnias);
		etnia.setBounds(563, 273, 86, 20);
		contentPane.add(etnia);
		
		JLabel label_11 = new JLabel("CPF:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(54, 301, 32, 14);
		contentPane.add(label_11);
		
		cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		cpf.setBounds(101, 299, 192, 20);
		contentPane.add(cpf);

		JLabel label_14 = new JLabel("RG:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_14.setBounds(301, 301, 32, 14);
		contentPane.add(label_14);
		
		rg = new JTextField();
		rg.setColumns(10);
		rg.setBounds(328, 299, 147, 20);
		contentPane.add(rg);
		
		JLabel label_16 = new JLabel("Sexo:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_16.setBounds(523, 301, 41, 14);
		contentPane.add(label_16);

		sexoM = new JRadioButton("M", false);
		sexoM.setBounds(566, 298, 41, 23);
		contentPane.add(sexoM);
		
		sexoF = new JRadioButton("F", false);
		sexoF.setBounds(608, 298, 41, 23);
		contentPane.add(sexoF);
		
		grupo1 = new ButtonGroup();
		grupo1.add(sexoM);
	  	grupo1.add(sexoF);
		
		JLabel label_12 = new JLabel("Data de Nascimento:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(54, 326, 134, 14);
		contentPane.add(label_12);
		
		dataNascimento = new JDateChooser();
		dataNascimento.setBounds(192, 324, 93, 20);
		contentPane.add(dataNascimento);

		JLabel label_15 = new JLabel("Estado Civil:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_15.setBounds(294, 326, 84, 14);
		contentPane.add(label_15);
		
		estadoCivil = new JTextField();
		estadoCivil.setColumns(10);
		estadoCivil.setBounds(377, 324, 127, 20);
		contentPane.add(estadoCivil);
		
		JLabel lblCelularAcompanhante = new JLabel("Celular Acompanhante:");
		lblCelularAcompanhante.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCelularAcompanhante.setBounds(54, 357, 160, 14);
		contentPane.add(lblCelularAcompanhante);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		formattedTextField.setBounds(210, 355, 123, 20);
		contentPane.add(formattedTextField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(480, 355, 160, 20);
		contentPane.add(textField);
		
		JLabel lblLocalDeNascimento = new JLabel("Local de Nascimento:");
		lblLocalDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLocalDeNascimento.setBounds(340, 357, 147, 14);
		contentPane.add(lblLocalDeNascimento);
		
		JButton button = new JButton("Cadastrar");
		button.setBounds(303, 416, 109, 23);
		contentPane.add(button);
	}
}
