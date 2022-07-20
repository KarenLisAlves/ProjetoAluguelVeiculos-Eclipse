package service;


import java.util.List;
import java.util.Scanner;

import Exceptions.ClienteException;
import Exceptions.ClienteException;
import model.Cliente;
import model.Veiculos;
import model.Veiculos.Tipo;
import repositor.RepositoryImpl;


public class ClienteService {
	
	private static RepositoryImpl<Integer, Cliente> repository = new RepositoryImpl<>();
	Scanner sc;
	
	
	// Construtor
	public ClienteService(Scanner sc) {
		this.sc = sc;
	}
	
	
	// Métodos da classe CLIENTE:
	
		public Cliente cadastrarCliente() throws ClienteException {
		
		sc.nextLine();
		
		System.out.println("Digite o nome do cliente");
		String nome = sc.nextLine();
		System.out.println("Digite o CPF do cliente");
		String cpf = sc.nextLine();
		System.out.println("Digite a sua senha");
		String senha = sc.nextLine();
		
		
		List<Cliente> clientes = this.repository.buscarTodos();
		for(Cliente cliente : clientes) {
			
			if(cliente.getCpf().equals(cpf)) {
				throw new ClienteException("Cliente já cadastrado!"); 
			}
		}
		

		Cliente cliente = new Cliente(nome, cpf, senha);
		
		repository.salvar(cliente.getId(), cliente);
		
		return cliente;
		
	}

		
	// Método Buscar Clientes - Vai percorrer a lista repository, buscar todos e fazer um filtro para buscar o CPF
		
		public Cliente buscarPeloCpf(String cpf) throws ClienteException {
			List<Cliente> clientes = repository.buscarTodos();
			// Caso nao entre no for retorna null. Se nao encontrar vai retornar nulo e se encontrar vai retornar o CPF
			Cliente cl = null;
			
			// Vai Percorrer a lista Clientes - e verificar cada Cliente (Variavel provisória cliente que vai passar para a variável cl e retornar a variável cl)
			
//			for(Cliente cliente : clientes) {
//				if(cliente.getCpf().equals(cpf)) {
//					cl = cliente;
//				}
//			}
			
			cl = clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf))
					.findFirst().orElse(null);

			
			if(cl == null) {
				
				 throw new ClienteException("Cliente não encontrado");
			}
				
			return cl;
		}
		
		
		
		//Método para ver o que o cliente digitou
		
		public Cliente tratarOpcaoDoCliente(String opcao) throws ClienteException {
			sc.nextLine();
			
			//replace representa o que vai mudar ( aqui o que vai mudar , aqui como vai ficar )
			
			// toLowerCase quer dizer que tudo que eu digitar abaixo disso vai transformar em letras minúsculas
			opcao = opcao.toLowerCase();
			opcao = opcao.replace("ã", "a");
			System.out.println(opcao);
			
			
			if(opcao.equals("nao") || opcao.equals("n")) {	
				
				return this.cadastrarCliente();
				
			} else {
				
				Cliente cliente = this.buscarPeloCpf(opcao);
				boolean continua = true;
				// Var ter 3 chances, Se nao digitar certo...
				Integer chance = 3;
				do {
					
					System.out.println("Digite sua senha: ");
					String senha = sc.next();
					
					// Se a senha nao for igual
					if(!cliente.getSenha().equals(senha)) {
						chance--;
						System.out.println("Senha incorreta. Tente novamente. Chances: " + chance);
						
						if(chance < 0) {
							throw new ClienteException("Número de tentativas excedidas. Faça o Login novamente!");
						}
						
						// Aqui ele ja vai parar
						
					}else {
						continua = false;
					}
					
					
				}while(continua);
				
				return cliente;
					
			}
				
		}
		
		
		
	public void atualizarCliente(Cliente cliente) {
		this.repository.salvar(cliente.getId(), cliente);
	}
	
	
	// O repository simula um banco de dados
	public void mostrarVeiculosAlugados(Integer id) {
		
		// Ou simplesmente alterar isso para Veiculos, pois nao precisa pegar o cliente. ]
		// Pois nao pega nenhuma informacao do cliente, entao nao tem necessidade de menciona-lo
		
		List<Veiculos> veiculos = this.repository.buscaPorId(id).getVeiculos();
		
		veiculos.forEach(v -> System.out.println(v.getId() + " _ " + v.getMarca() + ", " 
				+ v.getModelo() + ", " + v.getCor()));
		
//		Cliente clienteRepo = this.repository.buscaPorId(id);
		
//		for(Veiculos veiculos : clienteRepo.getVeiculos()) {
//			System.out.println(veiculos.getId() + " _ " + veiculos.getMarca() + ", " 
//					+ veiculos.getModelo() + ", " + veiculos.getCor());
//		}
		
		//Pode ser essa opcao
		//List<Veiculos> veiculos = ...
		// Ou assim:
		///ClienteRepo.getVeiculos()....

		
	}
		
		
}
