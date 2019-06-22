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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class MarcarExameView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] pessoas = { "Fulano", "Sicrano", "Beltrano"};
	private String[] exames = {"Exame1", "Exame2", "Exame3"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcarExameView frame = new MarcarExameView();
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
	public MarcarExameView() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarcarExame = new JLabel("Marcar Exame");
		lblMarcarExame.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcarExame.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMarcarExame.setBounds(127, 35, 220, 26);
		contentPane.add(lblMarcarExame);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new MaskFormatter("##:##"));
		formattedTextField.setBounds(349, 114, 89, 20);
		contentPane.add(formattedTextField);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(341, 153, 97, 20);
		contentPane.add(dateChooser);
		
		JLabel label = new JLabel("Dia:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(309, 151, 42, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Hora:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(309, 114, 42, 18);
		contentPane.add(label_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>(pessoas);
		comboBox.setBounds(99, 189, 95, 20);
		contentPane.add(comboBox);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>(exames);
		comboBox_1.setBounds(99, 153, 95, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblExame = new JLabel("Exame:");
		lblExame.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExame.setBounds(39, 153, 66, 18);
		contentPane.add(lblExame);
		
		JLabel label_3 = new JLabel("Paciente:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(27, 189, 66, 18);
		contentPane.add(label_3);
		
		JButton button = new JButton("Marcar");
		button.setBounds(191, 238, 109, 23);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("M\u00E9dico:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(39, 116, 66, 18);
		contentPane.add(label_2);
		
		JComboBox<Object> comboBox_2 = new JComboBox<Object>(pessoas);
		comboBox_2.setBounds(99, 116, 95, 20);
		contentPane.add(comboBox_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Exame sem m\u00E9dico");
		chckbxNewCheckBox.setBounds(39, 82, 140, 23);
		contentPane.add(chckbxNewCheckBox);
	}
}
