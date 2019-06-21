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
		
		Secretaria sec = new Secretaria(horaEntrada, horaSaida);
		
		sec.setNome(nome);
		sec.setCpf(cpf);
		sec.setRg(rg);
		sec.setTelefone(telefone);
		sec.setAnoNascimento(anoNascimento);
		sec.setEstadoCivil(estadoCivil);
		sec.setSexo(sexo);
		sec.setEtnia(etnia);
		sec.setCarteiraTrab(carteiraTrab);
		sec.setDataAdmissao(dataAdmissao);
		sec.setLogradouro(logradouro);
		sec.setNumero(numero);
		sec.setCep(cep);
		sec.setBairro(bairro);
		sec.setCidade(cidade);
		sec.setEstado(estado);
		sec.setComplemento(complemento);
		atributos.add(sec.getComplemento());
		
		sec.setLogin(login);
		sec.setSenha(senha);
		sec.setPerfilEnum(PerfilEnum.ROLE_SECRETARIA);
		atributosLogin[2] = sec.getPerfilEnum().toString();
		
		if(GerenteGeral.cadastrarSecretaria(atributos, atributosLogin)) {
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
		
		Medico med = new Medico(crm, EspecialidadeEnum.valueOf(especialidade));
		
		med.setNome(nome);
		med.setCpf(cpf);
		med.setRg(rg);
		med.setTelefone(telefone);
		med.setAnoNascimento(anoNascimento);
		med.setEstadoCivil(estadoCivil);
		med.setSexo(sexo);
		med.setEtnia(etnia);
		med.setCarteiraTrab(carteiraTrab);
		med.setDataAdmissao(dataAdmissao);
		med.setLogradouro(logradouro);
		med.setNumero(numero);
		med.setCep(cep);
		med.setBairro(bairro);
		med.setCidade(cidade);
		med.setEstado(estado);
		med.setComplemento(complemento);
		atributos.add(med.getComplemento());
		
		med.setLogin(login);
		med.setSenha(senha);
		med.setPerfilEnum(PerfilEnum.ROLE_MEDICO);
		atributosLogin[2] = med.getPerfilEnum().toString();
		
		if(GerenteGeral.cadastrarMedico(atributos, atributosLogin)) {
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
