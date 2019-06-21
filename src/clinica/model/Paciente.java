package clinica.model;

import java.util.Date;

import clinica.model.enums.EtniaEnum;

public class Paciente extends Pessoa {

	private Date dataPrimeiraConsulta;
	private String telefoneAcompanhante;
	private String localNascimento;

	public Paciente(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento, 		//dados de endereço
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, String sexo, EtniaEnum etnia, 	//dados de pessoa
			Date dataPrimeiraConsulta, String telefoneAcompanhante, String localNascimento) {												//dados de paciente
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, anoNascimento, estadoCivil, sexo, etnia);
		this.dataPrimeiraConsulta = dataPrimeiraConsulta;
		this.telefoneAcompanhante = telefoneAcompanhante;
		this.localNascimento = localNascimento;
	}

	public Date getDataPrimeiraConsulta() {
		return dataPrimeiraConsulta;
	}

	public void setDataPrimeiraConsulta(Date dataPrimeiraConsulta) {
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
