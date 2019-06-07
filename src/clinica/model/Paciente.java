package clinica.model;

import java.util.Date;

public class Paciente extends Pessoa {

	private Date dataPrimeiraConsulta;
	private String telefoneAcompanhante;
	private String localNascimento;

	public Paciente(Date dataPrimeiraConsulta, String telefoneAcompanhante, String localNascimento) {
		super();
		this.dataPrimeiraConsulta = dataPrimeiraConsulta;
		this.telefoneAcompanhante = telefoneAcompanhante;
		this.localNascimento = localNascimento;
	}

	public Date getDataPrimeiraConsulta() {
		return dataPrimeiraConsulta;
	}

	public void setDataPrimeiraConsulta(Date dataPrimeiraConsulta) {
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
