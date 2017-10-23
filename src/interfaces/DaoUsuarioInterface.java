package interfaces;

import java.sql.SQLException;

import entidades.Pessoa;

public interface DaoUsuarioInterface {
	public boolean create(Pessoa pessoa) throws ClassNotFoundException, SQLException;
	public Pessoa read(String email) throws ClassNotFoundException, SQLException;
	public boolean update(Pessoa pessoa) throws ClassNotFoundException, SQLException;
	public boolean delete(Pessoa pessoa) throws ClassNotFoundException, SQLException;
}
