package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.DaoSolicitacao;
import controle.DaoUsuario;
import entidades.Pessoa;
import entidades.Solicitacao;
import interfaces.Comando;

public class SolicitacaoController implements Comando{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("usuario");
		DaoSolicitacao daosolicitacao = new DaoSolicitacao();
		DaoUsuario daousuario = new DaoUsuario();
		
		List<Solicitacao> listasolicitacao = daosolicitacao.listar(email);
		List<Pessoa> listausuarios = new ArrayList<>();
		for(Solicitacao s : listasolicitacao) {
			Pessoa p = daousuario.read(s.getEmissor());
			listausuarios.add(p);
		}
		
		request.setAttribute("pessoas", listausuarios);
		request.getRequestDispatcher("solicitacao.jsp").forward(request, response);
		
	}

}
