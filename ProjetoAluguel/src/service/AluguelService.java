package service;

import java.util.List;
import java.util.Scanner;

import model.Aluguel;
import model.Cliente;
import model.Veiculos;
import model.Vendedor;
import repositor.RepositoryImpl;


public class AluguelService {
	
	private Scanner sc;
	
	private RepositoryImpl<Integer, Aluguel> repository = new RepositoryImpl<>();
	
	public AluguelService(Scanner sc) {
		this.sc=sc;
	}
	
	public void salvar(Cliente cliente, Vendedor vendedor, Veiculos veiculos) {
		
		// Extensão da classe Aluguel recebendo na variável "aluguel" e salvando no repositório
		// Vai criar com uma data atual
		//, LocalDate.now() 
		
		Aluguel aluguel = new Aluguel(veiculos, cliente, vendedor);
		
		repository.salvar(aluguel.getId(), aluguel);
		
	}

	// Vai mostrar todos os alugueis e somar o total deles
	public void mostrarTotalVendas() {
		
		List<Aluguel> alugueis = this.repository.buscarTodos();
		
		Double totalVendas = 0.0;
		
		// Vai receber a lista na variael temporaria aluguel
		for (Aluguel aluguel : alugueis) {
			// totalVendas soma ele mais o aluguel. Esta acessando o aluguel, do aluguel acessando o veículo e do veículo o seu valor
			totalVendas += aluguel.getVeiculos().getValor();	
		}
		
		System.out.println("O total de vendas é: " + totalVendas);
	}	

}
