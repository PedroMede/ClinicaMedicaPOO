package clinica.view;

import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import clinica.controller.ExameController;
import clinica.controller.GerenteController;
import clinica.controller.SecretariaController;
import clinica.model.Exame;
import clinica.model.MarcacaoExame;
import clinica.model.Medico;
import clinica.model.Paciente;
import clinica.model.dados.Repositorio;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MarcarExameView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Object> medicos;
	private JComboBox<Object> exames;
	private JComboBox<Object> pacientes;
	private JFormattedTextField dia;
	private JFormattedTextField hora;
	private List<Object> medicosList;
	private List<Object> pacientesList;
	private List<Object> examesList;
	private List<Object> examesMarcados = new ArrayList<Object>();
	private MarcacaoExame marcaExame;
	private GerenteController gerenteController = new GerenteController();
	private SecretariaController secretariaController = new SecretariaController();
	private ExameController exameController = new ExameController();


	/**
	 * Create the frame. 
	 */
	public MarcarExameView(Repositorio repo) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				medicos.removeAll();
				medicosList = null;
				
				pacientes.removeAll();
				pacientesList = null;
				
				exames.removeAll();
				examesList = null;
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				medicosList = gerenteController.recuperarFuncionario("./database/medicos.txt");
				pacientesList = secretariaController.recuperarObjeto("./database/pacientes.txt");
				examesList = exameController.recuperarExame("./database/examesCadastrados.txt");
				
				if(medicosList.size() > 0) {
					for(Object medico : medicosList) {
						medicos.addItem(((Medico) medico).getNome());
					}
				}
				if(pacientesList.size() > 0) {
					for(Object paciente : pacientesList) {
						pacientes.addItem(((Paciente) paciente).getNome());
					}
				}
				if(examesList.size() > 0){
					for(Object exame : examesList) {
						exames.addItem(((Exame) exame).getNome());
					}
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarcarExame = new JLabel("Marcar Exame");
		lblMarcarExame.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcarExame.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMarcarExame.setBounds(127, 35, 220, 26);
		contentPane.add(lblMarcarExame);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Exame sem m\u00E9dico");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chckbxNewCheckBox.setEnabled(false);
			}
		});
		chckbxNewCheckBox.setBounds(39, 82, 140, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel label_2 = new JLabel("M\u00E9dico:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(39, 116, 66, 18);
		contentPane.add(label_2);
		
		medicos = new JComboBox<Object>();
		medicos.setBounds(99, 116, 95, 20);
		contentPane.add(medicos);
		
		JLabel lblExame = new JLabel("Exame:");
		lblExame.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExame.setBounds(39, 153, 66, 18);
		contentPane.add(lblExame);
		
		exames = new JComboBox<Object>();
		exames.setBounds(99, 153, 95, 20);
		contentPane.add(exames);
		
		JLabel label_3 = new JLabel("Paciente:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(27, 189, 66, 18);
		contentPane.add(label_3);
		
		pacientes = new JComboBox<Object>();
		pacientes.setBounds(99, 189, 95, 20);
		contentPane.add(pacientes);
		
		JLabel label_1 = new JLabel("Hora:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(309, 114, 42, 18);
		contentPane.add(label_1);
		
		try {
			hora = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		hora.setBounds(349, 114, 89, 20);
		contentPane.add(hora);
		
		JLabel label = new JLabel("Dia:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(309, 151, 42, 18);
		contentPane.add(label);
		
		try {
			dia = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		dia.setBounds(349, 151, 89, 20);
		contentPane.add(dia);
		
		JButton button = new JButton("Marcar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					setDados(repo);
					JOptionPane.showMessageDialog(null,"Exame marcado com sucesso!", "Sucesso", JOptionPane.DEFAULT_OPTION);
					limparCampos();
				} catch (ParseException pe) {
					JOptionPane.showMessageDialog(null, "Data inválida!", "Erro ao marcar!", JOptionPane.ERROR_MESSAGE);
				} catch (DateTimeException dte) {
					JOptionPane.showMessageDialog(null, "Data inválida!", "Erro ao marcar!", JOptionPane.ERROR_MESSAGE);
				} catch (RuntimeException re) {
					JOptionPane.showMessageDialog(null, "Horário indisponível", "Erro ao marcar!", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao marcar exame, alguns dados são inválidos!", "Erro ao marcar!", JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		button.setBounds(191, 238, 109, 23);
		contentPane.add(button);
	}
	
	private void limparCampos() {
		hora.setText(null);
		dia.setText(null);
	}
	
	private void setDados(Repositorio repo) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		marcaExame = new MarcacaoExame();
		
		Date dataAtual = sdf.parse(sdf.format(new Date()));
		Date data = sdf.parse(sdf.format(dia.getText()));

		if(data.before(dataAtual)) {
			throw new DateTimeException(null);
		}
		
		if(repo.getExamesMarcados() != null) {
			for(Object exameMarcado : repo.getConsultas()) {
				if(((MarcacaoExame) exameMarcado).getHora().equals(hora.getText()) && ((MarcacaoExame) exameMarcado).getDia().equals(sdf.format(dia.getText()))) {
					throw new RuntimeException();
				}
			}
		}
		
		if(examesList.size() > 0) {			
			for(Object exameMarcado : examesList) {
				if(((MarcacaoExame) exameMarcado).getHora().equals(hora.getText()) && ((MarcacaoExame) exameMarcado).getDia().equals(sdf.format(dia.getText()))) {
					throw new RuntimeException();
				}
			}
		}
		
		marcaExame.setDia(dia.getText());
		marcaExame.setHora(hora.getText());
		
		for(Object medico : medicosList) {
			if(((Medico) medico).getNome().equals(medicos.getSelectedItem())) {
				marcaExame.setMedico((Medico) medico);
				break;
			}
		}
		
		for(Object paciente : pacientesList) {
			if(((Paciente) paciente).getNome().equals(pacientes.getSelectedItem())) {
				marcaExame.setPaciente((Paciente) paciente);
				break;
			}
		}
		
		for(Object exames : examesList) {
			if(((Exame) exames).getNome().equals(pacientes.getSelectedItem())) {
				marcaExame.setExame((Exame) exames);
				break;
			}
		}
		
		examesMarcados.add(marcaExame);
		
		repo.setExamesMarcados(examesMarcados);
	}
}
