package clinica.controller;

import java.util.List;

import clinica.model.Exame;

public class ExameController {
	private Exame exame = new Exame();
	
	public boolean cadastrarExame(List<Object> exame, String path) {
		if((this.exame.cadastrarExame(exame, path))) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Object> recuperarExame(String path) {
		return this.exame.recuperarExames(path);
	}
}
