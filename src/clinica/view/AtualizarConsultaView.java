package clinica.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import clinica.controller.ConsultaController;
import clinica.model.Consulta;
import clinica.model.TableModel.ConsultaTableModel;
import clinica.model.dados.Repositorio;

import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AtualizarConsultaView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private ConsultaTableModel tabela = new ConsultaTableModel();
	private JTextField txtPaciente;
	private JTextField txtMedico;
	private JTextField txtHora;
	private JTextField txtDia;
	private List<Object> consultas;
	private ConsultaController consultaController = new ConsultaController();
	
	
	public AtualizarConsultaView(Repositorio repo) {
		super("Remarcar/Desmarcar Consulta");
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				consultas = consultaController.recuperarConsultas("./database/consultas.txt");
				
				if(consultas != null) {
					for(Object consulta : consultas) {
						tabela.addRow((Consulta) consulta);
					}
				}
				if(repo.getConsultas() != null) {
					for(Object consulta : repo.getConsultas()) {
						tabela.addRow((Consulta) consulta);
					}
				}
			}
		});
		getContentPane().setBounds(new Rectangle(111, 120, 500, 500));
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		JTable table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(100,80));
		table.setModel(tabela);

		
		JScrollPane pane  = new JScrollPane(table);
		pane.setBounds(25, 90, 511, 218);
		getContentPane().add(pane);
		
		txtPaciente = new JTextField();
		txtPaciente.setBounds(447, 46, 89, 20);
		getContentPane().add(txtPaciente);
		txtPaciente.setColumns(10);
		
		txtMedico = new JTextField();
		txtMedico.setBounds(306, 46, 96, 20);
		getContentPane().add(txtMedico);
		txtMedico.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(25, 46, 87, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// diferente de menos -1, tem algo selecionado
				if(table.getSelectedRow() != -1) {
					tabela.setValueAt(txtHora.getText(), table.getSelectedRow(), 1);
					tabela.setValueAt(txtDia.getText(), table.getSelectedRow(), 2);
					tabela.setValueAt(txtMedico.getText(), table.getSelectedRow(), 3);
					tabela.setValueAt(txtPaciente.getText(), table.getSelectedRow(), 4);
					
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione a linha a ser alterada.");
				
				}
				
				txtHora.setText(null);
				txtDia.setText(null);
				txtPaciente.setText(null);
				txtMedico.setText(null);
			}
		});
		
		btnAlterar.setBounds(25, 319, 89, 23);
		getContentPane().add(btnAlterar);
		
		txtDia = new JTextField();
		txtDia.setBounds(161, 46, 96, 20);
		getContentPane().add(txtDia);
		txtDia.setColumns(10);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio");
		lblHorrio.setBounds(25, 31, 48, 14);
		getContentPane().add(lblHorrio);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(161, 31, 48, 14);
		getContentPane().add(lblData);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setBounds(306, 31, 48, 14);
		getContentPane().add(lblMedico);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(447, 31, 64, 14);
		getContentPane().add(lblPaciente);
		
		JButton button = new JButton("Deletar");
		button.setBounds(447, 319, 89, 23);
		getContentPane().add(button);
		
	}
	public static void main(String[] args) {
		Repositorio repo = null;
		AtualizarConsultaView  update = new AtualizarConsultaView(repo);
		
		update.setVisible(true);
		update.setSize(576, 427);
		
		
	}
}
