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

		Cliente cli = new Cliente();
		cli.setNome("");
		int indice = -1;

		String i = req.getParameter("i");
		if (i != null && i != "") {
			indice = Integer.parseInt(i);
		}
		
		String acao = req.getParameter("a");
		if ((i != null) && (i != "") && (acao != null) && (acao != "")) {
			if (acao.equals("exc")) {
				cliService.excluir(indice);
			} else if (acao.equals("edit")) {
				cli = cliService.buscaPorIndice(indice);
			}
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("iCli", indice);
		req.setAttribute("cli", cli);
		req.setAttribute("lista", cliService.getTodosClientes());
		dispatcher.forward(req, resp);
		//System.out.println("chamou pelo metodo get4");
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// recebendo nome
		String nome = req.getParameter("nome");
		String i = req.getParameter("i");
		int indice = -1;
		if (i != null && i != "") {
			indice = Integer.parseInt(i);
		}
		
		// criando objeto cliente e setando nome para ele
		Cliente cli = new Cliente();
		cli.setNome(nome);
		
		// adicionando objeto na lista de clientes
		cliService.salvar(indice, cli);
		
		//resp.sendRedirect("teste2");
		
		cli = new Cliente();
		cli.setNome("");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("msg", "Cadastrado com sucesso!");
		req.setAttribute("cli", cli);
		req.setAttribute("iCli", -1);
		req.setAttribute("lista", cliService.getTodosClientes());
		dispatcher.forward(req, resp);
		//System.out.println("chamou pelo metodo post1");
		//resp.setCharacterEncoding("UTF-8");
		//resp.getWriter().print("chamou pelo método post4 com o nome: " + nome);

	}
}
