package entidades;

public class Publicacao {
	private int id;
	private String nome;
	private String descricao;
	private String rua;
	private String cidade;
	private String estado;
	
	public Publicacao(int id, String nome, String descricao, String rua, String cidade, String estado) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
