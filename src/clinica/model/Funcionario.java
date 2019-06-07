package clinica.model;

import java.util.Date;

public class Funcionario extends Pessoa {
	
	private String carteiraTrab;
	private Date dataAdmissao;
	private String login;
	private String senha;
	
	public Funcionario() {
	}

	public Funcionario(String carteiraTrab, Date dataAdmissao, String login, String senha) {
		super();
		this.carteiraTrab = carteiraTrab;
		this.dataAdmissao = dataAdmissao;
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
	
	
}
