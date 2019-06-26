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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

import clinica.controller.GerenteController;
import clinica.model.Secretaria;
import clinica.model.dados.Repositorio;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.HorarioEnum;
import clinica.model.enums.PerfilEnum;
import clinica.model.enums.SexoEnum;
import clinica.model.login.Login;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MarcarConsultaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] pessoas = { "Fulano", "Sicrano", "Beltrano"};

	/**
	 * Create the frame.
	 */
	public MarcarConsultaView(Repositorio repo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarcarConsulta = new JLabel("Marcar Consulta");
		lblMarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcarConsulta.setForeground(Color.BLACK);
		lblMarcarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMarcarConsulta.setBounds(124, 23, 285, 34);
		contentPane.add(lblMarcarConsulta);
		
		JLabel lblMdico = new JLabel("M\u00E9dico:");
		lblMdico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMdico.setBounds(60, 123, 53, 14);
		contentPane.add(lblMdico);
		
		JLabel lblPacientes = new JLabel("Pacientes:");
		lblPacientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPacientes.setBounds(40, 183, 73, 14);
		contentPane.add(lblPacientes);
		
		JComboBox<Object> medicos = new JComboBox<Object>(pessoas);
		medicos.setBounds(115, 121, 113, 20);
		contentPane.add(medicos);
		
		JComboBox<Object> pacientes = new JComboBox<Object>(pessoas);
		pacientes.setBounds(115, 181, 113, 20);
		contentPane.add(pacientes);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDia.setBounds(322, 123, 25, 14);
		contentPane.add(lblDia);
		
		JFormattedTextField hora = null;
		try {
			hora = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		hora.setBounds(356, 181, 92, 20);
		contentPane.add(hora);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(315, 184, 43, 14);
		contentPane.add(lblHora);
		
		JDateChooser dia = new JDateChooser();
		dia.setBounds(357, 121, 93, 20);
		contentPane.add(dia);
		
		JButton button = new JButton("Cadastrar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					setDados(repo);
					JOptionPane.showMessageDialog(null, con.getId() + " marcada com sucesso!", "Sucesso", JOptionPane.DEFAULT_OPTION);
					limparCampos();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao marcar consulta, alguns dados são inválidos!", "Erro ao marcar!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(204, 273, 109, 23);
		contentPane.add(button);
	}
	
	private void setDados(Repositorio repo) {
		Date dataAdmissao = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		sec = new Secretaria();
		List<String> atributos;
		List<Object> secretarias = new ArrayList<Object>();
		
		//Registros de endereço
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
		} else {
			sec.setEtnia(EtniaEnum.INDIGENA);
		}
		sec.setCpf(cpf.getText());
		sec.setRg(rg.getText());
		if (sexoM.isSelected()) {
			sec.setSexo(SexoEnum.MASCULINO);
		} else {
			sec.setSexo(SexoEnum.FEMININO);
		}
		sec.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento.getDate()));
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
		}
	}
}
