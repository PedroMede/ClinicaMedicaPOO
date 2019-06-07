package clinica.model;

import java.util.Date;

public class Secretaria extends Funcionario {
	
	private String horaEntrada;
	private String horaSaida;

	public Secretaria() {
	}

	public Secretaria(String horaEntrada, String horaSaida) {
		super();
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public int marcarConsulta(Date dia, String hora, Medico medico, Paciente paciente) {
		Consulta con =  new Consulta(dia, hora, medico, paciente);
		return 1; //Fazer implement��o de salvamento de arquivo;
	}

	public int descarmarConsulta() {
		//Abrir o arquivo de consultas e deletar a consulta 
		return 1;
	}
	
}
