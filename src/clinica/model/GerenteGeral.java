package clinica.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import clinica.model.dados.Dados;

public class GerenteGeral {
	
	public boolean cadastrarFuncionario(List<Object> obj, String path) {
		return Dados.cadastrar(obj, path);
	}
	
	public boolean criarLoginFuncionario(List<String> atributosLogin) {
		File dir = new File("./" + "\\database");
		String arqLogin = "./database/login.txt";
		
		if(!dir.exists()) {
			boolean sucesso = dir.mkdir();
			
			if(!sucesso) {
				return false;
			}
		}
		
		try (BufferedWriter bwLogin = new BufferedWriter(new FileWriter(arqLogin, true))) {
			for(String atributoLog : atributosLogin) {
				bwLogin.write(atributoLog);
				bwLogin.newLine();
			}
		} catch(IOException e) {
			return false;
		}
		return true;
	}
}
