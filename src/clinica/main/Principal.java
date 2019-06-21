package clinica.main;

import clinica.controller.GerenteController;
import clinica.model.Medico;
import clinica.model.Secretaria;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

public class Principal {

	public static void main(String[] args) {
		Secretaria sec = new Secretaria("Rua tal", 32, "38401572", "Pacaembu", "Uberlandia", "MG", "fundos", 
				"Fulano", "12345678911", "121231231", "999999999", 1990, "solteiro", SexoEnum.valueOf("MASCULINO"), EtniaEnum.valueOf("PARDO"), 
				"987654321", "secretaria@teste.com", "123456", "08:00", "14:00");
		
		Medico med = new Medico("Rua tal", 32, "38401572", "Pacaembu", "Uberlandia", "MG", "fundos", 
				"Fulano", "12345678911", "121231231", "999999999", 1990, "solteiro", SexoEnum.valueOf("FEMININO"), EtniaEnum.valueOf("BRANCO"), 
				"987654321", "medico@teste.com", "123456", "4561234");

		GerenteController gerenteController = new GerenteController();
		
		
		System.out.println(gerenteController.cadastrarSecretaria(sec));
		
		System.out.println(gerenteController.cadastrarMedico(med));
	}

}
