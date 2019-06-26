package clinica.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import clinica.controller.ConsultaController;
import clinica.model.Consulta;
import clinica.model.TableModel.ConsultaTableModel;
import clinica.model.dados.Repositorio;
import javax.swing.JFormattedTextField;

public class AtualizarConsultaView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private ConsultaTableModel tabela = new ConsultaTableModel();
	private JTable table;
	private JDateChooser data;
	private JFormattedTextField hora;
	private ConsultaController consultaController = new ConsultaController();
	private List<Object> consultas;
	private List<Object> consultasList = new ArrayList<Object>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public AtualizarConsultaView(Repositorio repo) {
		super("Remarcar/Desmarcar Consulta");
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				consultas = consultaController.recuperarConsultas("./database/consultas.txt");
			
				if(consultas != null) {
					if(repo.getConsultas() == null) {
						repo.setConsultas(consultas);
					} else {
						if(repo.getConsultas().equals(consultas)) {
							repo.setConsultas(consultas);
						} else {
							repo.getConsultas().addAll(consultas);
						}
					}
				}
				for(Object consulta : repo.getConsultas()) {
					tabela.addRow((Consulta) consulta);
				}
				
				JOptionPane.showMessageDialog(null, "Hora e Data são obrigatórias!", "Atualizar Consulta", JOptionPane.INFORMATION_MESSAGE);
			}
			@Override
			public void componentHidden(ComponentEvent e) {
				int linha;
				if(repo.getConsultas() != null) {
					for(linha = repo.getConsultas().size() - 1; linha >= 0 ; linha--) {
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
		pane.setBounds(25, 90, 511, 218);
		getContentPane().add(pane);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio");
		lblHorrio.setBounds(163, 30, 48, 14);
		getContentPane().add(lblHorrio);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow() != -1) {
					try {
						atualizar(repo);
					} catch (DateTimeException dte) {
						JOptionPane.showMessageDialog(null, "Data inválida!", "Erro ao atualizar!", JOptionPane.ERROR_MESSAGE);
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "Data inválida!", "Erro ao atualizar!", JOptionPane.ERROR_MESSAGE);
					} catch (RuntimeException re) {
						JOptionPane.showMessageDialog(null, re.getMessage(), "Erro ao marcar!", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione a linha a ser alterada.");
				}
				
				hora.setText("");
				data.setDate(null);
			}
		});
		
		try {
			hora = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		hora.setBounds(163, 45, 74, 20);
		getContentPane().add(hora);

		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(299, 30, 48, 14);
		getContentPane().add(lblData);
		
		data = new JDateChooser();
		data.setBounds(299, 45, 104, 20);
		getContentPane().add(data);
		
		btnAlterar.setBounds(25, 319, 89, 23);
		getContentPane().add(btnAlterar);
		
		JButton button = new JButton("Deletar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow() != -1) {
					desmarcar(repo);
				}  else {
					JOptionPane.showMessageDialog(null, "Selecione a linha a ser alterada.");
				}
			}
		});
		button.setBounds(447, 319, 89, 23);
		getContentPane().add(button);
	}
	
	private void desmarcar(Repositorio repo) {
		int i;
		for(i = 0; i < repo.getConsultas().size(); i++) {
			Object consulta = repo.getConsultas().get(i);
			if(((Consulta) consulta).getHora().equals(tabela.getValueAt(table.getSelectedRow(), 0))) {
				repo.getConsultas().remove(i);
				tabela.removeRow(i);
			}
		}
		
		System.out.println("teste");
	}
	
	private void atualizar(Repositorio repo) throws ParseException {
		String horaSub = hora.getText().substring(3, 5);
		Date dataAtual = sdf.parse(sdf.format(new Date()));
		Date dataRemarcada = sdf.parse(sdf.format(data.getDate()));

		if(dataRemarcada.before(dataAtual)) {
			throw new DateTimeException(null);
		}
		
		if(!(horaSub.equals("00") || horaSub.equals("30"))) {
			throw new DateTimeException("Horario indisponível");
		}
		
		if(repo.getConsultas() != null) {
			if(marcada(repo.getConsultas())) {
				throw new DateTimeException("Horario indisponível");
			}
			
			int i;
			for(i = 0; i < repo.getConsultas().size(); i++) {
				Object consulta = repo.getConsultas().get(i);
				if(((Consulta) consulta).getHora().equals(tabela.getValueAt(table.getSelectedRow(), 0))) {
					((Consulta) consulta).setHora(hora.getText());
					tabela.setValueAt(((Consulta) consulta).getHora(), table.getSelectedRow(), 0);
				}
				if(((Consulta) consulta).getDia().equals(tabela.getValueAt(table.getSelectedRow(), 1))) {
					((Consulta) consulta).setDia(sdf.format(data.getDate()));
					tabela.setValueAt(((Consulta) consulta).getDia(), table.getSelectedRow(), 0);
				}
				
				consultasList.add(consulta);
				repo.getConsultas().remove(i);
				repo.getConsultas().add(i, consulta);
			}
		}
		
		System.out.println(repo.getConsultas());
		
	}
	
	private boolean marcada(List<Object> consultas) {
		for(Object consulta : consultas) {
			if(((Consulta) consulta).getHora().equals(hora.getText()) && ((Consulta) consulta).getDia().equals(sdf.format(data.getDate()))) {
				return true;
			}
		}
		
		return false;
	}
}
