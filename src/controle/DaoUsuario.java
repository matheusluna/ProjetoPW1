package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import banco.ConFactory;
import entidades.Pessoa;
import interfaces.DaoUsuarioInterface;

public class DaoUsuario implements DaoUsuarioInterface{
	private List<Pessoa> list() throws ClassNotFoundException, SQLException{
		List<Pessoa> lista = new ArrayList<>();
		Connection con = new ConFactory().getConnection();
		String sql = "select * from usuario";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String email = rs.getString("email");
			String nome = rs.getString("nome");
			String cidade = rs.getString("cidade");
			String profissao = rs.getString("profissao");
			Date nascimento = rs.getDate("nascimento");
			Instant instant = Instant.ofEpochMilli(nascimento.getTime());
	        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
			String sexo = rs.getString("sexo");
			String foto = rs.getString("foto");
			String senha = rs.getString("senha");
			Pessoa pessoa = new Pessoa(email, nome, cidade, profissao, localDate, sexo, foto, senha);
			lista.add(pessoa);
		}
		stmt.close();
		con.close();
		return lista;
	}
	
	public List<Pessoa> pesquisa(String pesquisa) throws ClassNotFoundException, SQLException{
		List<Pessoa> lista = new ArrayList<>();
		Connection con = new ConFactory().getConnection();
		String sql ="select * from usuario u where u.nome ilike ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, pesquisa+"%");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String email = rs.getString("email");
			String nome = rs.getString("nome");
			String cidade = rs.getString("cidade");
			String profissao = rs.getString("profissao");
			Date nascimento = rs.getDate("nascimento");
			Instant instant = Instant.ofEpochMilli(nascimento.getTime());
	        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
			String sexo = rs.getString("sexo");
			String foto = rs.getString("foto");
			String senha = rs.getString("senha");
			Pessoa pessoa = new Pessoa(email, nome, cidade, profissao, localDate, sexo, foto, senha);
			lista.add(pessoa);
		}
		return lista;
	}
	
	@Override
	public boolean create(Pessoa pessoa) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		List<Pessoa> lista = list();
		for(Pessoa p : lista) {
			if(p.getEmail().equals(pessoa.getEmail())) {
				return false;
			}
		}
		Connection connection = (Connection) (new ConFactory()).getConnection();
		String sql = "insert into usuario (email, nome, cidade, profissao, nascimento, sexo, foto, senha) values (?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, pessoa.getEmail());
		stmt.setString(2, pessoa.getNome());
		stmt.setString(3, pessoa.getCidade());
		stmt.setString(4, pessoa.getProfissao());
		stmt.setDate(5, java.sql.Date.valueOf(pessoa.getNascimento()));
		stmt.setString(6, pessoa.getSexo());
		stmt.setString(7, pessoa.getFoto());
		stmt.setString(8, pessoa.getSenha());
		boolean resultado = !stmt.execute();
		stmt.close();
		connection.close();
		return resultado;
	}

	@Override
	public Pessoa read(String email) throws ClassNotFoundException, SQLException{
		List<Pessoa> lista = list();
		for(Pessoa p : lista) {
			if(p.getEmail().equals(email)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean update(Pessoa pessoa) throws ClassNotFoundException, SQLException{
		List<Pessoa> lista = list();
		for(Pessoa p : lista) {
			if(p.getEmail().equals(pessoa.getEmail())) {
				Connection connection = (Connection) (new ConFactory()).getConnection();
				String sql = "update nome = ?, cidade = ?, profissao = ?, nascimento = ?, sexo = ?, foto ?, senha = ? where email = ?";
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, pessoa.getNome());
				stmt.setString(2, pessoa.getCidade());
				stmt.setString(3, pessoa.getProfissao());
				stmt.setDate(4, java.sql.Date.valueOf(pessoa.getNascimento()));
				stmt.setString(5, pessoa.getSexo());
				stmt.setString(6, pessoa.getFoto());
				stmt.setString(7, pessoa.getSenha());
				stmt.setString(8, pessoa.getEmail());
				boolean resultado = !stmt.execute();
				stmt.close();
				connection.close();
				return resultado;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Pessoa pessoa) throws ClassNotFoundException, SQLException{
		List<Pessoa> lista = list();
		for(Pessoa p : lista) {
			if(p.getEmail().equals(pessoa.getEmail())) {
				Connection connection = (Connection) (new ConFactory()).getConnection();
				String sql = "delete from usuario where email = ?";
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, pessoa.getEmail());
				boolean resultado = !stmt.execute();
				stmt.close();
				connection.close();
				return resultado;
			}
		}
		return false;
	}

}
