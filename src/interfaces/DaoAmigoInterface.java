package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.Amigo;

public interface DaoAmigoInterface {
	public List<Amigo> list(String email) throws ClassNotFoundException, SQLException;
	public boolean create(Amigo amigo) throws ClassNotFoundException, SQLException;
	public Amigo read(String email1, String email2) throws ClassNotFoundException, SQLException;
	public boolean update(Amigo amigo) throws ClassNotFoundException, SQLException;
	public boolean delete(Amigo amigo) throws ClassNotFoundException, SQLException;
}
