package clinica.model.TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import clinica.model.Consulta;

public class ConsultaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Consulta> dados = new ArrayList<>();

	// array para os nomes das colunas
	private String[] colunas = {"Hora","Dia","Medico","Paciente"};
	
	
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
			case 0:
				return dados.get(linha).getHora();
				
			case 1:
				return dados.get(linha).getDia();
				
			case 2:
				return dados.get(linha).getMedico();
				
			case 3:
				return dados.get(linha).getPaciente();
		}
	
	return null;
		
	}
	
	public void setValueAt(Object valor, int linha, int coluna) {
		
		switch (coluna) {	
		case 1:
			 dados.get(linha).setHora((String)valor);
			 break;
		case 2:
			 dados.get(linha).setDia((String)valor);
			 break;
		case 3:			 
			 dados.get(linha).getMedico().setNome((String)valor);
			 break;
		case 4:
			 dados.get(linha).getPaciente().setNome((String)valor);
			 break;
		}
	}
	
	public void addRow(Consulta con) {
		
		// coloca o objto dentro da lista de consulta
		this.dados.add(con);
		
		//atualiza a tabela
		this.fireTableDataChanged();
		
	}
	
	public void removeRow(int linha) {
		
		dados.remove(linha);
		this.fireTableRowsDeleted(linha , linha);
		
	}
	

}
