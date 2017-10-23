package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.DaoAmigo;
import controle.DaoSolicitacao;
import controle.DaoUsuario;
import entidades.Amigo;
import entidades.Pessoa;
import entidades.Solicitacao;
import interfaces.Comando;

public class CriaAmizadeController implements Comando{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		DaoAmigo daoAmigo = new DaoAmigo();
		DaoUsuario dao = new DaoUsuario();
		DaoSolicitacao daoSolicitacao = new DaoSolicitacao();
		String pessoa1 = (String) request.getSession().getAttribute("usuario");
		String pessoa2 =request.getParameter("pessoa2");
		
		Amigo amigo1 = new Amigo(pessoa1, pessoa2);
		Amigo amigo2 = new Amigo(pessoa2, pessoa1);
		
		if(daoAmigo.create(amigo1) && daoAmigo.create(amigo2)) {
			Solicitacao solicitacao = new Solicitacao(pessoa2, pessoa1);
			daoSolicitacao.delete(solicitacao);
			
			Pessoa pessoa = dao.read(pessoa2);
			
			request.setAttribute("pessoa", pessoa);
			request.setAttribute("amigo", true);
			request.setAttribute("solicitacao", false);
			request.setAttribute("retorno", false);
			request.getRequestDispatcher("pessoa.jsp").forward(request, response);
		}
		
	}
	
}
