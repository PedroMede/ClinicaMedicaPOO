package clinica.model;

import clinica.model.enums.EtniaEnum;

public class Pessoa extends Endereco {
	
	private String nome;
	private String cpf;
	private String rg;
	private String telefone;
	private Integer anoNascimento;
	private String estadoCivil;
	private String sexo;
	private EtniaEnum etnia;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, String sexo, EtniaEnum etnia) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.anoNascimento = anoNascimento;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.etnia = etnia;
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
	
	public Integer getAnoNascimento() {
		return anoNascimento;
	}
	
	public void setAnoNascimento(Integer anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
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
