package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RemarcarConsultaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemarcarConsultaView frame = new RemarcarConsultaView();
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
	public RemarcarConsultaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemarcarConsulta = new JLabel("Remarcar Consulta");
		lblRemarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemarcarConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemarcarConsulta.setBounds(157, 70, 220, 26);
		contentPane.add(lblRemarcarConsulta);
	}

}
