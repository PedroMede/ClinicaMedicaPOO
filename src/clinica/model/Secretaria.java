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

	public boolean cadastrarObjeto(List<Object> obj, String path, boolean append) {
		return Dados.cadastrar(obj, path, append);
	}
	
	public List<Object> recuperarObjeto(String path) {
		return Dados.recuperar(path);
	}
}
