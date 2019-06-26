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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

import clinica.controller.GerenteController;
import clinica.controller.SecretariaController;
import clinica.model.Consulta;
import clinica.model.Medico;
import clinica.model.Paciente;
import clinica.model.dados.Repositorio;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MarcarConsultaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private Consulta con;
	private JPanel contentPane;
	private JComboBox<Object> medicos = new JComboBox<Object>();
	private JComboBox<Object> pacientes = new JComboBox<Object>();
	private List<Object> medicosList;
	private List<Object> pacientesList;
	private GerenteController gerenteController = new GerenteController();
	private SecretariaController secretariaController = new SecretariaController();

	/**
	 * Create the frame.
	 */
	public MarcarConsultaView(Repositorio repo) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				medicosList = gerenteController.recuperarFuncionario("./database/medicos.txt");
				pacientesList = secretariaController.recuperarObjeto("./database/pacientes.txt");
				
				if(medicosList != null) {
					for(Object medico : medicosList) {
						medicos.addItem(((Medico) medico).getNome());
					}
				}
				if(pacientesList != null) {
					for(Object paciente : pacientesList) {
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
		
		JLabel lblPacientes = new JLabel("Pacientes:");
		lblPacientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPacientes.setBounds(40, 183, 73, 14);
		contentPane.add(lblPacientes);
		
		medicos.setBounds(115, 121, 113, 20);
		contentPane.add(medicos);
		
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
					//limparCampos();
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
		List<String> atributos;
		List<Object> secretarias = new ArrayList<Object>();
		


	}
}
