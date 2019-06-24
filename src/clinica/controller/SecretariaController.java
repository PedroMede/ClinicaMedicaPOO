package clinica.controller;

import java.util.ArrayList;
import java.util.List;

import clinica.model.Consulta;
import clinica.model.Exame;
import clinica.model.Paciente;
import clinica.model.Secretaria;

public class SecretariaController {
	
	private Secretaria secretaria = new Secretaria();
	
	/*public boolean cadastrarPaciente(Paciente pac) {
		List<String> atributos = new ArrayList<String>();
		
		atributos.add(pac.getNome());
		atributos.add(pac.getCpf());
		atributos.add(pac.getRg());
		atributos.add(pac.getTelefone());
		atributos.add(pac.getDataNascimento());
		atributos.add(pac.getEstadoCivil());
		atributos.add(pac.getSexo().toString());
		atributos.add(pac.getEtnia().toString());
		atributos.add(pac.getLogradouro());
		atributos.add(pac.getNumero().toString());
		atributos.add(pac.getCep());
		atributos.add(pac.getBairro());
		atributos.add(pac.getCidade());
		atributos.add(pac.getEstado());
		atributos.add(pac.getDataPrimeiraConsulta());
		atributos.add(pac.getTelefoneAcompanhante());
		atributos.add(pac.getLocalNascimento());

		if(!validarDados(atributos)) {
			return false;
		}
		
		if(secretaria.cadastrarPaciente(pac, "./database/pacientes.txt")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean cadastrarExame(Exame exam) {
		List<String> atributos = new ArrayList<String>();
		
		atributos.add(exam.getCodigo().toString());
		atributos.add(exam.getNome());
		atributos.add(exam.getObsGeral());
		atributos.add(exam.getTempDuracao());
		atributos.add(exam.getTempResultado());
		atributos.add(exam.getTipoExame());
		atributos.add(exam.getClassificacao().toString());
		
		if(!validarDados(atributos)) {
			return false;
		}
		
		if(secretaria.cadastrarExame(exam, "./database/exames.txt") ) {
			return true;
		} else {
			return false;
		}
	
	}
	
	public boolean marcarConsulta(Consulta con) {
		List<String> atributos = new ArrayList<String>();
		
		atributos.add(con.getDia());
		atributos.add(con.getHora());
		atributos.add(con.getMedico().toString());
		atributos.add(con.getPaciente().toString());
		
		
		return true;
	}
	
	private static boolean validarDados(List<String> dados) {
		for(String dado : dados) {
			if(dado == null || dado.isEmpty()) {
				return false;
			}
		}	
		return true;
	}*/
}
