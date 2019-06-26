package clinica.model;

import java.util.List;

import clinica.model.dados.Dados;
import clinica.model.enums.ExameEnum;

public class Exame {
	
	private Integer codigo;
	private String nome;
	private String obsGeral;
	private String tempDuracao;
	private String tempResultado;	
	private ExameEnum classificacao;

	public Exame() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObsGeral() {
		return obsGeral;
	}

	public void setObsGeral(String obsGeral) {
		this.obsGeral = obsGeral;
	}

	public String getTempDuracao() {
		return tempDuracao;
	}

	public void setTempDuracao(String tempDuracao) {
		this.tempDuracao = tempDuracao;
	}

	public String getTempResultado() {
		return tempResultado;
	}

	public void setTempResultado(String tempResultado) {
		this.tempResultado = tempResultado;
	}

	public ExameEnum getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ExameEnum classificacao) {
		this.classificacao = classificacao;
	}
	
	public boolean cadastrarExame(List<Object> exames, String path) {
		return Dados.cadastrar(exames, path);
	}
	
	public List<Object> recuperarExames(String path) {
		return Dados.recuperar(path);
	}
}
