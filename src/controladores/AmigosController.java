package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.DaoAmigo;
import controle.DaoUsuario;
import entidades.Amigo;
import entidades.Pessoa;
import interfaces.Comando;

public class AmigosController implements Comando{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		// TODO Auto-generated method stub
		DaoAmigo dao = new DaoAmigo();
		DaoUsuario usuario = new DaoUsuario();
		HttpSession session = request.getSession();
		List<Amigo> lista = dao.list((String) session.getAttribute("usuario"));
		List<Pessoa> listaUsuarios = new ArrayList<>();
		for(Amigo a : lista) {
			Pessoa p = usuario.read(a.getPessoa2());
			listaUsuarios.add(p);
		}
		request.setAttribute("amigos", listaUsuarios);
		request.getRequestDispatcher("amigos.jsp").forward(request, response);
	}
	
}
