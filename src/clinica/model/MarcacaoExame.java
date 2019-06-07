package clinica.model;

import java.util.Date;

public class MarcacaoExame {
	
	private Exame exame;
	private Date data;
	private String hora;
	private Medico medico;

	public MarcacaoExame() {
	}

	public MarcacaoExame(Exame exame, Date data, String hora, Medico medico) {
		super();
		this.exame = exame;
		this.data = data;
		this.hora = hora;
		this.medico = medico;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}
