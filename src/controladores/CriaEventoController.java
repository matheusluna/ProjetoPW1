package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.DaoEvento;
import controle.DaoUsuario;
import entidades.Evento;
import entidades.Pessoa;
import interfaces.Comando;

public class CriaEventoController implements Comando{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DaoUsuario dao = new DaoUsuario();
		DaoEvento daoevento = new DaoEvento();
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String rua = request.getParameter("rua");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("cidade");
		String diaevento = request.getParameter("dia");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate dia = LocalDate.parse(diaevento,formatter);
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
	    LocalTime hora = LocalTime.parse(request.getParameter("hora"), formatter2);
	    Pessoa responsavel = dao.read((String) session.getAttribute("usuario"));
	    Evento evento = new Evento(0, nome, descricao, rua, cidade, estado, dia, hora, responsavel);
	    if(daoevento.create(evento)) {
	    	request.setAttribute("mensagem", "<script>alert('Evento cadastrado com sucesso!');</script>");
	    	request.getRequestDispatcher("Principal.jsp").forward(request, response);
	    }else {
	    	request.setAttribute("mensagem", "<script>alert('Não foi possível cadastrar o evento!');</script>");
	    	request.getRequestDispatcher("Principal.jsp").forward(request, response);
	    }
	}
	
}
