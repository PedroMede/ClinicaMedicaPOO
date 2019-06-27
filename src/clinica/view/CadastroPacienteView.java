package clinica.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import clinica.controller.SecretariaController;
import clinica.model.Paciente;
import clinica.model.dados.Repositorio;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

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
	private JTextField localNascimento;
	private JFormattedTextField cpf;
	private JFormattedTextField celular;
	private JFormattedTextField cep;
	private JFormattedTextField celularAcompanhante;
	private JComboBox<Object> etnia;
	private JComboBox<Object> estados;
	private JRadioButton sexoM;
	private JRadioButton sexoF;
	private JFormattedTextField dataNascimento;
	private Paciente pac;
	private List<Object> pacientes = new ArrayList<Object>();
	private static String[] etnias = { "Branco(a)", "Pardo(a)", "Negro(a)", "Indígeno(a)", "Amarelo(a)"};
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
	 * Create the frame.
	 */
	public CadastroPacienteView(Repositorio repo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		try {
			cep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		
		JLabel label_9 = new JLabel("Dados Pessoais");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(54, 238, 113, 17);
		contentPane.add(label_9);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(54, 259, 616, 2);
		contentPane.add(separator_2);
		
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
		
		try {
			celular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		
		try {
			cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		label_16.setBounds(523, 320, 41, 14);
		contentPane.add(label_16);

		sexoM = new JRadioButton("M", false);
		sexoM.setBounds(566, 317, 41, 23);
		contentPane.add(sexoM);
		
		sexoF = new JRadioButton("F", false);
		sexoF.setBounds(608, 317, 41, 23);
		contentPane.add(sexoF);
		
		grupo1 = new ButtonGroup();
		grupo1.add(sexoM);
	  	grupo1.add(sexoF);
		
		JLabel label_12 = new JLabel("Data de Nascimento:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(54, 326, 134, 14);
		contentPane.add(label_12);
		
		try {
			dataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
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
		
		try {
			celularAcompanhante = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		celularAcompanhante.setBounds(210, 355, 123, 20);
		contentPane.add(celularAcompanhante);
		
		JLabel lblLocalDeNascimento = new JLabel("Local de Nascimento:");
		lblLocalDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLocalDeNascimento.setBounds(340, 357, 147, 14);
		contentPane.add(lblLocalDeNascimento);
		
		localNascimento = new JTextField();
		localNascimento.setColumns(10);
		localNascimento.setBounds(480, 355, 160, 20);
		contentPane.add(localNascimento);
		
		JButton button = new JButton("Cadastrar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					setDados(repo);
					JOptionPane.showMessageDialog(null,  pac.getNome() + " cadastrado(a) com sucesso!", "Sucesso", JOptionPane.DEFAULT_OPTION);
					limparCampos();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar paciente, alguns dados são inválidos!", "Erro ao cadastrar!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(303, 416, 109, 23);
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
		dataNascimento.setText("");
		estadoCivil.setText("");
		celularAcompanhante.setText("");
		localNascimento.setText("");
		grupo1.clearSelection();
	}
	
	private void setDados(Repositorio repo) {
		pac = new Paciente();
		List<String> atributos;
		
		//Registros de endereço
		pac.setLogradouro(rua.getText());
		pac.setNumero(Integer.parseInt(numero.getText()));
		pac.setCep(cep.getText());
		pac.setBairro(bairro.getText());
		pac.setComplemento(complemento.getText());
		pac.setCidade(cidade.getText());
		pac.setEstado(estados.getSelectedItem().toString());
		
		//Registros de dados pessoais
		pac.setNome(nome.getText());
		pac.setTelefone(celular.getText());
		if (etnia.getSelectedItem().equals("Branco(a)")) {
			pac.setEtnia(EtniaEnum.BRANCO); 
		} else if (etnia.getSelectedItem().equals("Pardo(a)")) {
			pac.setEtnia(EtniaEnum.PARDO); 
		} else if (etnia.getSelectedItem().equals("Negro(a)")) {
			pac.setEtnia(EtniaEnum.NEGRO); 
		} else if (etnia.getSelectedItem().equals("Indigeno(a)")) {
			pac.setEtnia(EtniaEnum.INDIGENA);
		} else {
			pac.setEtnia(EtniaEnum.AMARELO);
		}
		pac.setCpf(cpf.getText());
		pac.setRg(rg.getText());
		if (sexoM.isSelected()) {
			pac.setSexo(SexoEnum.MASCULINO);
		} else {
			pac.setSexo(SexoEnum.FEMININO);
		}
		pac.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento.getText()));
		pac.setEstadoCivil(estadoCivil.getText());
		pac.setTelefoneAcompanhante(celularAcompanhante.getText());
		pac.setLocalNascimento(localNascimento.getText());
		
		pacientes.add(pac);
		
		atributos = SecretariaController.gerarListaAtributosPaciente(pac);
		
		if(SecretariaController.validarDados(atributos)) {
			repo.setPacientes(pacientes);
		}
	}
}
