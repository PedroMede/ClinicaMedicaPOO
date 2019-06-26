package clinica.model.TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import clinica.model.Exame;
import clinica.model.enums.ExameEnum;

public class ExameTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	private List<Exame> dados = new ArrayList<>();

	// array para os nomes das colunas
	private String[] colunas = {"Codigo","Nome","Obs Geral","Tempo Duração","Tempo Resultado", "Tipo Exame", "Classificação"};
	
	
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	public int getRowCount() {
		// TODO Auto-generated method stub
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
			return dados.get(linha).getCodigo();
			
		case 1:
			return dados.get(linha).getNome();
			
		case 2:
			return dados.get(linha).getObsGeral();
			
		case 3:
			return dados.get(linha).getTempDuracao();
		
		case 4:
			return dados.get(linha).getTempResultado();
			
		case 5:
			return dados.get(linha).getTipoExame();
			
		case 6:
			return dados.get(linha).getClassificacao();

	}
	
	return null;
		
	}
	
	public void setValueAt(Object valor, int linha, int coluna) {
		
		switch (coluna) {
		
		case 0:
			 dados.get(linha).setCodigo(Integer.parseInt((String)valor));
			
		case 1:
			 dados.get(linha).setNome((String)valor);
			
		case 2:
			 dados.get(linha).setObsGeral((String)valor);
			
		case 3:
			 dados.get(linha).setTempDuracao((String)valor);
		
		case 4:
			 dados.get(linha).setTempResultado((String)valor);
			
		case 5:
			 dados.get(linha).setTipoExame((String)valor);
			
		case 6:
			
			 dados.get(linha).setClassificacao(Enum.valueOf(enumType,(String) valor) );

		}
	}
	
	public void addRow(Exame ex) {
		
		// coloca o objto dentro da lista de consulta
		this.dados.add(ex);
		
		//atualiza a tabela
		this.fireTableDataChanged();
		
	}
	
	public void removeRow(int linha) {
		
		dados.remove(linha);
		this.fireTableRowsDeleted(linha , linha);
		
	}
	
	
	

}
