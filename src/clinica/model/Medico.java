package clinica.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import clinica.model.enums.EspecialidadeEnum;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

public class Medico extends Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String crm;
	private EspecialidadeEnum especialidade;
	SimpleDateFormat teste = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public Medico(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,				//dados de endereço
			String nome, String cpf, String rg, String telefone, String dataNascimento, String estadoCivil, SexoEnum sexo, EtniaEnum etnia,		//dados de pessoa
			String carteiraTrab, String login, String senha,																					//dados de funcionario
			String crm/*, EspecialidadeEnum especialidade*/) {
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, dataNascimento, estadoCivil, sexo, etnia,
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

	@Override
	public String toString() {
		return "Medico [crm=" + crm + ", especialidade=" + especialidade + ", getCrm()=" + getCrm()
				+ ", getEspecialidade()=" + getEspecialidade() + ", getCarteiraTrab()=" + getCarteiraTrab()
				+ ", getDataAdmissao()=" + teste.format(getDataAdmissao()) + ", getLogin()=" + getLogin() + ", getSenha()="
				+ getSenha() + ", getPerfilEnum()=" + getPerfilEnum() + ", getNome()=" + getNome() + ", getCpf()="
				+ getCpf() + ", getRg()=" + getRg() + ", getTelefone()=" + getTelefone() + ", getAnoNascimento()="
				+ getDataNascimento() + ", getEstadoCivil()=" + getEstadoCivil() + ", getSexo()=" + getSexo()
				+ ", getEtnia()=" + getEtnia() + ", getLogradouro()=" + getLogradouro() + ", getNumero()=" + getNumero()
				+ ", getCep()=" + getCep() + ", getBairro()=" + getBairro() + ", getCidade()=" + getCidade()
				+ ", getEstado()=" + getEstado() + ", getComplemento()=" + getComplemento() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
