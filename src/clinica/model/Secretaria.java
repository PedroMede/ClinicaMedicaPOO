package clinica.model;

import java.io.Serializable;
import java.util.List;

import clinica.model.dados.Dados;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.HorarioEnum;
import clinica.model.enums.SexoEnum;

public class Secretaria extends Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	private HorarioEnum horarioTrab;
	
	public Secretaria() {}
	
	public Secretaria(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,			//dados de endere�o
			String nome, String cpf, String rg, String telefone, String anoNascimento, String estadoCivil, SexoEnum sexo, EtniaEnum etnia,		//dados de pessoa
			String carteiraTrab, String login, String senha,																					//dados de funcionario
			HorarioEnum horarioTrab) {																								//dados de secretaria
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, anoNascimento, estadoCivil, sexo, etnia,
				carteiraTrab, login, senha);
		this.horarioTrab = horarioTrab;
	}

	public HorarioEnum getHorarioTrab() {
		return horarioTrab;
	}

	public void setHorarioTrab(HorarioEnum horarioTrab) {
		this.horarioTrab = horarioTrab;
	}

	public boolean cadastrarObjeto(List<Object> obj, String path) {
		return Dados.cadastrar(obj, path);
	}
	
	public List<Object> recuperarObjeto(String path) {
		return Dados.recuperar(path);
	}

	public int descarmarConsulta() {
		//Abrir o arquivo de consultas e deletar a consulta 
		return 1;
	}

	@Override
	public String toString() {
		return "Secretaria [horarioTrab=" + horarioTrab + ", getCarteiraTrab()=" + getCarteiraTrab()
				+ ", getDataAdmissao()=" + getDataAdmissao() + ", getLogin()=" + getLogin() + ", getSenha()="
				+ getSenha() + ", getPerfilEnum()=" + getPerfilEnum() + ", getNome()=" + getNome() + ", getCpf()="
				+ getCpf() + ", getRg()=" + getRg() + ", getTelefone()=" + getTelefone() + ", getDataNascimento()="
				+ getDataNascimento() + ", getEstadoCivil()=" + getEstadoCivil() + ", getSexo()=" + getSexo()
				+ ", getEtnia()=" + getEtnia() + ", getLogradouro()=" + getLogradouro() + ", getNumero()=" + getNumero()
				+ ", getCep()=" + getCep() + ", getBairro()=" + getBairro() + ", getCidade()=" + getCidade()
				+ ", getEstado()=" + getEstado() + ", getComplemento()=" + getComplemento() + "]";
	}

}
