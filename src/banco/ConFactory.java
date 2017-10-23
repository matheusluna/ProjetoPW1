package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/sisplace";
        String login = "postgres";
        String senha = "123456";
        Class.forName(driver);
		return DriverManager.getConnection(url, login, senha);        
    }
}
