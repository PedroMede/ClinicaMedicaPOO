package clinica.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clinica.model.GerenteGeral;
import clinica.model.Medico;
import clinica.model.Secretaria;
import clinica.model.enums.PerfilEnum;

public class GerenteController {
	
	private GerenteGeral gerente = new GerenteGeral();
	
	public String cadastrarSecretaria(Secretaria sec) {
		
		Date dataAdmissao = new Date();
		List<String> atributos = new ArrayList<String>();
		String atributosLogin[] = new String[3];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		sec.setDataAdmissao(dataAdmissao);
		sec.setPerfilEnum(PerfilEnum.ROLE_SECRETARIA);
		
		atributos.add(sec.getNome());
		atributos.add(sec.getCpf());
		atributos.add(sec.getRg());
		atributos.add(sec.getTelefone());
		atributos.add(sec.getAnoNascimento().toString());
		atributos.add(sec.getEstadoCivil());
		atributos.add(sec.getSexo().toString());
		atributos.add(sec.getEtnia().toString());
		atributos.add(sec.getCarteiraTrab());
		atributos.add(sdf.format(sec.getDataAdmissao()));
		atributos.add(sec.getLogradouro());
		atributos.add(sec.getNumero().toString());
		atributos.add(sec.getCep());
		atributos.add(sec.getBairro());
		atributos.add(sec.getCidade());
		atributos.add(sec.getEstado());
		atributos.add(sec.getLogin());
		atributos.add(sec.getSenha());		
		
		atributosLogin[0] = sec.getLogin();
		atributosLogin[1] = sec.getSenha();
		atributosLogin[2] = sec.getPerfilEnum().toString();
		
		if(!validarDados(atributos)) {
			return "Alguns atributos estão em branco, tente novamente";
		}
		
		if(gerente.cadastrarFuncionario(sec, "./database/secretarias.txt") && gerente.criarLoginFuncionario(atributosLogin)) {
			return "Secretária cadastrada com sucesso";
		} else {
			return "Houve um erro ao cadastrar a secretária,  tente novamente em alguns minutos";
		}
	}
	
	public String cadastrarMedico(Medico med) {
		
		Date dataAdmissao = new Date();
		List<String> atributos = new ArrayList<String>();
		String atributosLogin[] = new String[3];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		med.setDataAdmissao(dataAdmissao);
		med.setPerfilEnum(PerfilEnum.ROLE_MEDICO);
		
		atributos.add(med.getNome());
		atributos.add(med.getCpf());
		atributos.add(med.getRg());
		atributos.add(med.getTelefone());
		atributos.add(med.getAnoNascimento().toString());
		atributos.add(med.getEstadoCivil());
		atributos.add(med.getSexo().toString());
		atributos.add(med.getEtnia().toString());
		atributos.add(med.getCarteiraTrab());
		atributos.add(sdf.format(med.getDataAdmissao()));
		atributos.add(med.getLogradouro());
		atributos.add(med.getNumero().toString());
		atributos.add(med.getCep());
		atributos.add(med.getBairro());
		atributos.add(med.getCidade());
		atributos.add(med.getEstado());
		atributos.add(med.getLogin());
		atributos.add(med.getSenha());
		
		atributosLogin[0] = med.getLogin();
		atributosLogin[1] = med.getSenha();
		atributosLogin[2] = med.getPerfilEnum().toString();
		
		if(!validarDados(atributos)) {
			return "Alguns atributos estão em branco, tente novamente";
		}
		
		if(gerente.cadastrarFuncionario(med, "./database/medicos.txt") && gerente.criarLoginFuncionario(atributosLogin)) {
			return "Médico cadastrado com sucesso";
		} else {
			return "Houve um erro ao cadastrar o médico, verifique os dados e tente novamente";
		}
	}
	
	private static boolean validarDados(List<String> dados) {
		for(String dado : dados) {
			if(dado == null || dado == "") {
				return false;
			}
		}
		
		return true;
	}
}
