package clinica.model;

import java.io.Serializable;

import clinica.model.enums.PerfilEnum;

public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String carteiraTrab;
	private String dataAdmissao;
	private String login;
	private String senha;
	private PerfilEnum perfilEnum;
	
	public Funcionario() {
	}

	public String getCarteiraTrab() {
		return carteiraTrab;
	}

	public void setCarteiraTrab(String carteiraTrab) {
		this.carteiraTrab = carteiraTrab;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
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
