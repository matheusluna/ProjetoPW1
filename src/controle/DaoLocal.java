package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.ConFactory;
import entidades.Local;
import interfaces.DaoLocalInterface;

public class DaoLocal implements DaoLocalInterface{
	public List<Local> listar() throws ClassNotFoundException, SQLException{
		List<Local> lista = new ArrayList<>();
		Connection con = new ConFactory().getConnection();
		String sql = "select p.id id, p.nome nome, p.descricao descricao, p.rua rua, p.cidade cidade, p.estado estado, l.tipo tipo from publicacao p, local l from p.id = l.idpublicacao";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int  id = rs.getInt("id");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			String rua = rs.getString("rua");
			String cidade = rs.getString("cidade");
			String estado = rs.getString("estado");
			String tipo = rs.getString("tipo");
			
			Local local = new Local(id, nome, descricao, rua, cidade, estado, tipo);
			lista.add(local);
		}
		stmt.close();
		con.close();
		return lista;
		
	}
	
	public List<Local> listar(String nome) throws ClassNotFoundException, SQLException{
		List<Local> lista = new ArrayList<>();
		Connection con = new ConFactory().getConnection();
		String sql = "select p.id id, p.nome nome, p.descricao descricao, p.rua rua, p.cidade cidade, p.estado estado, l.tipo tipo from publicacao p, local l from p.id = l.idpublicacao and p.nome ilike ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int  id = rs.getInt("id");
			String nomesql = rs.getString("nome");
			String descricao = rs.getString("descricao");
			String rua = rs.getString("rua");
			String cidade = rs.getString("cidade");
			String estado = rs.getString("estado");
			String tipo = rs.getString("tipo");
			
			Local local = new Local(id, nomesql, descricao, rua, cidade, estado, tipo);
			lista.add(local);
		}
		stmt.close();
		con.close();
		return lista;
	}
	
	@Override
	public boolean create(Local local) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Local read(String nome) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Local local) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Local local) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return false;
	}
	
}
