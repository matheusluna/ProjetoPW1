package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.ConFactory;
import entidades.Publicacao;
import interfaces.DaoPublicacaoInterface;

public class DaoPublicacao implements DaoPublicacaoInterface{
	
	public List<Publicacao> listar() throws ClassNotFoundException, SQLException{
		List<Publicacao> lista = new ArrayList<>();
		Connection con = new ConFactory().getConnection();
		String sql = "select * from publicacao";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			String rua = rs.getString("rua");
			String cidade = rs.getString("cidade");
			String estado = rs.getString("estado");
			
			Publicacao publicacao = new Publicacao(id, nome, descricao, rua, cidade, estado);
			lista.add(publicacao);
		}
		stmt.close();
		con.close();
		return lista;
	}

	@Override
	public boolean create(Publicacao publicacao) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Publicacao> lista = listar();
		for(Publicacao p : lista) {
			if(p.getNome().equals(publicacao.getNome()) && p.getDescricao().equals(publicacao.getDescricao())
					&& p.getRua().equals(publicacao.getRua()) && p.getCidade().equals(publicacao.getCidade()) &&
					p.getEstado().equals(publicacao.getEstado())) {
				return false;
			}
		}
		
		Connection con = new ConFactory().getConnection();
		String sql = "insert into publicacao values(default, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, publicacao.getNome());
		stmt.setString(2, publicacao.getDescricao());
		stmt.setString(3, publicacao.getRua());
		stmt.setString(4, publicacao.getCidade());
		stmt.setString(5, publicacao.getEstado());
		boolean resultado = !stmt.execute();
		stmt.close();
		con.close();
		return resultado;
	}

	@Override
	public Publicacao read(String nome, String descricao, String rua, String cidade, String estado)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Publicacao> lista = listar();
		for(Publicacao p : lista) {
			if(p.getNome().equals(nome) && p.getDescricao().equals(descricao)
					&& p.getRua().equals(rua) && p.getCidade().equals(cidade) &&
					p.getEstado().equals(estado)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Publicacao publicacao) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		return false;
	}
}
