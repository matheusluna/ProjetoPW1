package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.DaoSolicitacao;
import controle.DaoUsuario;
import entidades.Pessoa;
import entidades.Solicitacao;
import interfaces.Comando;

public class DesfazerSolicitacaoController implements Comando{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		DaoUsuario dao = new DaoUsuario();
		DaoSolicitacao daoSolicitacao = new DaoSolicitacao();
		
		String emissor = (String) request.getSession().getAttribute("usuario");
		String receptor = request.getParameter("receptor");
		
		Solicitacao solicitacao = new Solicitacao(emissor, receptor);
		
		
		if(daoSolicitacao.delete(solicitacao)) {
			Pessoa pessoa = dao.read(receptor);
			request.setAttribute("pessoa", pessoa);
			request.setAttribute("solicitacao", false);
			request.setAttribute("retorno", false);
			request.getRequestDispatcher("pessoa.jsp").forward(request, response);
		}
		
	}
	
}
