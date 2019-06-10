package clinica.model;

import clinica.model.enums.EspecialidadeEnum;

public class Medico extends Pessoa {
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

	public Medico(String crm, EspecialidadeEnum especialidade, String carteiraTrab, Date dataAdmissao, String login, String senha) {
		super(carteiraTrab, dataAdmissao, login, senha);
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
