package clinica.controller;

import java.util.Date;

import clinica.model.GerenteGeral;
//import clinica.model.Medico;
import clinica.model.Secretaria;
import clinica.model.enums.EtniaEnum;

public class GerenteController {
	public static boolean cadastrarSecretaria(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, String sexo, EtniaEnum etnia,
			String carteiraTrab, Date dataAdmissao, String login, String senha, String horaEntrada, String horaSaida) {
		
		Secretaria sec = new Secretaria(horaEntrada, horaSaida);
		sec.setLogradouro(logradouro);
		sec.setNumero(numero);
		sec.setCep(cep);
		sec.setBairro(bairro);
		sec.setCidade(cidade);
		sec.setEstado(estado);
		sec.setComplemento(complemento);
		sec.setNome(nome);
		sec.setCpf(cpf);
		sec.setRg(rg);
		sec.setTelefone(telefone);
		sec.setAnoNascimento(anoNascimento);
		sec.setEstadoCivil(estadoCivil);
		sec.setSexo(sexo);
		sec.setEtnia(etnia);
		sec.setCarteiraTrab(carteiraTrab);
		sec.setDataAdmissao(dataAdmissao);
		sec.setLogin(login);
		sec.setSenha(senha);
		
		GerenteGeral.cadastrar(sec);
		
		return true;
	}
}
