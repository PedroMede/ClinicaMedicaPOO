package clinica.controller;

import java.util.ArrayList;
import java.util.List;

import clinica.model.Consulta;
import clinica.model.Endereco;
import clinica.model.Exame;
import clinica.model.Paciente;
import clinica.model.Pessoa;
import clinica.model.Secretaria;

public class SecretariaController {
	
	private Secretaria secretaria = new Secretaria();
	
	public boolean cadastrarObjeto(List<Object> objetos, String path) {
		if(secretaria.cadastrarObjeto(objetos, path)) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Object> recuperarObjeto(String path) {
		return secretaria.recuperarObjeto(path);
	}
	
	public static List<String> gerarListaAtributosPaciente(Object obj) {
		List<String> atributos = new ArrayList<String>();
		
		atributos.add(((Pessoa)obj).getNome());
		atributos.add(((Pessoa) obj).getCpf());
		atributos.add(((Pessoa) obj).getRg());
		atributos.add(((Pessoa) obj).getTelefone());
		atributos.add(((Pessoa) obj).getDataNascimento());
		atributos.add(((Pessoa) obj).getEstadoCivil());
		atributos.add(((Pessoa) obj).getSexo().toString());
		atributos.add(((Pessoa) obj).getEtnia().toString());
		atributos.add(((Endereco) obj).getLogradouro());
		atributos.add(((Endereco) obj).getNumero().toString());
		atributos.add(((Endereco) obj).getCep());
		atributos.add(((Endereco) obj).getBairro());
		atributos.add(((Endereco) obj).getCidade());
		atributos.add(((Endereco) obj).getEstado());
		atributos.add(((Paciente) obj).getTelefoneAcompanhante());
		atributos.add(((Paciente) obj).getLocalNascimento());
		
		return atributos;
	}
	
	public static List<String> gerarListaAtributosExame(Object obj) {
		List<String> atributos = new ArrayList<String>();
		
		atributos.add(((Exame) obj).getCodigo().toString());
		atributos.add(((Exame) obj).getNome());
		atributos.add(((Exame) obj).getObsGeral());
		atributos.add(((Exame) obj).getTempDuracao());
		atributos.add(((Exame) obj).getTempResultado());
		atributos.add(((Exame) obj).getTipoExame());
		atributos.add(((Exame) obj).getClassificacao().toString());
	
		return atributos;
	}
	
	public static List<String> gerarListaAtributosConsulta(Object obj) {
		List<String> atributos = new ArrayList<String>();
		
		atributos.add(((Consulta) obj).getDia());
		atributos.add(((Consulta) obj).getHora());
		atributos.add(((Consulta) obj).getMedico().toString());
		atributos.add(((Consulta) obj).getPaciente().toString());
		
		
		return atributos;
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
