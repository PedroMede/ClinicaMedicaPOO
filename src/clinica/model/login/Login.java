package clinica.model.login;

import java.io.Serializable;

public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String senha;
	private String perfil;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Login [usuario=" + usuario + ", senha=" + senha + ", perfil=" + perfil + "]";
	}
}
