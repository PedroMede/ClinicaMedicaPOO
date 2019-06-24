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
	
	/*public boolean cadastrarSecretaria(List<Object> list) {
		Secretaria sec = new Secretaria();
		Date dataAdmissao = new Date();
		List<String> atributos = new ArrayList<String>();
		String atributosLogin[] = new String[3];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		sec.setDataAdmissao(sdf.format(dataAdmissao));
		sec.setPerfilEnum(PerfilEnum.ROLE_SECRETARIA);
		
		atributos.add(sec.getNome());
		atributos.add(sec.getCpf());
		atributos.add(sec.getRg());
		atributos.add(sec.getTelefone());
		atributos.add(sec.getDataNascimento());
		atributos.add(sec.getEstadoCivil());
		atributos.add(sec.getSexo().toString());
		atributos.add(sec.getEtnia().toString());
		atributos.add(sec.getCarteiraTrab());
		atributos.add(sec.getDataAdmissao());
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
			return false;
		}
		
		if(gerente.cadastrarFuncionario(sec, "./database/secretarias.txt") && gerente.criarLoginFuncionario(atributosLogin)) {
			return true;
		} else {
			return false;
		}
	}*/
	
	public boolean cadastrarMedico(List<Object> medicos) {
		List<String> atributos = new ArrayList<String>();
		
		for(Object medico : medicos) {
			atributos.add(((Medico) medico).getLogin());
			atributos.add(((Medico)medico).getSenha());
			atributos.add(((Medico)medico).getPerfilEnum().toString());
		}
		
		if(gerente.cadastrarFuncionario(medicos, "./database/medicos.txt") && gerente.criarLoginFuncionario(atributos)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validarDados(List<String> dados) {
		for(String dado : dados) {
			if(dado == null || dado.isEmpty()) {
				return false;
			}
		}
		
		return true;
	}
}
