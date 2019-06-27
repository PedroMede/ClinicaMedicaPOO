package clinica.model;

import java.io.Serializable;

public class Paciente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String dataPrimeiraConsulta;
	private String telefoneAcompanhante;
	private String localNascimento;

	public Paciente() {
	}

	public String getDataPrimeiraConsulta() {
		return dataPrimeiraConsulta;
	}

	public void setDataPrimeiraConsulta(String dataPrimeiraConsulta) {
		this.dataPrimeiraConsulta = dataPrimeiraConsulta;
	}

	public String getTelefoneAcompanhante() {
		return telefoneAcompanhante;
	}

	public void setTelefoneAcompanhante(String telefoneAcompanhante) {
		this.telefoneAcompanhante = telefoneAcompanhante;
	}

	public String getLocalNascimento() {
		return localNascimento;
	}

	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}
}
