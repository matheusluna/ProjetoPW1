package interfaces;

import java.sql.SQLException;

import entidades.Local;

public interface DaoLocalInterface {
	public boolean create(Local local) throws ClassNotFoundException, SQLException;
	public Local read(String nome) throws ClassNotFoundException, SQLException;
	public boolean update(Local local) throws ClassNotFoundException, SQLException;
	public boolean delete(Local local) throws ClassNotFoundException, SQLException;
}
