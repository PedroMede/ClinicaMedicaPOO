package clinica.main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import clinica.controller.GerenteController;
import clinica.controller.SecretariaController;
import clinica.model.Medico;
import clinica.model.Paciente;
import clinica.model.Secretaria;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

public class Principal {

	public static void main(String[] args) {
		/*Secretaria sec = new Secretaria("Rua tal", 32, "38401572", "Pacaembu", "Uberlandia", "MG", "fundos", 
				"Fulano", "12345678911", "121231231", "999999999", "xx/xx/xxxx", "solteiro", SexoEnum.valueOf("MASCULINO"), EtniaEnum.valueOf("PARDO"), 
				"987654321", "secretaria@teste.com", "123456", "08:00", "14:00");
		
		Medico med = new Medico("Rua tal", 32, "38401572", "Pacaembu", "Uberlandia", "MG", "fundos", 
				"Fulano", "12345678911", "121231231", "999999999", "xx/xx/xxxx", "solteiro", SexoEnum.MASCULINO, EtniaEnum.BRANCO, 
				"987654321", "medico@teste.com", "123456", "4561234");
		
		/*Paciente pac = new Paciente("logradouro", 32, "cep", "bairro", "cidade", "estado", "complemento", "nome", "cpf",
				"rg", "telefone", "xx/xx/xxxx", "estadoCivil", SexoEnum.valueOf("MASCULINO"), EtniaEnum.valueOf("PARDO"),
				"teset", "teste");
		
		
		GerenteController gerenteController = new GerenteController();
		//SecretariaController secretariaController = new SecretariaController();
		
		//System.out.println(secretariaController.cadastrarPaciente(pac));

		//System.out.println(gerenteController.cadastrarSecretaria(sec));
		
		System.out.println(gerenteController.cadastrarMedico(med));*/
		
		System.out.println("Recuperando objeto: ");
		try {
			FileInputStream fis = new FileInputStream("./database/secretarias.txt");
			ObjectInputStream objLeitura = new ObjectInputStream(fis);
				Object obj = objLeitura.readObject();
				System.out.println(obj);
			
			objLeitura.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
