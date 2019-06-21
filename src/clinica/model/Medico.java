package clinica.model;

import java.io.Serializable;

import clinica.model.enums.EspecialidadeEnum;

public class Medico extends Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String crm;
	private EspecialidadeEnum especialidade;

	public Medico() {
		super();
	}

	public Medico(String crm, EspecialidadeEnum especialidade) {
		super();
		this.crm = crm;
		this.especialidade = especialidade;
	}
	
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public EspecialidadeEnum getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(EspecialidadeEnum especialidade) {
		this.especialidade = especialidade;
	}
}
