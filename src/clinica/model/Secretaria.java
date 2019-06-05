package clinica.model;

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
	
	
}
