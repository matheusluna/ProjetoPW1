package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento extends Publicacao{
	private LocalDate dia;
	private LocalTime hora;
	private Pessoa responsavel;
	
	public Evento(int id, String nome, String descricao, String rua, String cidade, String estado,
			LocalDate dia, LocalTime hora, Pessoa responsavel) {
		super(id, nome, descricao, rua, cidade, estado);
		this.dia = dia;
		this.hora = hora;
		this.responsavel = responsavel;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Pessoa getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Pessoa responsavel) {
		this.responsavel = responsavel;
	}	
	
}
