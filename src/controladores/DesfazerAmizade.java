package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.DaoAmigo;
import entidades.Amigo;
import interfaces.Comando;

public class DesfazerAmizade implements Comando{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		HttpSession session = request.getSession();
		String usuario = (String) session.getAttribute("usuario");
		String email = request.getParameter("pessoa2");
		Amigo amigo1 = new Amigo(usuario, email);
		Amigo amigo2 = new Amigo(email, usuario);
		DaoAmigo daoAmigo = new DaoAmigo();
		if(daoAmigo.delete(amigo1) && daoAmigo.delete(amigo2)) {
			request.setAttribute("amigo", false);
			request.setAttribute("solicitacao", false);
			request.setAttribute("retorno", false);
			request.getRequestDispatcher("pessoa.jsp").forward(request, response);
		}
		
	}

}
