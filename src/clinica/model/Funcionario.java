package clinica.model;

import java.io.Serializable;
import java.util.Date;

import clinica.model.enums.EtniaEnum;
import clinica.model.enums.PerfilEnum;
import clinica.model.enums.SexoEnum;

public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String carteiraTrab;
	private Date dataAdmissao;
	private String login;
	private String senha;
	private PerfilEnum perfilEnum;
	
	public Funcionario() {}
	
	public Funcionario(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,			//dados de endere�o
			String nome, String cpf, String rg, String telefone, String dataNascimento, String estadoCivil, SexoEnum sexo, EtniaEnum etnia,		//dados de pessoa
			String carteiraTrab, String login, String senha) {																					//dados de funcionario
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, dataNascimento, estadoCivil, sexo, etnia);
		this.carteiraTrab = carteiraTrab;
		this.login = login;
		this.senha = senha;
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
