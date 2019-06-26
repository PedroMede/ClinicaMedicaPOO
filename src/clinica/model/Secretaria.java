package clinica.model;

import java.io.Serializable;
import java.util.List;

import clinica.model.dados.Dados;
import clinica.model.enums.HorarioEnum;

public class Secretaria extends Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	private HorarioEnum horarioTrab;
	
	public Secretaria() {
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
