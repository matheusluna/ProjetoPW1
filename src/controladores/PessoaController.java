package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.DaoAmigo;
import controle.DaoSolicitacao;
import controle.DaoUsuario;
import entidades.Pessoa;
import entidades.Solicitacao;
import interfaces.Comando;

public class PessoaController implements Comando{
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		// TODO Auto-generated method stub
		DaoUsuario dao = new DaoUsuario();
		DaoAmigo daoAmigo = new DaoAmigo();
		DaoSolicitacao daoSolicitacao = new DaoSolicitacao();
		HttpSession session = request.getSession();
		String usuario = (String) session.getAttribute("usuario");
		String email = request.getParameter("email");
		Solicitacao solicitacao = daoSolicitacao.read(usuario, email);
		Solicitacao minhaSolicitacao = daoSolicitacao.read(email, usuario);
		if(daoAmigo.read(usuario, email) != null) {
			request.setAttribute("amigo", true);
		}else if(solicitacao != null) {
			request.setAttribute("solicitacao", true);
		}else if(minhaSolicitacao != null) {
			request.setAttribute("retorno", true);;
		}else {
			request.setAttribute("amigo", false);
			request.setAttribute("solicitacao", false);
			request.setAttribute("retorno", false);
		}
		Pessoa pessoa = dao.read(email);
		request.setAttribute("pessoa", pessoa);
		request.getRequestDispatcher("pessoa.jsp").forward(request, response);
		
	}
	
}
