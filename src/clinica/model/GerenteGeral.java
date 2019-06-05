package clinica.model;

public class GerenteGeral extends Funcionario {
	
	public GerenteGeral() {
	}
	
	public Secretaria cadastrarSecretaria() {
		return new Secretaria();
	}
	
	public Medico cadastrarMedico() {
		return new Medico();
	}
}
