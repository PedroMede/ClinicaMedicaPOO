package clinica.controller;

import java.util.ArrayList;
import java.util.List;

import clinica.model.Consulta;
import clinica.model.Secretaria;

public class ConsultaController {
	private Secretaria secretaria = new Secretaria();
	
	public boolean cadastrarConsulta(List<Object> consultas, String path) {
		if((secretaria.cadastrarObjeto(consultas, path))) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Object> recuperarConsultas(String path) {
		return secretaria.recuperarObjeto(path);
	}
	
	public static List<String> gerarListaAtributosConsulta(Object obj) {
		List<String> atributos = new ArrayList<String>();
		
		atributos.add(((Consulta) obj).getDia());
		atributos.add(((Consulta) obj).getHora());
		atributos.add(((Consulta) obj).getMedico().toString());
		atributos.add(((Consulta) obj).getPaciente().toString());
		
		
		return atributos;
	}
	
	public static boolean validarDados(List<String> dados) {
		for(String dado : dados) {
			if(dado == null || dado.isEmpty()) {
				return false;
			}
		}	
		return true;
	}
}
