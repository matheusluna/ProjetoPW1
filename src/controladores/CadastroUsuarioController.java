package controladores;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controle.DaoUsuario;
import entidades.Pessoa;
import interfaces.Comando;

public class CadastroUsuarioController implements Comando{
	private HttpServletRequest request;
    private HttpServletResponse response;
    
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		//Iniciando conexão com o banco
		DaoUsuario dao = new DaoUsuario();
		//Recebendo parâmetros da requisição
		String nome = request.getParameter("nome");
		String cidade = request.getParameter("cidade");
		String dataNascimento = request.getParameter("nascimento");
		//transformando string em data
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate nascimento = LocalDate.parse(dataNascimento,formatter);
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String profissao = request.getParameter("profissao");
		String sexo = request.getParameter("sexo");
		//foto
		String caminho = File.separator+request.getServletContext().getRealPath("img")+File.separator+email;
		File caminhoUser = new File(caminho);
		if(!caminhoUser.exists()) {
			caminhoUser.mkdirs();
		}
		Part path = request.getPart("foto");
		String cam = caminho+File.separator+path.getSubmittedFileName();
		path.write(cam);
		String foto = "img"+File.separator+email+File.separator+path.getSubmittedFileName();
		//criando objeto
		Pessoa pessoa = new Pessoa(email, nome, cidade, profissao, nascimento, sexo, foto, senha);
		
		if(dao.create(pessoa)) {
			request.setAttribute("mensagem", "<script>alert('Usuário cadastrado com sucesso')</script>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("mensagem", "Não foi possível cadastrar o usuário");
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}
				
	}
}
