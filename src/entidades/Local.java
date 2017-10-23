package entidades;

import java.time.LocalTime;

public class Local extends Publicacao{
	private String tipo;
	
	public Local(int id, String nome, String descricao, String rua, String cidade, String estado, String tipo) {
		super(id, nome, descricao, rua, cidade, estado);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
