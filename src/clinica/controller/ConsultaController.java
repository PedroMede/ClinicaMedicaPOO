package clinica.controller;

import java.util.List;

import clinica.model.Consulta;

public class ConsultaController {
	private Consulta consulta = new Consulta();
	
	public boolean cadastrarConsulta(List<Object> consultas, String path) {
		if((consulta.cadastrarConsulta(consultas, path))) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Object> recuperarConsultas(String path) {
		return consulta.recuperarConsultas(path);
	}
}
