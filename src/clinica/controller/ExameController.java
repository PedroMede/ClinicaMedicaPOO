package clinica.controller;

import java.util.List;

import clinica.model.Anamnese;
import clinica.model.Secretaria;

public class ExameController {
	private Secretaria secretaria = new Secretaria();
	private Anamnese ana = new Anamnese();
	
	public boolean cadastrarExame(List<Object> exame, String path) {
		if((this.secretaria.cadastrarObjeto(exame, path, true))) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Object> recuperarExame(String path) {
		return this.ana.solicitarExame(path);
	}
}
