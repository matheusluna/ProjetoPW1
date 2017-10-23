package entidades;

public class Amigo {
	private String pessoa1;
	private String pessoa2;
	
	public Amigo(String pessoa1, String pessoa2) {
		this.pessoa1 = pessoa1;
		this.pessoa2 = pessoa2;
	}

	public String getPessoa1() {
		return pessoa1;
	}

	public void setPessoa1(String pessoa1) {
		this.pessoa1 = pessoa1;
	}

	public String getPessoa2() {
		return pessoa2;
	}

	public void setPessoa2(String pessoa2) {
		this.pessoa2 = pessoa2;
	}
	
	
}
