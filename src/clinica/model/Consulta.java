package clinica.model;

public class Consulta {

	private Integer id;
	private String hora;
	private String dia;
	private Medico medico;
	private Paciente paciente;
	
	
	public Consulta () {};
	public Consulta(String dia, String hora, Medico medico, Paciente paciente) {
        this.hora = hora;
        this.dia = dia;
		this.medico = medico;
		this.paciente = paciente;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
