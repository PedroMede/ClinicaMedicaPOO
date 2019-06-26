package clinica.model.dados;

import java.util.List;

public class Repositorio {
	private List<Object> secretarias;
	private List<Object> medicos;
	private List<Object> pacientes;
	private List<Object> examesCadastrados;
	private List<Object> examesMarcados;
	private List<Object> consultas;
	private List<Object> anamneses;
	private List<Object> login;
	
	public List<Object> getSecretarias() {
		return secretarias;
	}
	
	public void setSecretarias(List<Object> secretarias) {
		this.secretarias = secretarias;
	}
	
	public List<Object> getMedicos() {
		return medicos;
	}
	
	public void setMedicos(List<Object> medicos) {
		this.medicos = medicos;
	}
	
	public List<Object> getPacientes() {
		return pacientes;
	}
	
	public void setPacientes(List<Object> pacientes) {
		this.pacientes = pacientes;
	}
	
	public List<Object> getExamesCadastrados() {
		return examesCadastrados;
	}

	public void setExamesCadastrados(List<Object> examesCadastrados) {
		this.examesCadastrados = examesCadastrados;
	}

	public List<Object> getExamesMarcados() {
		return examesMarcados;
	}

	public void setExamesMarcados(List<Object> examesMarcados) {
		this.examesMarcados = examesMarcados;
	}

	public List<Object> getConsultas() {
		return consultas;
	}
	
	public void setConsultas(List<Object> consultas) {
		this.consultas = consultas;
	}

	public List<Object> getAnamneses() {
		return anamneses;
	}

	public void setAnamneses(List<Object> anamneses) {
		this.anamneses = anamneses;
	}

	public List<Object> getLogin() {
		return login;
	}

	public void setLogin(List<Object> login) {
		this.login = login;
	}
}
