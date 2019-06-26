package clinica.controller;

import java.util.List;

import clinica.model.Secretaria;

public class ExameController {
	private Secretaria secretaria = new Secretaria();
	
	public boolean cadastrarExame(List<Object> exame, String path) {
		if((this.secretaria.cadastrarObjeto(exame, path))) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Object> recuperarExame(String path) {
		return this.secretaria.recuperarObjeto(path);
	}
}
