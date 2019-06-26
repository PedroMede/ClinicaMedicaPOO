package clinica.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import clinica.controller.ConsultaController;
import clinica.model.Consulta;
import clinica.model.TableModel.ConsultaTableModel;
import clinica.model.dados.Repositorio;

import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Font;

public class MedicoView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private ConsultaTableModel tabela = new ConsultaTableModel();
	private List<Object> consultas;
	private ConsultaController consultaController = new ConsultaController();
	private JTextField txtFiltro;
	
	
	public MedicoView(Repositorio repo) {
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
		pane.setBounds(36, 136, 511, 218);
		getContentPane().add(pane);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblConsultas.setBounds(203, 26, 167, 32);
		getContentPane().add(lblConsultas);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setBounds(42, 79, 48, 14);
		getContentPane().add(lblFiltro);
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(82, 76, 167, 20);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);
				table.setRowSorter(sorter);
				
				String texto = txtFiltro.getText();
				
				if (texto.length()==0) {
					sorter.setRowFilter(null);
					
				}else {
					
					try {
						sorter.setRowFilter(RowFilter.regexFilter(texto, 2));
						table.setModel(tabela);
					}catch (PatternSyntaxException pse) {
						JOptionPane.showMessageDialog(null, "ERRO");
						// TODO: handle exception
					}
				}
			}
				
		});
		btnBuscar.setBounds(286, 75, 89, 23);
		getContentPane().add(btnBuscar);
		
	}
	public static void main(String[] args) {
		Repositorio repo = null;
		MedicoView  update = new MedicoView(repo);
		
		update.setVisible(true);
		update.setSize(576, 427);
		
		
	}
}
