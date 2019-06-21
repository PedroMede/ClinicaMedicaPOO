package clinica.model;

import java.io.Serializable;

import clinica.model.enums.EspecialidadeEnum;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

public class Medico extends Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String crm;
	private EspecialidadeEnum especialidade;

	public Medico(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,				//dados de endereço
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, SexoEnum sexo, EtniaEnum etnia,		//dados de pessoa
			String carteiraTrab, String login, String senha,																	//dados de funcionario
			String crm/*, EspecialidadeEnum especialidade*/) {
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, anoNascimento, estadoCivil, sexo, etnia,
				carteiraTrab, login, senha);
		this.crm = crm;
		//this.especialidade = especialidade;
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
