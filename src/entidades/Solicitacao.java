package entidades;

public class Solicitacao {
	
	private String emissor;
	private String receptor;
	
	public Solicitacao(String emissor, String receptor) {
		super();
		this.emissor = emissor;
		this.receptor = receptor;
	}
	
	public String getEmissor() {
		return emissor;
	}
	
	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}
	
	public String getReceptor() {
		return receptor;
	}
	
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
	
	
}
