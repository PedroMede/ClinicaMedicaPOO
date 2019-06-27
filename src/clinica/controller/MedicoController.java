package clinica.controller;

import java.util.ArrayList;
import java.util.List;

import clinica.model.Anamnese;
import clinica.model.Medico;

public class MedicoController {

	private Medico medico = new Medico();
	
	public boolean cadastrarObjeto(List<Object> objetos, String path) {
		if(medico.cadastrarAnamnese(objetos, path)) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Object> recuperarObjeto(String path) {
		return medico.recuperarAnamnese(path);
	}
	
	public static List<String> gerarListaAtributos(Object obj) {
		List<String> atributos = new ArrayList<String>();
		
		atributos.add(((Anamnese) obj).getDiagnosticoDefinitivo());
		atributos.add(((Anamnese) obj).getPrescricao());
		atributos.add(((Anamnese) obj).getSintomas());
		atributos.add(((Anamnese) obj).getMedico().getNome());
		atributos.add(((Anamnese) obj).getPaciente().getNome());
		atributos.add(((Anamnese) obj).getExame().getNome());
	
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
