package clinica.model;

public class GerenteGeral extends Funcionario {
	
	public GerenteGeral() {
	}
	
	public static boolean cadastrar(Secretaria sec) {
		
		return true;
	}
	
	public Medico cadastrarMedico() {
		return new Medico();
	}
}
