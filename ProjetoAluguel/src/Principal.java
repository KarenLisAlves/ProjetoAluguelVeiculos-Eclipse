import repositor.RepositoryImpl;
import service.AluguelService;
import service.ClienteService;
import service.VeiculoService;
import service.VendedorService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Exceptions.ClienteException;
import Exceptions.VeiculoException;
import Exceptions.VendedorException;
import model.Cliente;
import model.Veiculos;
import model.Veiculos.Status;
import model.Vendedor;

import util.Menu;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		// Estendendo as Classes
		Scanner sc = new Scanner(System.in);
		
		
		// Criando as Propriedades
		VeiculoService veiculoService = new VeiculoService(sc);
		ClienteService clienteService = new ClienteService(sc);
		VendedorService vendedorService = new VendedorService(sc);
		AluguelService aluguelService = new AluguelService(sc);
		
		// Declarando Variável
		boolean continua = true;
		
		
		//Faça:
		do {
			
			// Try Catch para tratar as Exceptions
			try {
		
			Menu.bemVindo();
			Menu.identificar();
			
			
			// Digitar o número para a Identificacao
			int identificacao = sc.nextInt();
			
			// Se a identificacao for 1 que é igual à CLIENTE faça:
			if(identificacao == 1) {
				
				Menu.menuCliente1();	
				// Criaçao de uma variável provisória para encapsular o que for digitado
				String  cadastro = sc.next();
				Cliente cliente = clienteService.tratarOpcaoDoCliente(cadastro);
			
				
				Menu.menuCliente2();
				// Criando variável opcao
				int opcao = sc.nextInt();
			
				if(opcao == 1) {
				
					System.out.println();
					System.out.println("Escolha uma opção: ");
					veiculoService.mostrarTodosLivres();
					int opcaoVeiculo = sc.nextInt();			
					Veiculos veiculos = veiculoService.buscarPorId(opcaoVeiculo);

					
					
					System.out.println();
					System.out.println("Escolha qual o vendedor que lhe atendeu: ");
					vendedorService.mostrarTodos();				
					int opcaoVendedor = sc.nextInt();
					Vendedor vendedor = vendedorService.buscarVendedorPorId(opcaoVendedor);
					
					aluguelService.salvar(cliente, vendedor, veiculos);					
					veiculos.setStatus(Status.ALUGADO);
					veiculos.setCliente(cliente);		
					veiculoService.atualizarVeiculo(veiculos);
					
					//Aqui o do prof Marlon ficou ao contrário
					clienteService.atualizarCliente(cliente);
					cliente.getVeiculos().add(veiculos);
					
					// Cadastrando a venda - Passando o id vendedor + veiculo que o cliente escolheu e seu valor
					vendedorService.cadastrarVenda(vendedor.getId(), veiculos.getValor());
					
			
					
				}else if (opcao == 2) {
					
					System.out.println("Digite a opção referente ao veículo: ");
					clienteService.mostrarVeiculosAlugados(cliente.getId());
					
					// Metodo que devolva o veiculo (O int vai ser o id do veiculo)
					int opcaoVeiculo = sc.nextInt();
					Veiculos veiculos = veiculoService.buscarPorId(opcaoVeiculo);
					
					// Primeiro remove o veiculo depois muda o status para livre
					cliente.getVeiculos().remove(veiculos);
					veiculos.setStatus(Status.LIVRE);
					veiculos.setCliente(null);
					veiculoService.atualizarVeiculo(veiculos);
					clienteService.atualizarCliente(cliente);
					
				}
				
				
				
				
			} else if(identificacao == 2) {
				// Vai ser guardado dentro de um vendedor
					Vendedor vendedor = vendedorService.login();
					
					Menu.menuVendedor();
					int opcaoVendedor = sc.nextInt();
			

					if ( opcaoVendedor == 1) {
				
						vendedorService.mostrarSalario(vendedor.getId());
				
				
					}else if (opcaoVendedor == 2 ) {
						
						veiculoService.buscarVeiculosAlugados();
					}
					
			
					} else if(identificacao == 3) {
						Menu.menuAdministrador();
						int opcao = sc.nextInt();
						
							if(opcao == 1) {
								veiculoService.cadastrarVeiculo();
								
							}else if (opcao == 2) {
								vendedorService.cadastrarVendedor();
							} 
							
							else if (opcao == 3) {
								aluguelService.mostrarTotalVendas();
							}
					
					
					
							
					}else if (identificacao == 0) {
						continua = false;
					}
					

			
		
					} catch(InputMismatchException e) {
						System.out.println("Opção inválida!");
						System.out.println("Tente novamente! ");
						//Pula uma linha
						sc.nextLine();
						// Para em 2 segundos (2000 milisegundos)
	
					}
					
		
					catch(ClienteException e) {
						
						System.out.println(e.getMessage());
					}
			
					catch(VendedorException e) {
						
						System.out.println(e.getMessage());
					}
					
					catch(VeiculoException e) {
						
						System.out.println(e.getMessage());
					}
			
			
					finally {
						Thread.sleep(2000);
						sc.nextLine();
					}
					
		
					}while (continua);
					
					veiculoService.mostrarTodos();
	
	}
		
}








		
		
//		RepositoryImpl<Integer, Vendedor> vendedor = new RepositoryImpl<Integer, Vendedor>();
//		
//		vendedor.salvar(1, new Vendedor("Cristiano", "123456"));
//	
//	List<Vendedor> lista = vendedor.buscarTodos();
//	
//	for(Vendedor vendedorFor : lista) {
//		
//		System.out.println(vendedorFor.getNome());
//	}
		

	
	

