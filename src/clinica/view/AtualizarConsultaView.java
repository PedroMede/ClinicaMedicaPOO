package clinica.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import clinica.model.Consulta;
import clinica.model.TableModel.ConsultaTableModel;

public class AtualizarConsultaView extends JFrame{
	
	
	ConsultaTableModel tabela = new ConsultaTableModel();
	
	
	private JTextField txtPaciente;
	private JTextField txtMedico;
	private JTextField txtHora;
	private JTextField txtDia;
	private JTextField txtId;
	
	
	public AtualizarConsultaView() {
		super();
		getContentPane().setBounds(new Rectangle(111, 120, 500, 500));
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		JTable table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(100,80));
		table.setModel(tabela);

		
		JScrollPane pane  = new JScrollPane(table);
		pane.setBounds(25, 111, 511, 197);
		getContentPane().add(pane);
		
		txtPaciente = new JTextField();
		txtPaciente.setBounds(447, 46, 89, 20);
		getContentPane().add(txtPaciente);
		txtPaciente.setColumns(10);
		
		txtMedico = new JTextField();
		txtMedico.setBounds(341, 46, 96, 20);
		getContentPane().add(txtMedico);
		txtMedico.setColumns(10);
		
		JButton btnDeletar = new JButton("Deletar");
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//verificar de não esta selecionada
				if (table.getSelectedRow()!= -1) {
					
					tabela.removeRow(table.getSelectedRow());
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione a linha");
				}
				
				txtHora.setText(null);
				txtPaciente.setText(null);
				txtMedico.setText(null);
				txtDia.setText(null);
				txtId.setText(null);
			}
		});
		btnDeletar.setBounds(25, 77, 89, 23);
		getContentPane().add(btnDeletar);
		
		txtHora = new JTextField();
		txtHora.setBounds(131, 46, 87, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// diferente de menos -1, tem algo selecionado
				if(table.getSelectedRow()!= -1) {
					tabela.setValueAt(txtHora.getText(), table.getSelectedRow(), 0);
					tabela.setValueAt(txtPaciente.getText(), table.getSelectedRow(), 1);
					tabela.setValueAt(txtMedico.getText(), table.getSelectedRow(), 2);
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione a linha a ser alterada");
				
				}
				
				txtHora.setText(null);
				txtPaciente.setText(null);
				txtMedico.setText(null);
			}
		});
		
		btnAlterar.setBounds(447, 77, 89, 23);
		getContentPane().add(btnAlterar);
		
		txtDia = new JTextField();
		txtDia.setBounds(228, 46, 96, 20);
		getContentPane().add(txtDia);
		txtDia.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(25, 46, 96, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
	}
	public static void main(String[] args) {
		AtualizarConsultaView  update = new AtualizarConsultaView();
		
		update.setVisible(true);
		update.setSize(576, 427);
		
		
	}
}
