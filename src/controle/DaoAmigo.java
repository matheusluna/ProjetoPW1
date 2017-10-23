package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.ConFactory;
import entidades.Amigo;
import interfaces.DaoAmigoInterface;

public class DaoAmigo implements DaoAmigoInterface{

	@Override
	public List<Amigo> list(String email) throws ClassNotFoundException, SQLException {
		List<Amigo> lista = new ArrayList<>();
		Connection con = new ConFactory().getConnection();
		String sql = "select a.pessoa2 as amigo from amigo a where a.pessoa1 = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Amigo amigo = new Amigo(email, rs.getString("amigo"));
			lista.add(amigo);
		}
		stmt.close();
		con.close();
		return lista;
	}

	@Override
	public boolean create(Amigo amigo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Amigo> lista = list(amigo.getPessoa1());
		for(Amigo a : lista) {
			if(a.getPessoa1().equals(amigo.getPessoa1()) && a.getPessoa2().equals(amigo.getPessoa2())) {
				return false;
			}
		}
		
		Connection con = new ConFactory().getConnection();
		String sql = "insert into amigo values(?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, amigo.getPessoa1());
		stmt.setString(2, amigo.getPessoa2());
		boolean resultado = !stmt.execute();
		stmt.close();
		con.close();
		return resultado;
	}

	@Override
	public Amigo read(String email1, String email2) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Amigo> lista = list(email1);
		for(Amigo a : lista) {
			if(a.getPessoa1().equals(email1) && a.getPessoa2().equals(email2)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public boolean update(Amigo amigo) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean delete(Amigo amigo) throws ClassNotFoundException, SQLException {
		List<Amigo> lista = list(amigo.getPessoa1());
		for(Amigo a : lista) {
			if(a.getPessoa1().equals(amigo.getPessoa1()) && a.getPessoa2().equals(amigo.getPessoa2())) {
				Connection con = new ConFactory().getConnection();
				return false;
			}
		}
		return false;
	}
	
}
