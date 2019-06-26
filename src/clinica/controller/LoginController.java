package clinica.controller;

import java.util.List;

import clinica.model.dados.Dados;

public class LoginController {
	
	public List<Object> recuperarLogin(String path){
		return Dados.recuperar(path);
	}
}
