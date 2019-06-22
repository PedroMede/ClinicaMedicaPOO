package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ExamesView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamesView frame = new ExamesView();
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
	public ExamesView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 48, 423, 266);
		contentPane.add(scrollPane);
		
		JLabel lblExames = new JLabel("Exames");
		lblExames.setHorizontalAlignment(SwingConstants.CENTER);
		lblExames.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExames.setBounds(157, 11, 220, 26);
		contentPane.add(lblExames);
		
		JButton btnNovoExame = new JButton();
		btnNovoExame.setText("Novo Exame");
		btnNovoExame.setBounds(115, 347, 120, 23);
		contentPane.add(btnNovoExame);
		
		JButton btnRemoverExame = new JButton();
		btnRemoverExame.setText("Deletar Exame");
		btnRemoverExame.setBounds(303, 347, 142, 23);
		contentPane.add(btnRemoverExame);
	}

}
