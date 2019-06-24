package clinica.model;

import java.io.Serializable;
import java.util.List;

import clinica.model.dados.Dados;
import clinica.model.enums.EtniaEnum;
import clinica.model.enums.SexoEnum;

public class Secretaria extends Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String horaEntrada;
	private String horaSaida;
	
	public Secretaria() {}
	
	public Secretaria(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String complemento,			//dados de endere�o
			String nome, String cpf, String rg, String telefone, String anoNascimento, String estadoCivil, SexoEnum sexo, EtniaEnum etnia,		//dados de pessoa
			String carteiraTrab, String login, String senha,																					//dados de funcionario
			String horaEntrada, String horaSaida) {																								//dados de secretaria
		super(logradouro, numero, cep, bairro, cidade, estado, complemento, nome, cpf, rg, telefone, anoNascimento, estadoCivil, sexo, etnia,
				carteiraTrab, login, senha);
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public boolean marcarConsulta(List<Object> obj, String path) {
		return Dados.cadastrar(obj, path);
	}

	public int descarmarConsulta() {
		//Abrir o arquivo de consultas e deletar a consulta 
		return 1;
	}
	
	public boolean cadastrarPaciente(List<Object> obj, String path) {
		return Dados.cadastrar(obj, path);
	}
	
	public boolean cadastrarExame(List<Object> obj, String path) {
		return Dados.cadastrar(obj, path);
	}

	@Override
	public String toString() {
		return "Secretaria [horaEntrada=" + horaEntrada + ", horaSaida=" + horaSaida + ", getHoraEntrada()="
				+ getHoraEntrada() + ", getHoraSaida()=" + getHoraSaida()  + ", getCarteiraTrab()=" + getCarteiraTrab() + ", getDataAdmissao()=" + getDataAdmissao()
				+ ", getLogin()=" + getLogin() + ", getSenha()=" + getSenha() + ", getPerfilEnum()="
				+ getPerfilEnum() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getRg()=" + getRg()
				+ ", getTelefone()=" + getTelefone() + ", getDataNascimento()=" + getDataNascimento()
				+ ", getEstadoCivil()=" + getEstadoCivil() + ", getSexo()=" + getSexo() + ", getEtnia()=" + getEtnia()
				+ ", getLogradouro()=" + getLogradouro() + ", getNumero()=" + getNumero() + ", getCep()=" + getCep()
				+ ", getBairro()=" + getBairro() + ", getCidade()=" + getCidade() + ", getEstado()=" + getEstado()
				+ ", getComplemento()=" + getComplemento();
	}
}
