package clinica.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clinica.model.GerenteGeral;
//import clinica.model.Medico;
import clinica.model.Secretaria;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.PerfilEnum;

public class GerenteController {
	public static boolean cadastrarSecretaria(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,
			String nome, String cpf, String rg, String telefone, Integer anoNascimento, String estadoCivil, String sexo, EtniaEnum etnia,
			String carteiraTrab, String login, String senha, String horaEntrada, String horaSaida) {
		
		Secretaria sec = new Secretaria(horaEntrada, horaSaida);
		Date dataAdmissao = new Date();
		List<String> atributos = new ArrayList<String>();
		String atributosLogin[] = new String[3];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		sec.setNome(nome);
		atributos.add(sec.getNome());
		sec.setCpf(cpf);
		atributos.add(sec.getCpf());
		sec.setRg(rg);
		atributos.add(sec.getRg());
		sec.setTelefone(telefone);
		atributos.add(sec.getTelefone());
		sec.setAnoNascimento(anoNascimento);
		atributos.add(sec.getAnoNascimento().toString());
		sec.setEstadoCivil(estadoCivil);
		atributos.add(sec.getEstadoCivil());
		sec.setSexo(sexo);
		atributos.add(sec.getSexo());
		sec.setEtnia(etnia);
		atributos.add(sec.getEtnia().toString());
		sec.setCarteiraTrab(carteiraTrab);
		atributos.add(sec.getCarteiraTrab());
		sec.setDataAdmissao(dataAdmissao);
		atributos.add(sdf.format(sec.getDataAdmissao()));
		sec.setLogradouro(logradouro);
		atributos.add(sec.getLogradouro());
		sec.setNumero(numero);
		atributos.add(sec.getNumero().toString());
		sec.setCep(cep);
		atributos.add(sec.getCep());
		sec.setBairro(bairro);
		atributos.add(sec.getBairro());
		sec.setCidade(cidade);
		atributos.add(sec.getCidade());
		sec.setEstado(estado);
		atributos.add(sec.getEstado());
		sec.setComplemento(complemento);
		atributos.add(sec.getComplemento());
		
		sec.setLogin(login);
		atributosLogin[0] = sec.getLogin();
		sec.setSenha(senha);
		atributosLogin[1] = sec.getSenha();
		sec.setPerfilEnum(PerfilEnum.ROLE_SECRETARIA);
		atributosLogin[2] = sec.getPerfilEnum().toString();
		
		
		
		GerenteGeral.cadastrarSecretaria(atributos, atributosLogin);
		
		return true;
	}
}
