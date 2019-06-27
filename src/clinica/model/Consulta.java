package clinica.model;

import java.io.Serializable;

public class Consulta implements Serializable{

	private static final long serialVersionUID = 1L;
	private String hora;
	private String dia;
	private Medico medico;
	private Paciente paciente;
	
	public Consulta() {
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
