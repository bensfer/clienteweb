package service;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteService {

	private static List<Cliente> lista = new ArrayList<>();

	public void cadastrar(Cliente cliente) {
		lista.add(cliente);
	}
	
	public void salvar(int indice, Cliente cliente) {
		if (indice != -1) {
			//altera
			lista.set(indice, cliente);
		} else {
			//cadastra
			lista.add(cliente);
		}
	}
	
	public List<Cliente> getTodosClientes() {
		return lista;
	}
	
	public Cliente buscaPorIndice(int ind) {
		Cliente cli = lista.get(ind);
		return cli;
	}
	
	public void excluir(int ind) {
		lista.remove(ind);
	}

}
