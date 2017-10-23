package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.DaoSolicitacao;
import controle.DaoUsuario;
import entidades.Solicitacao;
import interfaces.Comando;

public class CriaSolicitacaoController implements Comando{
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		// TODO Auto-generated method stub
		DaoUsuario dao = new DaoUsuario();
		DaoSolicitacao daoSolicitacao = new DaoSolicitacao();
		String emissor = (String) request.getSession().getAttribute("usuario");
		String receptor = request.getParameter("receptor");
		Solicitacao solicitacao = new Solicitacao(emissor, receptor);
		if(daoSolicitacao.create(solicitacao)) {
			request.setAttribute("solicitacao", true);
			request.setAttribute("pessoa", dao.read(receptor));
			request.getRequestDispatcher("pessoa.jsp").forward(request, response);
		}else {
			request.setAttribute("mensagem", "<script>alert('Não foi possível enviar solicitação')</script>");
			request.getRequestDispatcher("pessoa.jsp").forward(request, response);
		}
	}
	
}
