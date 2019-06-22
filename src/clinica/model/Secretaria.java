package clinica.model;

import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

public class Secretaria extends Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String horaEntrada;
	private String horaSaida;
	
	public Secretaria() {}
	
	public Secretaria(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,			//dados de endere�o
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, SexoEnum sexo, EtniaEnum etnia,		//dados de pessoa
			String carteiraTrab, String login, String senha,																					//dados de funcionario
			String horaEntrada, String horaSaida) {																								//dados de secretaria
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, anoNascimento, estadoCivil, sexo, etnia,
				carteiraTrab, login, senha);
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
		return 1; //Fazer implement��o de salvamento de arquivo;
	}

	public int descarmarConsulta() {
		//Abrir o arquivo de consultas e deletar a consulta 
		return 1;
	}
	
	public boolean cadastrarPaciente(Object obj, String path) {
		File dir = new File("./" + "\\database");
		
		if(!dir.exists()) {
			boolean sucesso = dir.mkdir();
			
			if(!sucesso) {
				return false;
			}
		} 
		
		try (ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream(path, true))) {
			bw.writeObject(obj);
			bw.flush();
			bw.close();
			
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean cadastrarExame(Object obj, String path) {
		
		File dir = new File("./" + "\\database");
		
		if(!dir.exists()) {
			boolean sucesso = dir.mkdir();
			
			if(!sucesso) {
				return false;
			}
		} 
		
		try (ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream(path, true))) {
			bw.writeObject(obj);
			bw.flush();
			bw.close();
			
		} catch(Exception e) {
			return false;
		}
		return true;
		
	}
	
}
