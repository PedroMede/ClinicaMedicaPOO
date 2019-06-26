package clinica.controller;

import java.util.ArrayList;
import java.util.List;

import clinica.model.Endereco;
import clinica.model.Funcionario;
import clinica.model.GerenteGeral;
import clinica.model.Pessoa;

public class GerenteController {
	
	private GerenteGeral gerente = new GerenteGeral();
	
	public boolean cadastrarFuncionario(List<Object> funcionarios, String path, List<Object> login) {
		if((gerente.cadastrarFuncionario(funcionarios, path)) && (gerente.cadastrarFuncionario(login, "./database/login.txt"))) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Object> recuperarFuncionario(String path) {
		return gerente.recuperarFuncionario(path);
	}
	
	public static boolean validarDados(List<String> atributos) {
		for(String atributo : atributos) {
			if(atributo == null || atributo.isEmpty()) {
				return false;
			}
		}
		
		return true;
	}
	
	public static List<String> gerarListaAtributos(Object obj) {
		List<String> atributos = new ArrayList<String>();
		
		atributos.add(((Pessoa) obj).getNome());
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
		atributos.add(((Funcionario) obj).getCarteiraTrab());
		atributos.add(((Funcionario) obj).getLogin());
		atributos.add(((Funcionario) obj).getSenha());
		
		return atributos;
	}
}
