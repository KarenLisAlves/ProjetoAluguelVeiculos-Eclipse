package service;

import model.Veiculos;
import model.Vendedor;
import model.Veiculos.Tipo;
import repositor.RepositoryImpl;

import java.util.List;
import java.util.Scanner;

import Exceptions.ClienteException;
import Exceptions.VendedorException;


public class VendedorService {

	private static RepositoryImpl<Integer, Vendedor> repository = new RepositoryImpl<>();
	
	private static Scanner sc;
	
	
	// Contrutor
	
	public VendedorService(Scanner sc) {
		this.sc = sc;
		
		
		Vendedor vendedor1 = new Vendedor("Karen", "02712048008", "1111");
		Vendedor vendedor2 = new Vendedor("Marcelo", "92662862068", "2222");
		Vendedor vendedor3 = new Vendedor("Dara", "12345678910", "3333");
		Vendedor vendedor4 = new Vendedor("Kalila", "9876543210", "4444");
		
		repository.salvar(vendedor1.getId(), vendedor1);
		repository.salvar(vendedor2.getId(), vendedor2);
		repository.salvar(vendedor3.getId(), vendedor3);
		repository.salvar(vendedor4.getId(), vendedor4);
		
	}
	
	
	
	public static void mostrarTodos() {
//		for(Vendedor vendedor : repository.buscarTodos()) {
//			
//			System.out.println(vendedor.getId() + " _ " + vendedor.getNome());
//	}
		List<Vendedor> vendedores = repository.buscarTodos();
		vendedores.forEach(v -> System.out.println(v.getId() + " - " + v.getNome()));
	}
	
	
	
	public Vendedor buscarVendedorPorId(Integer id) {
		Vendedor vendedor = repository.buscaPorId(id);
		
		// Se vendedor nao existir, for igual a nulo, ele vai dar uma Exceção
		if(vendedor == null) {
			throw new VendedorException("Vendedor não encontrado!");
		}
		
		return vendedor;
	}




	public Vendedor login() {
		
		System.out.println("Digite uma opção: ");
		this.mostrarTodos();
		Integer id = sc.nextInt();

		Vendedor vendedor = this.repository.buscaPorId(id);
		
		boolean continua = true;
		// Var ter 3 chances, Se nao digitar certo...
		Integer chance = 3;
		do {
			
			System.out.println("Digite sua senha: ");
			String senha = sc.next();
			
			// Se nao for igual
			if(!vendedor.getSenha().equals(senha)) {
				chance--;
				System.out.println("Senha incorreta. Tente novamente. Chances: " + chance);
				
				if(chance < 0) {
					throw new VendedorException("Número de tentativas excedidas. Faça o Login novamente!");
				}
				
				// Aqui ele ja vai parar
				
			}else {
				continua = false;
			}
			
			
		}while(continua);
		
		
		return vendedor;
		
		
		}
	


	
	public void cadastrarVendedor() {
			
			// Para pular a linha
			sc.nextLine();
			
			System.out.println("Digite o nome do vendedor");
			String nome = sc.nextLine();
			System.out.println("Digite o CPF do vendedor");
			String cpf = sc.nextLine();
			System.out.println("Digite a senha do vendedor");
			String senha = sc.nextLine();

			
			Vendedor vendedor = new Vendedor (nome, cpf, senha);
			
			repository.salvar(vendedor.getId(), vendedor);
			

	}
	
	
	// Precisa do id do vendedor e o valor da venda
	
	public void cadastrarVenda(Integer id, Double valorVenda) {
		
		// Buscando pelo id do vendedor
		Vendedor vendedor = this.repository.buscaPorId(id);
		
		// Vai ser o que ele tem + o valor que está recebendo
		vendedor.setTotalVendas(vendedor.getTotalVendas() + valorVenda);
		
		// Depois disso precisa salvar
		this.repository.salvar(vendedor.getId(), vendedor);
	}
	
	
	public void mostrarSalario(Integer id) {
		
		Vendedor vendedor = this.repository.buscaPorId(id);
		
		// Mostrar salário e total de vendas
		System.out.println("Seu salário base: " + vendedor.getSalario());
		Double salarioTotal = vendedor.getSalario() + (vendedor.getTotalVendas() * Vendedor.COMISSAO);
		System.out.println("Seu salário com comissão: " + salarioTotal);
		
		System.out.println("O valor total de vendas: " + vendedor.getTotalVendas());
	}
}
