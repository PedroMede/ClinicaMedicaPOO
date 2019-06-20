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
	public static String cadastrarSecretaria(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, String sexo, EtniaEnum etnia,
			String carteiraTrab, String login, String senha, String horaEntrada, String horaSaida) {
		
		Secretaria sec = new Secretaria(horaEntrada, horaSaida);
		Date dataAdmissao = new Date();
		List<String> atributos = new ArrayList<String>();
		String atributosLogin[] = new String[3];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		sec.setNome(nome);
		atributos.add(sec.getNome());
		sec.setCpf(cpf);
		atributos.add(sec.getCpf());
		sec.setRg(rg);
		atributos.add(sec.getRg());
		sec.setTelefone(telefone);
		atributos.add(sec.getTelefone());
		sec.setAnoNascimento(anoNascimento);
		atributos.add(sec.getAnoNascimento().toString());
		sec.setEstadoCivil(estadoCivil);
		atributos.add(sec.getEstadoCivil());
		sec.setSexo(sexo);
		atributos.add(sec.getSexo());
		sec.setEtnia(etnia);
		atributos.add(sec.getEtnia().toString());
		sec.setCarteiraTrab(carteiraTrab);
		atributos.add(sec.getCarteiraTrab());
		sec.setDataAdmissao(dataAdmissao);
		atributos.add(sdf.format(sec.getDataAdmissao()));
		sec.setLogradouro(logradouro);
		atributos.add(sec.getLogradouro());
		sec.setNumero(numero);
		atributos.add(sec.getNumero().toString());
		sec.setCep(cep);
		atributos.add(sec.getCep());
		sec.setBairro(bairro);
		atributos.add(sec.getBairro());
		sec.setCidade(cidade);
		atributos.add(sec.getCidade());
		sec.setEstado(estado);
		atributos.add(sec.getEstado());
		sec.setComplemento(complemento);
		atributos.add(sec.getComplemento());
		
		sec.setLogin(login);
		atributosLogin[0] = sec.getLogin();
		sec.setSenha(senha);
		atributosLogin[1] = sec.getSenha();
		sec.setPerfilEnum(PerfilEnum.ROLE_SECRETARIA);
		atributosLogin[2] = sec.getPerfilEnum().toString();
		
		if(GerenteGeral.cadastrarSecretaria(atributos, atributosLogin)) {
			return "Secretária cadastrada com sucesso";
		} else {
			return "Houve um erro ao cadastrar a secretária, verifique os dados e tente novamente";
		}
	}
	
	public static String cadastrarMedico(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, String sexo, EtniaEnum etnia,
			String carteiraTrab, String login, String senha, String crm, String especialidade) {
		
		Medico med = new Medico(crm, EspecialidadeEnum.valueOf(especialidade));
		Date dataAdmissao = new Date();
		List<String> atributos = new ArrayList<String>();
		String atributosLogin[] = new String[3];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		med.setNome(nome);
		atributos.add(med.getNome());
		med.setCpf(cpf);
		atributos.add(med.getCpf());
		med.setRg(rg);
		atributos.add(med.getRg());
		med.setTelefone(telefone);
		atributos.add(med.getTelefone());
		med.setAnoNascimento(anoNascimento);
		atributos.add(med.getAnoNascimento().toString());
		med.setEstadoCivil(estadoCivil);
		atributos.add(med.getEstadoCivil());
		med.setSexo(sexo);
		atributos.add(med.getSexo());
		med.setEtnia(etnia);
		atributos.add(med.getEtnia().toString());
		med.setCarteiraTrab(carteiraTrab);
		atributos.add(med.getCarteiraTrab());
		med.setDataAdmissao(dataAdmissao);
		atributos.add(sdf.format(med.getDataAdmissao()));
		med.setLogradouro(logradouro);
		atributos.add(med.getLogradouro());
		med.setNumero(numero);
		atributos.add(med.getNumero().toString());
		med.setCep(cep);
		atributos.add(med.getCep());
		med.setBairro(bairro);
		atributos.add(med.getBairro());
		med.setCidade(cidade);
		atributos.add(med.getCidade());
		med.setEstado(estado);
		atributos.add(med.getEstado());
		med.setComplemento(complemento);
		atributos.add(med.getComplemento());
		
		med.setLogin(login);
		atributosLogin[0] = med.getLogin();
		med.setSenha(senha);
		atributosLogin[1] = med.getSenha();
		med.setPerfilEnum(PerfilEnum.ROLE_MEDICO);
		atributosLogin[2] = med.getPerfilEnum().toString();
		
		if(GerenteGeral.cadastrarMedico(atributos, atributosLogin)) {
			return "Médico cadastrado com sucesso";
		} else {
			return "Houve um erro ao cadastrar o médico, verifique os dados e tente novamente";
		}
	}
}
