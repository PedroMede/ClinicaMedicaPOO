package clinica.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clinica.model.Paciente;
import clinica.model.Secretaria;

public class SecretariaController {
	
	private Secretaria secretaria = new Secretaria();
	
	public String cadastrarPaciente(Paciente pac) {
		
		Date dtPrimeiraCon = new Date();
		List<String> atributos = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		pac.setDataPrimeiraConsulta(dtPrimeiraCon);
		
		atributos.add(pac.getNome());
		atributos.add(pac.getCpf());
		atributos.add(pac.getRg());
		atributos.add(pac.getTelefone());
		atributos.add(pac.getAnoNascimento().toString());
		atributos.add(pac.getEstadoCivil());
		atributos.add(pac.getSexo().toString());
		atributos.add(pac.getEtnia().toString());
		atributos.add(pac.getLogradouro());
		atributos.add(pac.getNumero().toString());
		atributos.add(pac.getCep());
		atributos.add(pac.getBairro());
		atributos.add(pac.getCidade());
		atributos.add(pac.getEstado());
		
		atributos.add(sdf.format(pac.getDataPrimeiraConsulta()));
		atributos.add(pac.getTelefoneAcompanhante());
		atributos.add(pac.getLocalNascimento());
			
			

		if(!validarDados(atributos)) {
			return "Alguns atributos est�o em branco, tente novamente";
		}
		
		if(secretaria.cadastrarPaciente(pac, "./database/paciente.txt") ) {
			return "Paciente cadastrado com sucesso";
		} else {
			return "Houve um erro ao cadastrar o Paciente, verifique os dados e tente novamente";
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
