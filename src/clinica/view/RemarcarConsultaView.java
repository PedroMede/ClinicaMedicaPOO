package clinica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

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
	 * @throws ParseException 
	 */
	public RemarcarConsultaView() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemarcarConsulta = new JLabel("Remarcar Consulta");
		lblRemarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemarcarConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemarcarConsulta.setBounds(141, 11, 220, 26);
		contentPane.add(lblRemarcarConsulta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 78, 421, 195);
		contentPane.add(scrollPane);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHora.setBounds(59, 306, 46, 16);
		contentPane.add(lblHora);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new MaskFormatter("##:##"));
		formattedTextField.setBounds(106, 305, 80, 20);
		contentPane.add(formattedTextField);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDia.setBounds(307, 307, 54, 16);
		contentPane.add(lblDia);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(353, 306, 103, 20);
		contentPane.add(dateChooser);
		
		JButton btnRemarcar = new JButton("Remarcar");
		btnRemarcar.setBounds(219, 372, 109, 23);
		contentPane.add(btnRemarcar);
	}
}
