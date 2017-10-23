package interfaces;

import java.sql.SQLException;

import entidades.Evento;

public interface DaoEventoInterface {
	public boolean create(Evento evento) throws ClassNotFoundException, SQLException;
	public Evento read(String nome) throws ClassNotFoundException, SQLException;
	public boolean delete(Evento evento) throws ClassNotFoundException, SQLException;
}
