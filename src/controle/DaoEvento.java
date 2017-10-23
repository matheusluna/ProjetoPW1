package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import banco.ConFactory;
import entidades.Evento;
import entidades.Pessoa;
import entidades.Publicacao;
import interfaces.DaoEventoInterface;

public class DaoEvento implements DaoEventoInterface{
	public List<Evento> listar() throws ClassNotFoundException, SQLException{
		DaoUsuario dao = new DaoUsuario();
		List<Evento> lista = new ArrayList<>();
		Connection con = new ConFactory().getConnection();
		String sql = "select p.id id, p.nome nome, p.descricao descricao, p.rua rua, p.cidade cidade, p.estado estado, e.dia dia, e.hora hora, e.responsavel responsavel from publicacao p, evento e where p.id = e.idpublicacao";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			String rua = rs.getString("rua");
			String cidade = rs.getString("cidade");
			String estado = rs.getString("estado");
			Date diasql = rs.getDate("dia");
			Instant instant = Instant.ofEpochMilli(diasql.getTime());
	        LocalDate dia = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	        Time horasql = rs.getTime("hora");
	        instant = Instant.ofEpochMilli(horasql.getTime());
	        LocalTime hora = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
	        Pessoa responsavel = dao.read(rs.getString("responsavel"));
	        
	        Evento evento = new Evento(id, nome, descricao, rua, cidade, estado, dia, hora, responsavel);
	        lista.add(evento);
		}
		stmt.close();
		con.close();
		return lista;	
	}
	
	public List<Evento> listar(String nome) throws ClassNotFoundException, SQLException{
		DaoUsuario dao = new DaoUsuario();
		List<Evento> lista = new ArrayList<>();
		Connection con = new ConFactory().getConnection();
		String sql = "select p.id id, p.nome nome, p.descricao descricao, p.rua rua, p.cidade cidade, p.estado estado, e.dia dia, e.hora hora, e.responsavel responsavel from publicacao p, evento e where p.id = e.idpublicacao and p.nome ilike ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nomesql = rs.getString("nome");
			String descricao = rs.getString("descricao");
			String rua = rs.getString("rua");
			String cidade = rs.getString("cidade");
			String estado = rs.getString("estado");
			Date diasql = rs.getDate("dia");
			Instant instant = Instant.ofEpochMilli(diasql.getTime());
	        LocalDate dia = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	        Time horasql = rs.getTime("hora");
	        instant = Instant.ofEpochMilli(horasql.getTime());
	        LocalTime hora = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
	        Pessoa responsavel = dao.read(rs.getString("responsavel"));
	        Evento evento = new Evento(id, nomesql, descricao, rua, cidade, estado, dia, hora, responsavel);
	        lista.add(evento);
		}
		return lista;
		
	}
	
	@Override
	public boolean create(Evento evento) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Evento> lista = listar();
		DaoPublicacao dao = new DaoPublicacao();
		for(Evento e : lista) {
			if(e.getNome().equals(evento.getNome()) && e.getDescricao().equals(evento.getDescricao())
					&& e.getRua().equals(evento.getRua()) && e.getCidade().equals(evento.getCidade()) &&
					e.getEstado().equals(evento.getEstado())) {
				return false;
			}
		}
		if(dao.create(evento)) {
			Publicacao publicacao = dao.read(evento.getNome(), evento.getDescricao(), evento.getRua(), evento.getCidade(), evento.getEstado());
			Connection con = new ConFactory().getConnection();
			String sql ="insert into evento values(?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, publicacao.getId());
			stmt.setDate(2, java.sql.Date.valueOf(evento.getDia()));
			stmt.setTime(3, java.sql.Time.valueOf(evento.getHora()));
			stmt.setString(4, evento.getResponsavel().getEmail());
			boolean resultado = !stmt.execute();
			stmt.close();
			con.close();
			return resultado;
		}else {
			return false;
		}
		
	}

	@Override
	public Evento read(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Evento evento) {
		// TODO Auto-generated method stub
		return false;
	}

}
