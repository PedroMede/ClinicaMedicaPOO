package clinica.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GerenteGeral {

	
	public boolean cadastrarFuncionario(Object obj, String path) {
		File dir = new File("./" + "\\database");
		
		if(!dir.exists()) {
			boolean sucesso = dir.mkdir();
			
			if(!sucesso) {
				return false;
			}
		} 
		
		try(ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream(path))) {
			bw.writeObject(obj);
			bw.flush();
			bw.close();
			
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean criarLoginFuncionario(String[] atributosLogin) {
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
