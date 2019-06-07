package clinica.model;

import java.util.Date;

public class Consulta {

	private String hora;
	private Date dia;
	private Medico medico;
	private Paciente paciente;
	private Integer id = 0;

	public Consulta(Date dia, String hora, Medico medico, Paciente paciente) {
        this.hora = hora;
        this.dia = dia;
		this.medico = medico;
		this.paciente = paciente;
		this.id++;
    }

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
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
