package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.DaoUsuario;
import entidades.Pessoa;
import interfaces.Comando;

public class LoginController implements Comando {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		// TODO Auto-generated method stub
		
		DaoUsuario dao = new DaoUsuario();
		
		Pessoa pessoa = dao.read(request.getParameter("email"));
		if(pessoa != null) {
			if(pessoa.validaUsuario(request.getParameter("senha"))) {
				HttpSession session = request.getSession();
				session.setAttribute("usuario", pessoa.getEmail());
				session.setAttribute("nome", pessoa.getNome());
				session.setAttribute("foto", pessoa.getFoto());
				
				request.getRequestDispatcher("Principal.jsp").forward(request, response);
			}else {
				request.setAttribute("mensagem", "Senha inválida");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("mensagem", "Login inválido");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	} 
}
