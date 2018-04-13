package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;

@WebServlet({"/teste2"})
public class ClienteServlet extends HttpServlet {
	
	List<Cliente> lista = new ArrayList<>();
	
	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", lista);
		dispatcher.forward(req, resp);
		//System.out.println("chamou pelo metodo get4");

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// recebendo nome
		String nome = req.getParameter("nome");
		
		// criando objeto cliente e setando nome para ele
		Cliente cli1 = new Cliente();
		cli1.setNome(nome);
		
		// criando lista de clientes
		lista.add(cli1);
		
		
		//System.out.println("chamou pelo metodo post1");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("chamou pelo método post4 com o nome: " + nome);

	}
}
