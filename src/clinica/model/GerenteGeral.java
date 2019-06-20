package clinica.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GerenteGeral extends Funcionario {
	
	public GerenteGeral() {
	}
	
	public static boolean cadastrarSecretaria(List<String> atributosSec, String[] atributosLogin) {
		File dir = new File("./" + "\\database");
		
		if(!dir.exists()) {
			boolean sucesso = dir.mkdir();
			
			if(!sucesso) {
				return false;
			}
		} 
		
		String arqSec = "./database/secretaria.txt";
		String arqLogin = "./database/login.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(arqSec, true))) {
			for(String atributo : atributosSec) {
				bw.write(atributo);
				bw.newLine();
			}
			
			try (BufferedWriter bwLogin = new BufferedWriter(new FileWriter(arqLogin, true))) {
				for(String atributoLog : atributosLogin) {
					bw.write(atributoLog);
					bw.newLine();
				}
			} catch(IOException e) {
				return false;
			}
			
		} catch(IOException e) {
			return false;
		}
		
		return true;
		
	}
	
	public Medico cadastrarMedico() {
		return new Medico();
	}
}
