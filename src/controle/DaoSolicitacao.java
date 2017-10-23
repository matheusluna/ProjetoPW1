package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.ConFactory;
import entidades.Solicitacao;
import interfaces.DaoSolicitacaoInterface;

public class DaoSolicitacao implements DaoSolicitacaoInterface{
	
	public List<Solicitacao> listar(String receptor) throws ClassNotFoundException, SQLException{
		
		List<Solicitacao> lista = new ArrayList<>();
		
		Connection con = new ConFactory().getConnection();
		String sql="select * from solicitacao where receptor = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, receptor);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String emissorBanco = rs.getString("emissor");
			String receptorsql = rs.getString("receptor");
			Solicitacao solicitacao = new Solicitacao(emissorBanco, receptorsql);
			lista.add(solicitacao);
		}
		stmt.close();
		con.close();
		return lista;
	}
	
public List<Solicitacao> listar() throws ClassNotFoundException, SQLException{
		
		List<Solicitacao> lista = new ArrayList<>();
		
		Connection con = new ConFactory().getConnection();
		String sql="select * from solicitacao";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String emissor = rs.getString("emissor");
			String receptor = rs.getString("receptor");
			Solicitacao solicitacao = new Solicitacao(emissor, receptor);
			lista.add(solicitacao);
		}
		stmt.close();
		con.close();
		return lista;
	}
	
	@Override
	public boolean create(Solicitacao solicitacao) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Solicitacao> lista = listar();
		for(Solicitacao s : lista) {
			if((s.getEmissor().equals(solicitacao.getEmissor()) && s.getReceptor().equals(solicitacao.getReceptor()))) {
				return false;
			}
		}
		
		Connection con = new ConFactory().getConnection();
		String sql = "insert into solicitacao values(?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, solicitacao.getEmissor());
		stmt.setString(2, solicitacao.getReceptor());
		boolean resultado = !stmt.execute();
		stmt.close();
		con.close();
		return resultado;
	}

	@Override
	public Solicitacao read(String emissor, String receptor) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Solicitacao> lista = listar();
		for(Solicitacao s : lista) {
			if(s.getEmissor().equals(emissor) && s.getReceptor().equals(receptor)) {
				return s;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Solicitacao solicitacao) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Solicitacao> lista = listar();
		for(Solicitacao s : lista) {
			if((s.getEmissor().equals(solicitacao.getEmissor()) && s.getReceptor().equals(solicitacao.getReceptor()))) {
				Connection con = new ConFactory().getConnection();
				String sql = "delete from solicitacao where emissor = ? and receptor = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, solicitacao.getEmissor());
				stmt.setString(2, solicitacao.getReceptor());
				boolean resultado = !stmt.execute();
				stmt.close();
				con.close();
				return resultado;
			}
		}
		return false;
	}
	
}
