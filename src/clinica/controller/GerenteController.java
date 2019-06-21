package clinica.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clinica.model.GerenteGeral;
import clinica.model.Medico;
import clinica.model.Secretaria;
import clinica.model.enums.EspecialidadeEnum;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.PerfilEnum;

public class GerenteController {
	
	private GerenteGeral gerente = new GerenteGeral();
	
	public String cadastrarSecretaria(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, String sexo, EtniaEnum etnia,
			String carteiraTrab, String login, String senha, String horaEntrada, String horaSaida) {
		
		Date dataAdmissao = new Date();
		List<String> atributos = new ArrayList<String>();
		String atributosLogin[] = new String[3];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		atributos.add(nome);
		atributos.add(cpf);
		atributos.add(rg);
		atributos.add(telefone);
		atributos.add(anoNascimento.toString());
		atributos.add(estadoCivil);
		atributos.add(sexo);
		atributos.add(etnia.toString());
		atributos.add(carteiraTrab);
		atributos.add(sdf.format(dataAdmissao));
		atributos.add(logradouro);
		atributos.add(numero.toString());
		atributos.add(cep);
		atributos.add(bairro);
		atributos.add(cidade);
		atributos.add(estado);
		
		atributosLogin[0] = login;
		atributosLogin[1] = senha;
		
		if(!validarDados(atributos, atributosLogin)) {
			return "Alguns atributos estão em branco, tente novamente";
		}
		
		Secretaria sec = new Secretaria(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, anoNascimento, 
				estadoCivil, sexo, etnia, carteiraTrab, dataAdmissao, login, senha, PerfilEnum.ROLE_SECRETARIA, horaEntrada, horaSaida);
		
		
		if(gerente.cadastrarFuncionario(sec, "./database/secretarias.txt")) {
			return "Secretária cadastrada com sucesso";
		} else {
			return "Houve um erro ao cadastrar a secretária, verifique os dados e tente novamente";
		}
	}
	
	public String cadastrarMedico(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, String sexo, EtniaEnum etnia,
			String carteiraTrab, String login, String senha, String crm, String especialidade) {
		
		Date dataAdmissao = new Date();
		List<String> atributos = new ArrayList<String>();
		String atributosLogin[] = new String[3];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		atributos.add(nome);
		atributos.add(cpf);
		atributos.add(rg);
		atributos.add(telefone);
		atributos.add(anoNascimento.toString());
		atributos.add(estadoCivil);
		atributos.add(sexo);
		atributos.add(etnia.toString());
		atributos.add(carteiraTrab);
		atributos.add(sdf.format(dataAdmissao));
		atributos.add(logradouro);
		atributos.add(numero.toString());
		atributos.add(cep);
		atributos.add(bairro);
		atributos.add(cidade);
		atributos.add(estado);
		
		atributosLogin[0] = login;
		atributosLogin[1] = senha;
		
		if(!validarDados(atributos, atributosLogin)) {
			return "Alguns atributos estão em branco, tente novamente";
		}
		
		Medico med = new Medico(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, anoNascimento, 
				estadoCivil, sexo, etnia, carteiraTrab, dataAdmissao, login, senha, PerfilEnum.ROLE_MEDICO,
				crm, EspecialidadeEnum.valueOf(especialidade));
		
		if(gerente.cadastrarFuncionario(med, "./database/medicos.txt")) {
			return "Médico cadastrado com sucesso";
		} else {
			return "Houve um erro ao cadastrar o médico, verifique os dados e tente novamente";
		}
	}
	
	private static boolean validarDados(List<String> dados, String[] dadosLogin) {
		for(String dado : dados) {
			if(dado == null || dado == "") {
				return false;
			}
		}
		for(String dadoLogin : dadosLogin) {
			if(dadoLogin == null || dadoLogin == "") {
				return false;
			}
		}
		
		return true;
	}
}
