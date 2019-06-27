package clinica.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import clinica.controller.ConsultaController;
import clinica.model.Consulta;
import clinica.model.TableModel.ConsultaTableModel;
import clinica.model.dados.Repositorio;
import clinica.model.login.Login;

public class MedicoView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private ConsultaTableModel tabela = new ConsultaTableModel();
	private JTable table;
	private List<Object> consultas;
	private ConsultaController consultaController = new ConsultaController();
	
	
	public MedicoView(Repositorio repo, Object login) {
		super("Remarcar/Desmarcar Consulta");
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				consultas = consultaController.recuperarConsultas("./database/consultas.txt");
				
				if(consultas != null) {
					for(Object consulta : consultas) {
						if(((Login) login).getUsuario().equals(((Consulta) consulta).getMedico().getLogin())) {
							tabela.addRow((Consulta) consulta);
						}
					}
				}
				
				if(tabela.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Nenhuma consulta agendada!", "Consultas", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			@Override
			public void componentHidden(ComponentEvent e) {
				int linha;
				if(repo.getConsultas() != null) {
					for(linha = consultas.size() - 1; linha >= 0 ; linha--) {
						tabela.removeRow(linha);
					}
					consultas.clear();
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
		pane.setBounds(36, 136, 511, 218);
		getContentPane().add(pane);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblConsultas.setBounds(203, 26, 167, 32);
		getContentPane().add(lblConsultas);
		
		JButton btnIniciarConsulta = new JButton("Iniciar Consulta");
		btnIniciarConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow() != -1) {
					Consulta consulta = (Consulta) getConsulta(consultas);
					AnamneseView anamense = new AnamneseView(repo, consulta);
					anamense.setVisible(true);
					
				}
			}
		});
		btnIniciarConsulta.setBounds(221, 376, 142, 23);
		getContentPane().add(btnIniciarConsulta);
		
	}
	
	private Object getConsulta(List<Object> consultas) {
		Object con = null;
		
		for(Object consulta : consultas) {
			if(((Consulta) consulta).getHora().equals(tabela.getValueAt(table.getSelectedRow(), 0))) {
				con = consulta;
				break;
			}
		}
	
		return con;
	}
}
