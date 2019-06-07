package clinica.model;

import clinica.model.enums.ExameEnum;

public class Exame {
	
	private Integer codigo;
	private String nome;
	private String obsGeral;
	private String tempDuracao;
	private String tempResultado;	
	private String tipoExame;
	private ExameEnum classificacao;

	public Exame() {
	}

	public Exame(Integer codigo, String nome, String obsGeral, String tempDuracao, String tempResultado, String tipoExame, ExameEnum classificacao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.obsGeral = obsGeral;
		this.tempDuracao = tempDuracao;
		this.tempResultado = tempResultado;
		this.tipoExame = tipoExame;
		this.classificacao = classificacao;
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

	public String getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

	public ExameEnum getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ExameEnum classificacao) {
		this.classificacao = classificacao;
	}
}
