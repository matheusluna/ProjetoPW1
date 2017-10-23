package interfaces;

import java.sql.SQLException;

import entidades.Publicacao;

public interface DaoPublicacaoInterface {
	public boolean create(Publicacao publicacao) throws ClassNotFoundException, SQLException;
	public Publicacao read(String nome, String descricao, String rua, String cidade, String estado) throws ClassNotFoundException, SQLException;
	public boolean delete(Publicacao publicacao) throws ClassNotFoundException, SQLException;
}
