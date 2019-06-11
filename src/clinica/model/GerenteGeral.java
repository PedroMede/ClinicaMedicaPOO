package clinica.model;

import java.util.Date;

import clinica.model.enums.EtniaEnum;

public class GerenteGeral extends Funcionario {
	
	public GerenteGeral() {
	}
	
	public Secretaria cadastrar(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, char sexo, EtniaEnum etnia,
			String carteiraTrab, Date dataAdmissao, String login, String senha) {
		return new Secretaria();
	}
	
	public Medico cadastrarMedico() {
		return new Medico();
	}
}
