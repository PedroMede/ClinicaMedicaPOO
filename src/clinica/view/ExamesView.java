package clinica.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import clinica.controller.ExameController;
import clinica.model.Exame;
import clinica.model.TableModel.ExameTableModel;
import clinica.model.dados.Repositorio;

public class ExamesView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private ExameTableModel tabela = new ExameTableModel();
	private JTextField txtResultado;
	private JTextField txtDuracao;
	private JTable table;
	private JTextField txtNome;
	private JTextField txtObsG;
	private List<Object> exame;
	private List<Object> examesList = new ArrayList<Object>();
	private ExameController exameController = new ExameController();
	
	
	
	public ExamesView(Repositorio repo) {
		super("Exames");
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				exame = exameController.recuperarExame("./database/examesCadastrados.txt");
				
				if(exame != null) {
					if(repo.getExamesCadastrados() == null) {
						repo.setExamesCadastrados(exame);
					} else {
						if(repo.getExamesCadastrados().equals(exame)) {
							repo.setExamesCadastrados(exame);
						} else {
							repo.getExamesCadastrados().addAll(exame);
						}
					}
				}
				for(Object exames : repo.getExamesCadastrados()) {
					tabela.addRow((Exame) exames);
				}
				
				JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!", "Exames", JOptionPane.INFORMATION_MESSAGE);
			}
			
			public void componentHidden(ComponentEvent e) {
				int linha;
				if(repo.getExamesCadastrados() != null) {
					for(linha = repo.getExamesCadastrados().size() - 1; linha >= 0 ; linha--) {
						tabela.removeRow(linha);
					}
					exame.clear();
				}
			}

			
		});
		getContentPane().setBounds(new Rectangle(111, 120, 500, 500));
	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		table = new JTable();
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
				if(table.getSelectedRow() != -1) {
					try {
						atualizar(repo);
					} catch (RuntimeException re) {
						JOptionPane.showMessageDialog(null, re.getMessage(), "Erro ao atualizar!", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione a linha a ser alterada.");
				}
				
				
			}
		});
		
		btnAlterar.setBounds(25, 319, 89, 23);
		getContentPane().add(btnAlterar);

		txtObsG = new JTextField();
		txtObsG.setBounds(228, 46, 96, 20);
		getContentPane().add(txtObsG);
		txtObsG.setColumns(10);
		
		JLabel lblHorrio = new JLabel("Nome");
		lblHorrio.setBounds(131, 31, 48, 14);
		getContentPane().add(lblHorrio);
		
		JLabel lblData = new JLabel("Obs Geral");
		lblData.setBounds(228, 31, 64, 14);
		getContentPane().add(lblData);
		
		JLabel lblMedico = new JLabel("Dura\u00E7\u00E3o");
		lblMedico.setBounds(341, 31, 48, 14);
		getContentPane().add(lblMedico);
		
		JLabel lblPaciente = new JLabel("Resultado");
		lblPaciente.setBounds(447, 31, 64, 14);
		getContentPane().add(lblPaciente);
		
		JButton button = new JButton("Deletar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					desmarcar(repo);
				}  else {
					JOptionPane.showMessageDialog(null, "Selecione a linha a ser alterada.");
				}		
			}
		});
		button.setBounds(553, 319, 89, 23);
		getContentPane().add(button);
		
		
		
	}
	
	private void desmarcar(Repositorio repo) {
		int i;
		
		for(i = 0; i < repo.getExamesCadastrados().size(); i++) {
			Object exames = repo.getExamesCadastrados().get(i);
			if(((Exame) exames).getNome().equals(tabela.getValueAt(table.getSelectedRow(), 0))) {
				repo.getExamesCadastrados().remove(i);
				tabela.removeRow(i);
			}
		}
		
		System.out.println("teste");
	}
	
	
	
	private void atualizar(Repositorio repo) {
		int i;
		
		for(i = 0; i < repo.getExamesCadastrados().size(); i++) {
			Object exames = repo.getExamesCadastrados().get(i);
			if(((Exame) exames).getNome().equals(tabela.getValueAt(table.getSelectedRow(), 0))) {
				((Exame) exames).setNome(txtNome.getText());
				tabela.setValueAt(((Exame) exames).getNome(), table.getSelectedRow(), 0);
			}
			
			if(((Exame) exames).getObsGeral().equals(tabela.getValueAt(table.getSelectedRow(), 1))) {
				((Exame) exames).setObsGeral(txtObsG.getText());
				tabela.setValueAt(((Exame) exames).getObsGeral(), table.getSelectedRow(), 1);
			}
			
			if(((Exame) exames).getTempDuracao().equals(tabela.getValueAt(table.getSelectedRow(), 2))) {
				((Exame) exames).setTempDuracao(txtDuracao.getText());
				tabela.setValueAt(((Exame) exames).getTempDuracao(), table.getSelectedRow(), 2);
			}
			
			if(((Exame) exames).getTempResultado().equals(tabela.getValueAt(table.getSelectedRow(), 3))) {
				((Exame) exames).setTempResultado(txtResultado.getText());
				tabela.setValueAt(((Exame) exames).getTempResultado(), table.getSelectedRow(), 3);
			}
			
			examesList.add(exames);
			repo.getExamesCadastrados().remove(i);
			repo.getExamesCadastrados().add(i, exames);
		}
		
		
		System.out.println(repo.getExamesCadastrados());
		
	}
}

