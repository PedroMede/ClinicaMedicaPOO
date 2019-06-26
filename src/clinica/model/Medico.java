package clinica.model;

import java.io.Serializable;
import java.util.List;

public class Medico extends Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String crm;
	private List<String> especialidade;

	public Medico() {		
	}
	
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<String> getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(List<String> especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return getNome();
	}
}
