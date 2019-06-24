package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import clinica.controller.GerenteController;
import clinica.model.Medico;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroMedicoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup grupo1;
	private JTextField rua;
	private JTextField bairro;
	private JTextField cidade;
	private JTextField numero;
	private JTextField complemento;
	private JTextField nome;
	private JTextField rg;
	private JTextField ctps;
	private JFormattedTextField cpf;
	private JFormattedTextField celular;
	private JFormattedTextField cep;
	private JDateChooser dataNascimento;
	private JTextField estadoCivil;
	private JComboBox<Object> etnia;
	private JComboBox<Object> estados;
	private JRadioButton sexoM;
	private JRadioButton sexoF;
	private JTextField crm;
	private JTextField login;
	private JTextField senha;
	private JTextField especialidade;
	private GerenteController gerente = new GerenteController();
	private Medico med = new Medico();
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
		
		rua = new JTextField();
		rua.setColumns(10);
		rua.setBounds(111, 149, 182, 20);
		contentPane.add(rua);
		
		JLabel label_3 = new JLabel("Bairro:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(64, 180, 53, 14);
		contentPane.add(label_3);
		
		bairro = new JTextField();
		bairro.setColumns(10);
		bairro.setBounds(111, 178, 182, 20);
		contentPane.add(bairro);
		
		JLabel label_4 = new JLabel("Cidade:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(64, 205, 48, 14);
		contentPane.add(label_4);
		
		cidade = new JTextField();
		cidade.setColumns(10);
		cidade.setBounds(121, 205, 172, 20);
		contentPane.add(cidade);
		
		JLabel label_5 = new JLabel("N\u00FAmero:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(303, 152, 61, 14);
		contentPane.add(label_5);
		
		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(367, 151, 41, 20);
		contentPane.add(numero);
		
		JLabel label_6 = new JLabel("CEP:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(429, 152, 41, 14);
		contentPane.add(label_6);
		
		cep = new JFormattedTextField(new MaskFormatter("#####-###"));
		cep.setBounds(467, 150, 192, 20);
		contentPane.add(cep);
		
		complemento = new JTextField();
		complemento.setColumns(10);
		complemento.setBounds(467, 177, 192, 20);
		contentPane.add(complemento);
		
		JLabel label_7 = new JLabel("Complemento:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(365, 181, 105, 13);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Estado:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(513, 211, 53, 14);
		contentPane.add(label_8);
		
		JComboBox<Object> estados = new JComboBox<Object>(siglasEstados);
		estados.setBounds(573, 208, 73, 20);
		contentPane.add(estados);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(111, 278, 192, 20);
		contentPane.add(nome);
		
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
		
		celular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		celular.setBounds(367, 278, 147, 20);
		contentPane.add(celular);
		
		JLabel label_11 = new JLabel("Celular:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(313, 280, 65, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Etnia:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(533, 280, 41, 14);
		contentPane.add(label_12);
		
		JComboBox<Object> etnia = new JComboBox<Object>(etnias);
		etnia.setBounds(573, 278, 86, 20);
		contentPane.add(etnia);
		
		sexoM = new JRadioButton("M", false);
		sexoM.setBounds(576, 303, 41, 23);
		contentPane.add(sexoM);
		
		sexoF = new JRadioButton("F", false);
		sexoF.setBounds(618, 303, 41, 23);
		contentPane.add(sexoF);
		
		grupo1 = new ButtonGroup();
		grupo1.add(sexoM);
	  	grupo1.add(sexoF);
		
		JLabel label_13 = new JLabel("Sexo:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_13.setBounds(533, 306, 41, 14);
		contentPane.add(label_13);
		
		rg = new JTextField();
		rg.setColumns(10);
		rg.setBounds(338, 304, 147, 20);
		contentPane.add(rg);
		
		estadoCivil = new JTextField();
		estadoCivil.setColumns(10);
		estadoCivil.setBounds(379, 329, 118, 20);
		contentPane.add(estadoCivil);
		
		JLabel label_14 = new JLabel("RG:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_14.setBounds(311, 306, 32, 14);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("Estado Civil:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_15.setBounds(291, 331, 84, 14);
		contentPane.add(label_15);
		
		cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		cpf.setBounds(111, 304, 192, 20);
		contentPane.add(cpf);
		
		JLabel label_16 = new JLabel("CPF:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_16.setBounds(64, 306, 32, 14);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("Data de Nascimento:");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_17.setBounds(64, 331, 134, 14);
		contentPane.add(label_17);
		
		dataNascimento = new JDateChooser();
		dataNascimento.setBounds(202, 329, 84, 20);
		contentPane.add(dataNascimento);
		
		JLabel label_18 = new JLabel("Dados Corporativos");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_18.setBounds(64, 369, 147, 17);
		contentPane.add(label_18);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(64, 389, 616, 2);
		contentPane.add(separator_2);
		
		ctps = new JTextField();
		ctps.setColumns(10);
		ctps.setBounds(111, 399, 147, 20);
		contentPane.add(ctps);
		
		crm = new JTextField();
		crm.setColumns(10);
		crm.setBounds(303, 399, 134, 20);
		contentPane.add(crm);
		
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
		
		login = new JTextField();
		login.setColumns(10);
		login.setBounds(111, 452, 147, 20);
		contentPane.add(login);
		
		JLabel label_22 = new JLabel("Senha:");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_22.setBounds(268, 455, 53, 14);
		contentPane.add(label_22);
		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(313, 452, 147, 20);
		contentPane.add(senha);
		
		JLabel label_23 = new JLabel("Especialidade:");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_23.setBounds(447, 402, 93, 14);
		contentPane.add(label_23);
		
		especialidade = new JTextField();
		especialidade.setColumns(10);
		especialidade.setBounds(546, 399, 134, 20);
		contentPane.add(especialidade);
		
		JButton button = new JButton("Cadastrar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					cadastrar();
					JOptionPane.showMessageDialog(null, "Cadastrado(a) " + med.getNome() + " com sucesso", "Sucesso", JOptionPane.DEFAULT_OPTION);
					limparCampos();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar médico(a), alguns dados são inválidos!", "Erro ao cadastrar!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(328, 526, 109, 23);
		contentPane.add(button);
	}
	
	private void limparCampos() {
		rua.setText("");
		numero.setText("");
		cep.setText("");
		bairro.setText("");
		complemento.setText("");
		cidade.setText("");
		nome.setText("");
		celular.setText("");
		cpf.setText("");
		rg.setText("");
		dataNascimento.setDate(null);
		estadoCivil.setText("");
		ctps.setText("");
		login.setText("");
		senha.setText("");
	}
	
	private boolean cadastrar() {
		//Registros de endereço
		med.setLogradouro(rua.getText());
		med.setNumero(Integer.parseInt(numero.getText()));
		med.setCep(cep.getText());
		med.setBairro(bairro.getText());
		med.setComplemento(complemento.getText());
		med.setCidade(cidade.getText());
		med.setEstado(estados.getSelectedItem().toString());
		
		//Registros de dados pessoais
		med.setNome(nome.getText());
		med.setTelefone(celular.getText());
		if (etnia.getSelectedItem() == "Branco(a)") {
			med.setEtnia(EtniaEnum.BRANCO); 
		} else if (etnia.getSelectedItem() == "Pardo(a)") {
			med.setEtnia(EtniaEnum.PARDO); 
		} else if (etnia.getSelectedItem() == "Negro(a)") {
			med.setEtnia(EtniaEnum.NEGRO); 
		} else {
			med.setEtnia(EtniaEnum.INDIGENA);
		}
		med.setCpf(cpf.getText());
		med.setRg(rg.getText());
		if (sexoM.isSelected()) {
			med.setSexo(SexoEnum.MASCULINO);
		} else {
			med.setSexo(SexoEnum.FEMININO);
		}
		med.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento.getDate()));
		med.setEstadoCivil(estadoCivil.getText());
		
		//Registros de dados corporativos
		med.setCarteiraTrab(ctps.getText());
		med.setCrm(crm.getText());
		med.setLogin(login.getText());
		med.setSenha(senha.getText());
		
		return gerente.cadastrarMedico(med);
	}
}
