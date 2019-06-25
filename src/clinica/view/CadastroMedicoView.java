package clinica.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import clinica.controller.GerenteController;
import clinica.model.Medico;
import clinica.model.dados.Repositorio;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.PerfilEnum;
import clinica.model.enums.SexoEnum;
import clinica.model.login.Login;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
	private JTextField especialidade;
	private JPasswordField senha;
	private Medico med;
	private List<Object> logins = new ArrayList<Object>();
	private List<Object> medicos = new ArrayList<Object>();
	private List<String> especs = new ArrayList<String>();
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
	 * Create the frame.
	 */
	public CadastroMedicoView(Repositorio repo) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				JOptionPane.showMessageDialog(null, "Digite a especialidade e pressione Enter", "Especialidade", JOptionPane.DEFAULT_OPTION);
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 731, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeMdicos = new JLabel("Cadastro de M\u00E9dicos");
		lblCadastroDeMdicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeMdicos.setForeground(Color.BLACK);
		lblCadastroDeMdicos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCadastroDeMdicos.setBounds(228, 50, 285, 34);
		contentPane.add(lblCadastroDeMdicos);
		
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
		} catch (ParseException e1) {
			e1.printStackTrace();
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
		
		try {
			celular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
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
		} catch (ParseException e1) {
			e1.printStackTrace();
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
		
		JLabel label_18 = new JLabel("Dados Corporativos");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_18.setBounds(64, 369, 147, 17);
		contentPane.add(label_18);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(64, 389, 616, 2);
		contentPane.add(separator_3);

		JLabel label_19 = new JLabel("CTPS:");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_19.setBounds(64, 401, 41, 14);
		contentPane.add(label_19);
		
		ctps = new JTextField();
		ctps.setColumns(10);
		ctps.setBounds(111, 399, 147, 20);
		contentPane.add(ctps);
				
		JLabel label_20 = new JLabel("CRM:");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_20.setBounds(268, 401, 41, 14);
		contentPane.add(label_20);

		crm = new JTextField();
		crm.setColumns(10);
		crm.setBounds(303, 399, 119, 20);
		contentPane.add(crm);
		
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
		
		JLabel lblEspecialidades = new JLabel("Especialidade(s):");
		lblEspecialidades.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEspecialidades.setBounds(432, 402, 113, 14);
		contentPane.add(lblEspecialidades);
		
		
		especialidade = new JTextField();
		especialidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == '\n') {
					especs.add(especialidade.getText());
					System.out.println(especialidade.getText());
					especialidade.setText("");
				}
			}
		});
		especialidade.setColumns(10);
		especialidade.setBounds(546, 399, 134, 20);
		contentPane.add(especialidade);
		
		senha = new JPasswordField();
		senha.setBounds(315, 452, 107, 20);
		contentPane.add(senha);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					setDados(repo, especs);
					JOptionPane.showMessageDialog(null,  med.getNome() + " cadastrado(a) com sucesso!", "Sucesso", JOptionPane.DEFAULT_OPTION);
					limparCampos(especs);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar médico(a), alguns dados são inválidos!", "Erro ao cadastrar!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cadastrar.setBounds(322, 527, 109, 23);
		contentPane.add(cadastrar);
	}
	
	private void limparCampos(List<String> especs) {
		/*rua.setText("");
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
		crm.setText("");
		login.setText("");
		senha.setText("");*/
		System.out.println(especs);
		especs.clear();
		System.out.println(especs);
	}
	
	private void setDados(Repositorio repo, List<String> especs) {
		Login log = new Login();
		Date dataAdmissao = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		med = new Medico();
		List<String> atributos;
		
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
		med.setEspecialidade(getEspecs(especs));
		med.setLogin(login.getText());
		med.setSenha(new String(senha.getPassword()));
		med.setDataAdmissao(sdf.format(dataAdmissao));
		med.setPerfilEnum(PerfilEnum.ROLE_MEDICO);
		
		medicos.add(med);
		
		atributos = GerenteController.gerarListaAtributos(med);
		atributos.add(med.getCrm());
		for(String especialidade : med.getEspecialidade()) {
			atributos.add(especialidade);
		}
		
		if(GerenteController.validarDados(atributos)) {
			repo.setMedicos(medicos);
			
			log.setPerfil(med.getPerfilEnum().toString());
			log.setUsuario(med.getLogin());
			log.setSenha(med.getSenha());
			
			logins.add(log);
			
			repo.setLogin(logins);
		}
	}
	
	private List<String> getEspecs(List<String> especialidades) {
		List<String> especs = new ArrayList<String>();
		
		for(String espec : especialidades) {
			especs.add(espec);
		}
		
		return especs;
	}
}
