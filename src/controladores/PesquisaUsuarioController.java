package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.DaoEvento;
import controle.DaoSolicitacao;
import controle.DaoUsuario;
import entidades.Evento;
import entidades.Pessoa;
import interfaces.Comando;

public class PesquisaUsuarioController implements Comando{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		// TODO Auto-generated method stub
		DaoUsuario dao = new DaoUsuario();
		DaoEvento daoEvento = new DaoEvento();
		List<Pessoa> lista = dao.pesquisa(request.getParameter("pesquisa"));
		List<Evento> listaEvento = daoEvento.listar(request.getParameter("pesquisa"));
		request.setAttribute("pessoas", lista);
		request.setAttribute("eventos", listaEvento);
		request.getRequestDispatcher("Pesquisa.jsp").forward(request, response);
	}

}
