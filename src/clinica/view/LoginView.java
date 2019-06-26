package clinica.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.controller.ConsultaController;
import clinica.controller.GerenteController;
import clinica.controller.SecretariaController;
import clinica.model.dados.Repositorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField senha;
	private GerenteController gerenteController = new GerenteController();
	private SecretariaController secretariaController = new SecretariaController();
	private ConsultaController consultaController = new ConsultaController();

	/**
	 * Create the frame.
	 */
	public LoginView(Repositorio repo) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Salvando dados...", "Salvando", JOptionPane.DEFAULT_OPTION);
				if(repo.getConsultas() != null) {
					consultaController.cadastrarConsulta(repo.getConsultas(), "./database/consultas.txt");
				}
				if(repo.getExames() != null) {
					//gravar nos exames
				}
				if(repo.getMedicos() != null) {
					gerenteController.cadastrarFuncionario(repo.getMedicos(), "./database/medicos.txt", repo.getLogin());
				}
				if(repo.getPacientes() != null) {
					secretariaController.cadastrarObjeto(repo.getPacientes(), "./database/pacientes.txt");
				}
				if(repo.getSecretarias() != null) {
					gerenteController.cadastrarFuncionario(repo.getSecretarias(),"./database/secretarias.txt", repo.getLogin());
				}
				if(repo.getAnamneses() != null) {
					//gravar nas anamneses
				}
				
			}
		});
		//GerenteView gerente = new GerenteView(repo);
		SecretariaView secretaria = new SecretariaView(repo);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Cl\u00EDnica");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(167, 47, 153, 42);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Usu\u00E1rio:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(94, 166, 63, 17);
		contentPane.add(label_1);
		
		usuario = new JTextField();
		usuario.setColumns(10);
		usuario.setBounds(157, 166, 213, 20);
		contentPane.add(usuario);
		
		JLabel label_2 = new JLabel("Senha:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(94, 219, 63, 17);
		contentPane.add(label_2);
		
		senha = new JPasswordField();
		senha.setBounds(157, 219, 213, 20);
		contentPane.add(senha);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usuario.setText("");
				senha.setText("");
			}
		});
		cancelar.setBounds(94, 296, 89, 23);
		contentPane.add(cancelar);
		
		JButton button = new JButton("Logar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secretaria.setVisible(true);
			}
		});
		button.setBounds(281, 296, 89, 23);
		contentPane.add(button);
	}

}
