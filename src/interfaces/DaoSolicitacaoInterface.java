package interfaces;

import java.sql.SQLException;

import entidades.Solicitacao;

public interface DaoSolicitacaoInterface {
	public boolean create(Solicitacao solicitacao) throws ClassNotFoundException, SQLException;
	public Solicitacao read(String emissor, String receptor) throws ClassNotFoundException, SQLException;
	public boolean delete(Solicitacao solicitacao) throws ClassNotFoundException, SQLException;
}
