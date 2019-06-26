package clinica.model;

import java.io.Serializable;

import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

public class Paciente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String dataPrimeiraConsulta;
	private String telefoneAcompanhante;
	private String localNascimento;

	public Paciente() {
	}
	
	public Paciente(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento, 			//dados de endereço
			String nome, String cpf, String rg, String telefone, String anoNascimento, String estadoCivil, SexoEnum sexo, EtniaEnum etnia, 		//dados de pessoa
			String telefoneAcompanhante, String localNascimento) {																				//dados de paciente
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, anoNascimento, estadoCivil, sexo, etnia);
		this.telefoneAcompanhante = telefoneAcompanhante;
		this.localNascimento = localNascimento;
	}

	public String getDataPrimeiraConsulta() {
		return dataPrimeiraConsulta;
	}

	public void setDataPrimeiraConsulta(String dataPrimeiraConsulta) {
		this.dataPrimeiraConsulta = dataPrimeiraConsulta;
	}

	public String getTelefoneAcompanhante() {
		return telefoneAcompanhante;
	}

	public void setTelefoneAcompanhante(String telefoneAcompanhante) {
		this.telefoneAcompanhante = telefoneAcompanhante;
	}

	public String getLocalNascimento() {
		return localNascimento;
	}

	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}
	
	
}
