package clinica.model;

import java.io.Serializable;
import java.util.List;

import clinica.model.dados.Dados;

public class Anamnese implements Serializable{

	private static final long serialVersionUID = 1L;
	private Paciente paciente;
	private Medico medico;
	private String prescricao;
	private String sintomas;
	private String diagnosticoDefinitivo;
	private Exame exame;

	
	public Anamnese() {
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDiagnosticoDefinitivo() {
		return diagnosticoDefinitivo;
	}

	public void setDiagnosticoDefinitivo(String diagnosticoDefinitivo) {
		this.diagnosticoDefinitivo = diagnosticoDefinitivo;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}
	
	public List<Object> solicitarExame(String path) {
		return Dados.recuperar(path);
	}
}
