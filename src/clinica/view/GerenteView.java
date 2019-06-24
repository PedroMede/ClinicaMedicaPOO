package clinica.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.model.dados.Repositorio;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GerenteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GerenteView(Repositorio repo) {
		CadastroMedicoView med = new CadastroMedicoView(repo);
		CadastroSecretariaView sec = new CadastroSecretariaView(repo);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSecretria = new JButton("Secret\u00E1ria");
		btnSecretria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sec.setVisible(true);
			}
		});
		btnSecretria.setBounds(86, 116, 101, 23);
		contentPane.add(btnSecretria);
		
		JButton btnMdico = new JButton("M\u00E9dico");
		btnMdico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				med.setVisible(true);
			}
		});
		btnMdico.setBounds(241, 116, 101, 23);
		contentPane.add(btnMdico);
		
		JLabel lblNewLabel = new JLabel("Painel de cadastro de funcionários");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(86, 40, 256, 23);
		contentPane.add(lblNewLabel);
	}
}
