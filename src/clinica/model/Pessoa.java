package clinica.model;

import java.io.Serializable;

import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

public class Pessoa extends Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String rg;
	private String telefone;
	private String dataNascimento;
	private String estadoCivil;
	private SexoEnum sexo;
	private EtniaEnum etnia;
	
	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public EtniaEnum getEtnia() {
		return etnia;
	}
	
	public void setEtnia(EtniaEnum etnia) {
		this.etnia = etnia;
	}
	
	public int cadastrar(String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, char sexo, EtniaEnum etnia,
			String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento) {
		
		return 0;
	}
}
