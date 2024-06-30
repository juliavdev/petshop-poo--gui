package facade;

import java.util.ArrayList;

import model.Cliente;

public class ClienteFacade {

	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static int sequenciaCodigo = 1;
	
	public static Cliente carregar(int codigo) {
		for (Cliente cliente : clientes) {
			if(cliente.getCodigo() == codigo)
				return cliente;
		}
		return null;
	}
	
	public static void adicionar (Cliente cliente) {
		cliente.setCodigo(sequenciaCodigo);
		clientes.add(cliente);
		sequenciaCodigo++;
	}
	
	public static void alterar (Cliente clienteAlterar) {
		Cliente cliente = carregar(clienteAlterar.getCodigo());
		cliente.setNome(clienteAlterar.getNome());
		cliente.setEndereco(clienteAlterar.getEndereco());
		cliente.setTelefone(clienteAlterar.getTelefone());
		cliente.setEmail(clienteAlterar.getEmail());
	}
	
	public static void remover(int codigo) {
		Cliente cliente = carregar(codigo);
		if(cliente != null)
			clientes.remove(cliente);
	}
	
	
}
