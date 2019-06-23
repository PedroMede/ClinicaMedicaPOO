package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class GerenteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenteView frame = new GerenteView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GerenteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSecretria = new JButton("Secret\u00E1ria");
		btnSecretria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastroSecretariaView sec;
				try {
					sec = new CadastroSecretariaView();
					sec.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSecretria.setBounds(86, 116, 101, 23);
		contentPane.add(btnSecretria);
		
		JButton btnMdico = new JButton("M\u00E9dico");
		btnMdico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastroMedicoView med;
				try {
					med = new CadastroMedicoView();
					med.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
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
