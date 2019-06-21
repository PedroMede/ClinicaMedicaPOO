package clinica.model;

import java.io.Serializable;
import java.util.Date;

import clinica.model.enums.EtniaEnum;
import clinica.model.enums.PerfilEnum;

public class Secretaria extends Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String horaEntrada;
	private String horaSaida;

	public Secretaria(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,			//dados de endereço
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, String sexo, EtniaEnum etnia,		//dados de pessoa
			String carteiraTrab, Date dataAdmissao, String login, String senha,	PerfilEnum perfilEnum,											//dados de funcionario
			String horaEntrada, String horaSaida) {																								//dados de secretaria
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, anoNascimento, estadoCivil, sexo, etnia,
				carteiraTrab, dataAdmissao, login, senha, perfilEnum);
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
		//Consulta con =  new Consulta(dia, hora, medico, paciente);
		return 1; //Fazer implementï¿½ï¿½o de salvamento de arquivo;
	}

	public int descarmarConsulta() {
		//Abrir o arquivo de consultas e deletar a consulta 
		return 1;
	}
}
