package clinica.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.model.dados.Repositorio;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SecretariaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SecretariaView(Repositorio repo) {
		MarcarConsultaView consulta = new MarcarConsultaView(repo);
		CadastroPacienteView cadPac = new CadastroPacienteView(repo);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 71, 174, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("Consultas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(208, 59, 85, 14);
		contentPane.add(label);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(300, 71, 174, 2);
		contentPane.add(separator_1);
		
		JButton marcar = new JButton("Marcar");
		marcar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consulta.setVisible(true);
			}
		});
		marcar.setBounds(62, 96, 89, 23);
		contentPane.add(marcar);
		
		JButton desmarcar = new JButton("Desmarcar");
		desmarcar.setBounds(197, 96, 116, 23);
		contentPane.add(desmarcar);
		
		JButton remarcar = new JButton("Remarcar");
		remarcar.setBounds(351, 96, 99, 23);
		contentPane.add(remarcar);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(30, 164, 186, 2);
		contentPane.add(separator_2);
		
		JLabel label_1 = new JLabel("Exames");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(216, 152, 77, 14);
		contentPane.add(label_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(288, 164, 186, 2);
		contentPane.add(separator_3);
		
		JButton baseExames = new JButton("Base de Exames");
		baseExames.setBounds(182, 198, 144, 23);
		contentPane.add(baseExames);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(30, 269, 174, 2);
		contentPane.add(separator_4);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPacientes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPacientes.setBounds(208, 257, 85, 14);
		contentPane.add(lblPacientes);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(300, 269, 174, 2);
		contentPane.add(separator_5);
		
		JButton cadastrarPac = new JButton("Cadastrar Paciente");
		cadastrarPac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadPac.setVisible(true);
			}
		});
		cadastrarPac.setBounds(182, 299, 144, 23);
		contentPane.add(cadastrarPac);
	}
}
