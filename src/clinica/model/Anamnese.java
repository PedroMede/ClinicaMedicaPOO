package clinica.model;

public class Anamnese {
	
	private Paciente paciente;
	private Medico medico;
	private String prescricao;
	private String sintomas;
	private String diagnosticoDefinitivo;

	
	public Anamnese() {
	}

	public Anamnese(Paciente paciente, Medico medico, String prescricao, String sintomas, String diagnosticoDefinitivo) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.prescricao = prescricao;
		this.sintomas = sintomas;
		this.diagnosticoDefinitivo = diagnosticoDefinitivo;
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
}
