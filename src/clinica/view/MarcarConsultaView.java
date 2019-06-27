package clinica.view;

import java.awt.Color;
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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import clinica.controller.ConsultaController;
import clinica.controller.GerenteController;
import clinica.controller.SecretariaController;
import clinica.model.Consulta;
import clinica.model.Medico;
import clinica.model.Paciente;
import clinica.model.dados.Repositorio;

public class MarcarConsultaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField hora;
	private JDateChooser dia;
	private Consulta con;
	private JComboBox<Object> medicos = new JComboBox<Object>();
	private JComboBox<Object> pacientes = new JComboBox<Object>();
	private List<Object> medicosList;
	private List<Object> pacientesList;
	private List<Object> consultasList;
	private List<Object> consultas = new ArrayList<Object>();
	private GerenteController gerenteController = new GerenteController();
	private SecretariaController secretariaController = new SecretariaController();
	private ConsultaController consultaController = new ConsultaController();

	/**
	 * Create the frame.
	 */
	public MarcarConsultaView(Repositorio repo) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				medicosList = gerenteController.recuperarFuncionario("./database/medicos.txt");
				pacientesList = secretariaController.recuperarObjeto("./database/pacientes.txt");
				consultasList = consultaController.recuperarConsultas("./database/consultas.txt");

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
				if(repo.getPacientes() != null) {
					for(Object paciente : repo.getPacientes()) {
						pacientes.addItem(((Paciente) paciente).getNome());
					}
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		medicos.setBounds(115, 121, 113, 20);
		contentPane.add(medicos);
		
		JLabel lblPacientes = new JLabel("Pacientes:");
		lblPacientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPacientes.setBounds(40, 183, 73, 14);
		contentPane.add(lblPacientes);
		
		pacientes.setBounds(115, 181, 113, 20);
		contentPane.add(pacientes);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDia.setBounds(322, 123, 25, 14);
		contentPane.add(lblDia);
		
		dia = new JDateChooser();
		dia.setBounds(357, 121, 93, 20);
		contentPane.add(dia);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(315, 184, 43, 14);
		contentPane.add(lblHora);
		
		try {
			hora = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		hora.setBounds(356, 181, 92, 20);
		contentPane.add(hora);
		
		JButton button = new JButton("Cadastrar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					setDados(repo);
					JOptionPane.showMessageDialog(null,"Consulta marcada com sucesso!", "Sucesso", JOptionPane.DEFAULT_OPTION);
					limparCampos();
				} catch (ParseException pe) {
					JOptionPane.showMessageDialog(null, "Data inválida!", "Erro ao marcar!", JOptionPane.ERROR_MESSAGE);
				} catch (DateTimeException dte) {
					JOptionPane.showMessageDialog(null, "Data inválida!", "Erro ao marcar!", JOptionPane.ERROR_MESSAGE);
				} catch (RuntimeException re) {
					JOptionPane.showMessageDialog(null, "Horário indisponível", "Erro ao marcar!", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao marcar consulta, alguns dados são inválidos!", "Erro ao marcar!", JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		button.setBounds(204, 273, 109, 23);
		contentPane.add(button);
	}
	
	private void limparCampos() {
		hora.setText(null);
		dia.setDate(null);
	}
	
	private void setDados(Repositorio repo) throws ParseException {
		String horaSub = hora.getText().substring(3, 5);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<String> atributos; 
		con = new Consulta();

		Date dataAtual = sdf.parse(sdf.format(new Date()));
		Date data = sdf.parse(sdf.format(dia.getDate()));

		if(data.before(dataAtual)) {
			throw new DateTimeException(null);
		}
		
		if(!(horaSub.equals("00") || horaSub.equals("30"))) {
			throw new RuntimeException();
		}
		
		if(repo.getConsultas() != null) {
			for(Object consulta : repo.getConsultas()) {
				if(((Consulta) consulta).getHora().equals(hora.getText()) && ((Consulta) consulta).getDia().equals(sdf.format(dia.getDate()))) {
					throw new RuntimeException();
				}
			}
		}
		
		if(consultasList.size() > 0) {			
			for(Object con : consultasList) {
				if(((Consulta) con).getHora().equals(hora.getText()) && ((Consulta) con).getDia().equals(sdf.format(dia.getDate()))) {
					throw new RuntimeException();
				}
			}
		}
		
		con.setDia(sdf.format(dia.getDate()));
		con.setHora(hora.getText());
		
		for(Object medico : medicosList) {
			if(((Medico) medico).getNome().equals(medicos.getSelectedItem())) {
				con.setMedico((Medico) medico);
				break;
			}
		}
		
		for(Object paciente : pacientesList) {
			if(((Paciente) paciente).getNome().equals(pacientes.getSelectedItem())) {
				con.setPaciente((Paciente) paciente);
				break;
			}
		}
		
		consultas.add(con);
		
		atributos = ConsultaController.gerarListaAtributosConsulta(con);
		
		if(ConsultaController.validarDados(atributos)) {
			repo.setConsultas(consultas);
		}
	}
}
