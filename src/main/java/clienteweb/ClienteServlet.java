package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

@WebServlet({"/teste2"})
public class ClienteServlet extends HttpServlet {
	
	ClienteService cliService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		cliService = new ClienteService();
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String i = req.getParameter("i");
		if ((i != null) && (i != "")) {
			cliService.excluir(Integer.parseInt(i));
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", cliService.getTodosClientes());
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
		
		// adicionando objeto na lista de clientes
		cliService.cadastrar(cli1);
		
		//resp.sendRedirect("teste2");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("msg", "Cadastrado com sucesso!");
		req.setAttribute("lista", cliService.getTodosClientes());
		dispatcher.forward(req, resp);
		//System.out.println("chamou pelo metodo post1");
		//resp.setCharacterEncoding("UTF-8");
		//resp.getWriter().print("chamou pelo método post4 com o nome: " + nome);

	}
}
