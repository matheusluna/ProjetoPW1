package entidades;

import java.time.LocalDate;

public class Pessoa {
	private String email;
	private String nome;
	private String cidade;
	private String profissao;
	private LocalDate nascimento;
	private String sexo;
	private String foto;
	private String senha;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Pessoa(String email, String nome, String cidade, String profissao, LocalDate nascimento, String sexo,
			String foto, String senha) {
		super();
		this.email = email;
		this.nome = nome;
		this.cidade = cidade;
		this.profissao = profissao;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.foto = foto;
		this.senha = senha;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean validaUsuario(String senha) {
		if(senha.equals(this.senha)) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
