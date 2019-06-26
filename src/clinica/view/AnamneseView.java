package clinica.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clinica.controller.ExameController;
import clinica.model.Anamnese;
import clinica.model.Consulta;
import clinica.model.Exame;
import clinica.model.dados.Repositorio;

public class AnamneseView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Object> exames = new JComboBox<Object>();
	private JTextArea sintomas;
	private JTextArea prescricao;
	private JTextArea diagnostico;
	private List<Object> examesList;
	private Anamnese anamnese;
	private List<Object> anamneses = new ArrayList<Object>();
	private ExameController exameController = new ExameController();

	/**
	 * Create the frame.
	 */
	public AnamneseView(Repositorio repo, Consulta con) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				examesList = exameController.recuperarExame("./database/exames.txt");
				
				for(Object exame : examesList) {	
					exames.addItem(((Exame) exame).getNome());
				}
			}
			@Override
			public void windowClosed(WindowEvent e) {
				exames.removeAll();
				examesList = null;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 503, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Cadastro de Anamnese");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(150, 42, 220, 14);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("Exame: ");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(30, 95, 50, 14);
		contentPane.add(label);
		
		exames.setBounds(124, 93, 134, 20);
		contentPane.add(exames);
		
		JLabel label_2 = new JLabel("Sintomas:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(30, 141, 64, 14);
		contentPane.add(label_2);
		
		sintomas = new JTextArea();
		sintomas.setLineWrap(true);
		sintomas.setBounds(124, 137, 322, 117);
		contentPane.add(sintomas);
		
		JLabel label_3 = new JLabel("Prescri\u00E7\u00E3o:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(30, 269, 73, 14);
		contentPane.add(label_3);
		
		prescricao = new JTextArea();
		prescricao.setLineWrap(true);
		prescricao.setBounds(124, 265, 322, 117);
		contentPane.add(prescricao);
		
		JLabel label_4 = new JLabel("Diagn\u00F3stico:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(30, 398, 86, 14);
		contentPane.add(label_4);
		
		diagnostico = new JTextArea();
		diagnostico.setLineWrap(true);
		diagnostico.setBounds(124, 393, 322, 117);
		contentPane.add(diagnostico);
		
		JButton button = new JButton("Cadastrar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					cadastrar(repo, con);	
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Dados incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		button.setBounds(209, 539, 109, 23);
		contentPane.add(button);
	}
	
	private void cadastrar(Repositorio repo, Consulta con) {
		anamnese = new Anamnese();
		
		anamnese.setSintomas(sintomas.getText());
		anamnese.setPrescricao(prescricao.getText());
		anamnese.setDiagnosticoDefinitivo(diagnostico.getText());
		
		anamnese.setMedico(con.getMedico());
		anamnese.setPaciente(con.getPaciente());
		
		anamneses.add(anamnese);
		
		repo.setAnamneses(anamneses);
		
	}
}
