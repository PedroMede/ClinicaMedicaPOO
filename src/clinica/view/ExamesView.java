package clinica.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.controller.ConsultaController;
import clinica.controller.ExameController;
import clinica.model.Consulta;
import clinica.model.Exame;
import clinica.model.TableModel.ConsultaTableModel;
import clinica.model.TableModel.ExameTableModel;
import clinica.model.dados.Repositorio;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ExamesView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private ExameTableModel tabela = new ExameTableModel();
	private JTextField txtResultado;
	private JTextField txtDuracao;
	private JTextField txtNome;
	private JTextField txtObsG;
	private JTextField txtCod;
	private List<Object> exame;
	private ExameController exameController = new ExameController();
	private JTextField txtTipoexame;
	
	
	public ExamesView(Repositorio repo) {
		super("Exames");
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				exame = exameController.recuperarExame("./database/exames.txt");
				
				if(exame != null) {
					for(Object exames : exame) {
						tabela.addRow((Exame) exames);
					}
				}
				if(repo.getExames() != null) {
					for(Object exames : repo.getExames()) {
						tabela.addRow((Exame) exames);
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
		pane.setBounds(25, 90, 617, 218);
		getContentPane().add(pane);
		
		txtResultado = new JTextField();
		txtResultado.setBounds(447, 46, 89, 20);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);
		
		txtDuracao = new JTextField();
		txtDuracao.setBounds(341, 46, 96, 20);
		getContentPane().add(txtDuracao);
		txtDuracao.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(131, 46, 87, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// diferente de menos -1, tem algo selecionado
				if(table.getSelectedRow()!= -1) {
					tabela.setValueAt(txtCod.getText(), table.getSelectedRow(), 0);
					tabela.setValueAt(txtNome.getText(), table.getSelectedRow(), 1);
					tabela.setValueAt(txtObsG.getText(), table.getSelectedRow(), 2);
					tabela.setValueAt(txtDuracao.getText(), table.getSelectedRow(), 3);
					tabela.setValueAt(txtResultado.getText(), table.getSelectedRow(), 4);
					tabela.setValueAt(txtTipoexame, table.getSelectedRow(), 5);
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione a linha a ser alterada.");
				
				}
				
				txtCod.setText(null);
				txtNome.setText(null);
				txtObsG.setText(null);
				txtResultado.setText(null);
				txtDuracao.setText(null);
			}
		});
		
		btnAlterar.setBounds(25, 319, 89, 23);
		getContentPane().add(btnAlterar);

		txtObsG = new JTextField();
		txtObsG.setBounds(228, 46, 96, 20);
		getContentPane().add(txtObsG);
		txtObsG.setColumns(10);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setBounds(25, 46, 96, 20);
		getContentPane().add(txtCod);
		txtCod.setColumns(10);
		
		JLabel lblId = new JLabel("Codigo");
		lblId.setBounds(25, 31, 48, 14);
		getContentPane().add(lblId);
		
		JLabel lblHorrio = new JLabel("Nome");
		lblHorrio.setBounds(131, 31, 48, 14);
		getContentPane().add(lblHorrio);
		
		JLabel lblData = new JLabel("Obs Geral");
		lblData.setBounds(228, 31, 48, 14);
		getContentPane().add(lblData);
		
		JLabel lblMedico = new JLabel("Dura\u00E7\u00E3o");
		lblMedico.setBounds(341, 31, 48, 14);
		getContentPane().add(lblMedico);
		
		JLabel lblPaciente = new JLabel("Resultado");
		lblPaciente.setBounds(447, 31, 64, 14);
		getContentPane().add(lblPaciente);
		
		JButton button = new JButton("Deletar");
		button.setBounds(553, 319, 89, 23);
		getContentPane().add(button);
		
		txtTipoexame = new JTextField();
		txtTipoexame.setBounds(546, 46, 96, 20);
		getContentPane().add(txtTipoexame);
		txtTipoexame.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(594, 49, 48, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTipoExame = new JLabel("Tipo Exame");
		lblTipoExame.setBounds(546, 31, 48, 14);
		getContentPane().add(lblTipoExame);
		
	}
	
	
	
	public static void main(String[] args) {
		Repositorio repo = null;
		ExamesView  update = new ExamesView(repo);
		
		update.setVisible(true);
		update.setSize(800, 427);
		
		
	}
}

