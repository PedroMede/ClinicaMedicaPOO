package clinica.model;

import java.util.List;

import clinica.model.dados.Dados;

public class GerenteGeral {
	
	public boolean cadastrarFuncionario(List<Object> obj, String path) {
		return Dados.cadastrar(obj, path);
	}
	
	public List<Object> recuperarFuncionario(String path) {
		return Dados.recuperar(path);
	}
}
