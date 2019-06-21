package clinica.model;

import java.util.Date;

import clinica.model.enums.EtniaEnum;
import clinica.model.enums.PerfilEnum;
import clinica.model.enums.SexoEnum;

public class Funcionario extends Pessoa {
	
	private String carteiraTrab;
	private Date dataAdmissao;
	private String login;
	private String senha;
	private PerfilEnum perfilEnum;

	public Funcionario(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,			//dados de endereço
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, SexoEnum sexo, EtniaEnum etnia,		//dados de pessoa
			String carteiraTrab, Date dataAdmissao, String login, String senha, PerfilEnum perfilEnum) {										//dados de funcionario
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, anoNascimento, estadoCivil, sexo, etnia);
		this.carteiraTrab = carteiraTrab;
		this.dataAdmissao = dataAdmissao;
		this.login = login;
		this.senha = senha;
		this.perfilEnum = perfilEnum;
	}

	public String getCarteiraTrab() {
		return carteiraTrab;
	}

	public void setCarteiraTrab(String carteiraTrab) {
		this.carteiraTrab = carteiraTrab;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PerfilEnum getPerfilEnum() {
		return perfilEnum;
	}

	public void setPerfilEnum(PerfilEnum perfilEnum) {
		this.perfilEnum = perfilEnum;
	}
	
}
