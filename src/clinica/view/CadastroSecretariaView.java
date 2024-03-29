package clinica.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import clinica.controller.GerenteController;
import clinica.model.Secretaria;
import clinica.model.dados.Repositorio;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.HorarioEnum;
import clinica.model.enums.PerfilEnum;
import clinica.model.enums.SexoEnum;
import clinica.model.login.Login;

public class CadastroSecretariaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup grupo1;
	private ButtonGroup grupo2;
	private JTextField numero;
	private JTextField rua;
	private JTextField bairro;
	private JTextField cidade;
	private JTextField complemento;
	private JTextField nome;
	private JTextField rg;
	private JTextField estadoCivil;
	private JTextField ctps;
	private JTextField login;
	private JFormattedTextField cpf;
	private JFormattedTextField celular;
	private JFormattedTextField cep;
	private JComboBox<Object> etnia;
	private JComboBox<Object> estados;
	private JRadioButton sexoM;
	private JRadioButton sexoF;
	private JRadioButton rdbtnManh;
	private JRadioButton rdbtnTarde;
	private JRadioButton rdbtnNoite;
	private JFormattedTextField dataNascimento;
	private Secretaria sec;
	private GerenteController gerenteController = new GerenteController();
	private List<Object> logins = new ArrayList<Object>();
	private List<Object> secretarias;
	private static String[] etnias = { "Branco(a)", "Pardo(a)", "Negro(a)", "Ind�geno(a)", "Amarelo(a)"};
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
	private JPasswordField senha;

	/**
	 * Create the frame.
	 */
	public CadastroSecretariaView(Repositorio repo) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				secretarias = gerenteController.recuperarFuncionario("./database/secretarias.txt");
				
				verificaHorarios(secretarias, repo);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 733, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeSecretrias = new JLabel("Cadastro de Secret\u00E1rias");
		lblCadastroDeSecretrias.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeSecretrias.setForeground(Color.BLACK);
		lblCadastroDeSecretrias.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCadastroDeSecretrias.setBounds(224, 50, 285, 34);
		contentPane.add(lblCadastroDeSecretrias);
		
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

		JLabel label_18 = new JLabel("Dados Corporativos");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_18.setBounds(54, 370, 147, 17);
		contentPane.add(label_18);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(54, 390, 616, 2);
		contentPane.add(separator_1);
		
		JLabel label_19 = new JLabel("CTPS:");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_19.setBounds(54, 402, 41, 14);
		contentPane.add(label_19);
		
		ctps = new JTextField();
		ctps.setColumns(10);
		ctps.setBounds(101, 400, 147, 20);
		contentPane.add(ctps);
		
		JLabel lblTurnoDeTrabalho = new JLabel("Turno de trabalho:");
		lblTurnoDeTrabalho.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTurnoDeTrabalho.setBounds(258, 402, 124, 14);
		contentPane.add(lblTurnoDeTrabalho);
		
		rdbtnManh = new JRadioButton("Manh\u00E3", false);
		rdbtnManh.setBounds(377, 399, 67, 23);
		contentPane.add(rdbtnManh);
		
		rdbtnTarde = new JRadioButton("Tarde", false);
		rdbtnTarde.setBounds(442, 399, 67, 23);
		contentPane.add(rdbtnTarde);
		
		rdbtnNoite = new JRadioButton("Noite", false);
		rdbtnNoite.setBounds(503, 399, 67, 23);
		contentPane.add(rdbtnNoite);
		
		grupo2 = new ButtonGroup();
		grupo2.add(rdbtnManh);
		grupo2.add(rdbtnTarde);
		grupo2.add(rdbtnNoite);
		
		JLabel label_20 = new JLabel("Login:");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_20.setBounds(54, 455, 41, 14);
		contentPane.add(label_20);
		
		login = new JTextField();
		login.setColumns(10);
		login.setBounds(101, 453, 147, 20);
		contentPane.add(login);
		
		JLabel label_21 = new JLabel("Senha:");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_21.setBounds(258, 456, 53, 14);
		contentPane.add(label_21);
		
		senha = new JPasswordField();
		senha.setBounds(314, 453, 113, 20);
		contentPane.add(senha);
		
		JButton button = new JButton("Cadastrar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					setDados(repo);
					JOptionPane.showMessageDialog(null, sec.getNome() + " cadastrado(a) com sucesso!", "Sucesso", JOptionPane.DEFAULT_OPTION);
					limparCampos();
					verificaHorarios(secretarias, repo);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar secret�rio(a), alguns dados s�o inv�lidos!", "Erro ao cadastrar!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		button.setBounds(318, 527, 109, 23);
		contentPane.add(button);
		
		JTextArea turnos = new JTextArea();
		turnos.setTabSize(6);
		turnos.setEditable(false);
		turnos.setLineWrap(true);
		turnos.setText("Manha: 07:00 - 12:00\nTarde: 12:00 - 17:00\nNoite: 17:00 - 22:00");
		turnos.setBounds(457, 436, 166, 58);
		contentPane.add(turnos);
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
		ctps.setText("");
		login.setText("");
		senha.setText("");
		grupo1.clearSelection();
		grupo2.clearSelection();
	}
	
	private void setDados(Repositorio repo) {
		Login log = new Login();
		Date dataAdmissao = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		sec = new Secretaria();
		List<String> atributos;
		List<Object> secretarias = new ArrayList<Object>();
		
		//Registros de endere�o
		sec.setLogradouro(rua.getText());
		sec.setNumero(Integer.parseInt(numero.getText()));
		sec.setCep(cep.getText());
		sec.setBairro(bairro.getText());
		sec.setComplemento(complemento.getText());
		sec.setCidade(cidade.getText());
		sec.setEstado(estados.getSelectedItem().toString());
		
		//Registros de dados pessoais
		sec.setNome(nome.getText());
		sec.setTelefone(celular.getText());
		if (etnia.getSelectedItem().equals("Branco(a)")) {
			sec.setEtnia(EtniaEnum.BRANCO); 
		} else if (etnia.getSelectedItem().equals("Pardo(a)")) {
			sec.setEtnia(EtniaEnum.PARDO); 
		} else if (etnia.getSelectedItem().equals("Negro(a)")) {
			sec.setEtnia(EtniaEnum.NEGRO); 
		} else if (etnia.getSelectedItem().equals("Amarelo(a")) {
			sec.setEtnia(EtniaEnum.INDIGENA);
		} else {
			sec.setEtnia(EtniaEnum.AMARELO);
		}
		sec.setCpf(cpf.getText());
		sec.setRg(rg.getText());
		if (sexoM.isSelected()) {
			sec.setSexo(SexoEnum.MASCULINO);
		} else {
			sec.setSexo(SexoEnum.FEMININO);
		}
		sec.setDataNascimento(sdf.format(dataNascimento.getText()));
		sec.setEstadoCivil(estadoCivil.getText());
		
		//Registros de dados corporativos
		sec.setCarteiraTrab(ctps.getText());
		sec.setLogin(login.getText());
		sec.setSenha(new String(senha.getPassword()));
		sec.setPerfilEnum(PerfilEnum.ROLE_SECRETARIA);
		sec.setDataAdmissao(sdf.format(dataAdmissao));
		if(rdbtnManh.isSelected()) {
			sec.setHorarioTrab(HorarioEnum.MANHA);
		} else if(rdbtnTarde.isSelected()) {
			sec.setHorarioTrab(HorarioEnum.TARDE);
		} else {
			sec.setHorarioTrab(HorarioEnum.NOITE);
		}
		
		secretarias.add(sec);
		
		atributos = GerenteController.gerarListaAtributos(sec);
		atributos.add(sec.getHorarioTrab().toString());
		if(GerenteController.validarDados(atributos)) {
			repo.setSecretarias(secretarias);
			
			log.setPerfil(sec.getPerfilEnum().toString());
			log.setUsuario(sec.getLogin());
			log.setSenha(sec.getSenha());
			
			logins.add(log);
			
			repo.setLogin(logins);
		}
	}
	
	private void verificaHorarios(List<Object> objects, Repositorio repo) {
		int manha = 0;
		int tarde = 0;
		int noite = 0;
		
		if(objects != null) {
			for(Object sec : objects) {
				if(((Secretaria) sec).getHorarioTrab().equals(HorarioEnum.MANHA)) {
					manha++;
				} else if(((Secretaria) sec).getHorarioTrab().equals(HorarioEnum.TARDE)) {
					tarde++;
				} else {
					noite++;
				}
			}
		}
		if(repo.getSecretarias() != null) {
			for(Object sec : repo.getSecretarias()) {
				if(((Secretaria) sec).getHorarioTrab().equals(HorarioEnum.MANHA)) {
					manha++;
				} else if(((Secretaria) sec).getHorarioTrab().equals(HorarioEnum.TARDE)) {
					tarde++;
				} else {
					noite++;
				}
			}
		}
		
		if(manha == 0 && tarde == 0 && noite > 0) {
			JOptionPane.showMessageDialog(null, "Turnos recomendados:\nManh�\nTarde", "Turnos recomendados", JOptionPane.INFORMATION_MESSAGE);
		} else if(manha == 0 && tarde > 0 && noite == 0) {
			JOptionPane.showMessageDialog(null, "Turnos recomendados:\nManh�\nNoite", "Turnos recomendados", JOptionPane.INFORMATION_MESSAGE);
		} else if(manha > 0 && tarde == 0 && noite == 0) {
			JOptionPane.showMessageDialog(null, "Turnos recomendados:\nTarde\nNoite", "Turnos recomendados", JOptionPane.INFORMATION_MESSAGE);
		} else if(manha == 0 && tarde > 0 && noite > 0) {
			JOptionPane.showMessageDialog(null, "Turno recomendado:\nManh�", "Turno recomendado", JOptionPane.INFORMATION_MESSAGE);
		} else if(manha > 0 && tarde == 0 && noite > 0) {
			JOptionPane.showMessageDialog(null, "Turno recomendado:\nTarde", "Turno recomendado", JOptionPane.INFORMATION_MESSAGE);
		} else if(manha > 0 && tarde > 0 && noite == 0) {
			JOptionPane.showMessageDialog(null, "Turno recomendado:\nNoite", "Turno recomendado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Turno recomendados:\nTodos", "Turnos recomendados", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
