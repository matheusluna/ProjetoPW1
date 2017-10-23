package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.DaoSolicitacao;
import controle.DaoUsuario;
import entidades.Pessoa;
import entidades.Solicitacao;
import interfaces.Comando;

public class RejeitarAmizadeController implements Comando{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String usuario = (String) session.getAttribute("usuario");
		String emissor = request.getParameter("emissor");
		Solicitacao solicitacao = new Solicitacao(emissor, usuario);
		DaoSolicitacao daoSolicitacao = new DaoSolicitacao();
		DaoUsuario dao = new DaoUsuario();
		if(daoSolicitacao.delete(solicitacao)) {
			Pessoa pessoa = dao.read(emissor);
			request.setAttribute("pessoa", pessoa);
			request.setAttribute("solicitacao", false);
			request.setAttribute("retorno", false);
			request.getRequestDispatcher("pessoa.jsp").forward(request, response);
		}
	}
	
}
