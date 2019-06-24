package clinica.model;

import java.io.Serializable;
import java.util.List;

import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

public class Medico extends Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String crm;
	private List<String> especialidade;

	public Medico() {		
	}
	
	public Medico(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,				//dados de endereço
			String nome, String cpf, String rg, String telefone, String dataNascimento, String estadoCivil, SexoEnum sexo, EtniaEnum etnia,		//dados de pessoa
			String carteiraTrab, String login, String senha,																					//dados de funcionario
			String crm, List<String> especialidade) {
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, dataNascimento, estadoCivil, sexo, etnia,
				carteiraTrab, login, senha);
		this.crm = crm;
		this.especialidade = especialidade;
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
		return "Medico [crm=" + crm + ", especialidade=" + especialidade + ", getCrm()=" + getCrm()
				+ ", getEspecialidade()=" + getEspecialidade() + ", getCarteiraTrab()=" + getCarteiraTrab()
				+ ", getDataAdmissao()=" + getDataAdmissao() + ", getLogin()=" + getLogin() + ", getSenha()="
				+ getSenha() + ", getPerfilEnum()=" + getPerfilEnum() + ", getNome()=" + getNome() + ", getCpf()="
				+ getCpf() + ", getRg()=" + getRg() + ", getTelefone()=" + getTelefone() + ", getAnoNascimento()="
				+ getDataNascimento() + ", getEstadoCivil()=" + getEstadoCivil() + ", getSexo()=" + getSexo()
				+ ", getEtnia()=" + getEtnia() + ", getLogradouro()=" + getLogradouro() + ", getNumero()=" + getNumero()
				+ ", getCep()=" + getCep() + ", getBairro()=" + getBairro() + ", getCidade()=" + getCidade()
				+ ", getEstado()=" + getEstado() + ", getComplemento()=" + getComplemento() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
