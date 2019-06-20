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
		
		if(!validarDados(atributosSec, atributosLogin)) {
			return false;
		}
		
		if(!dir.exists()) {
			boolean sucesso = dir.mkdir();
			
			if(!sucesso) {
				return false;
			}
		} 
		
		String arqSec = "./database/secretarias.txt";
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
	
	public static boolean cadastrarMedico(List<String> atributosMed, String[] atributosLogin) {
		File dir = new File("./" + "\\database");
		
		if(!validarDados(atributosMed, atributosLogin)) {
			return false;
		}
		
		if(!dir.exists()) {
			boolean sucesso = dir.mkdir();
			
			if(!sucesso) {
				return false;
			}
		} 
		
		String arqSec = "./database/medicos.txt";
		String arqLogin = "./database/login.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(arqSec, true))) {
			for(String atributo : atributosMed) {
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
	
	private static boolean validarDados(List<String> dados, String[] dadosLogin) {
		for(String dado : dados) {
			if(dado == null || dado == "") {
				return false;
			}
		}
		for(String dadoLogin : dadosLogin) {
			if(dadoLogin == null || dadoLogin == "") {
				return false;
			}
		}
		
		return true;
	}
}
