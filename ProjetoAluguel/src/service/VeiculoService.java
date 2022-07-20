package service;

import java.util.List;
import java.util.Scanner;

import Exceptions.VeiculoException;
import model.Cliente;
import model.Veiculos;
import model.Veiculos.Status;
import model.Veiculos.Tipo;
import repositor.RepositoryImpl;
import util.Contador;


public class VeiculoService {
	
	private static RepositoryImpl<Integer, Veiculos> repository = new RepositoryImpl<>();
	Scanner sc;
	
	// Vai receber o Scanner por parametro
	public VeiculoService (Scanner sc) {
		this.sc = sc;
		
		Veiculos veiculo1 = new Veiculos("KAR-1234", "HB20", "Hyundai", "Vermelho", 20000.0, Tipo.CARRO);
		Veiculos veiculo2 = new Veiculos("MAR-1234", "307", "Peugeot", "Preto", 20000.0, Tipo.CARRO);
		Veiculos veiculo3 = new Veiculos("DAR-1234", "Prisma", "Chevrolet", "Vermelho Táxi", 20000.0, Tipo.CARRO);
		Veiculos veiculo4 = new Veiculos("VID-A234", "HB20", "Hyundai", "Branco", 20000.0, Tipo.CARRO);
		
		repository.salvar(veiculo1.getId(), veiculo1);
		repository.salvar(veiculo2.getId(), veiculo2);
		repository.salvar(veiculo3.getId(), veiculo3);
		repository.salvar(veiculo4.getId(), veiculo4);
		
	}
	

	
	public void cadastrarVeiculo() {
		
		sc.nextLine();
		
		System.out.println("Digite o modelo do veículo");
		String modelo = sc.nextLine();
		System.out.println("Digite a placa do veículo");
		String placa = sc.nextLine();
		System.out.println("Digite a marca do veículo");
		String marca = sc.nextLine();
		System.out.println("Digite a cor do veículo");
		String cor = sc.nextLine();
		System.out.println("Digite o valor do veículo");
		Double valor = sc.nextDouble();
		
		System.out.println("Escolha a opção do tipo do veículo: ");
		System.out.println("1 - CARRO");
		System.out.println("2 - MOTO");
		System.out.println("3 - CAMINHÃO");
		
		int opcao = sc.nextInt();
		Tipo tipo = null;
		switch (opcao) {
		case 1 : tipo = Tipo.CARRO; break;
		case 2 : tipo = Tipo.MOTO; break;
		case 3 : tipo = Tipo.CAMINHAO; break;
		}
		
		Veiculos veiculos = new Veiculos (placa, modelo, marca, cor, valor, tipo);
		
		repository.salvar(veiculos.getId(), veiculos);
		
		
	}
	
	public static void mostrarTodos() {
		
//		for(Veiculos veiculos : repository.buscarTodos()) {
//			
//			System.out.println(veiculos.getId() + " _ " + veiculos.getMarca() + ", " 
//			+ veiculos.getModelo() + ", " + veiculos.getCor() + ", R$" + veiculos.getValor());
//
//		}
		
		List<Veiculos> veiculos = repository.buscarTodos();
		
		veiculos.forEach(v -> System.out.println(v));
		
	}
	
	
	public void mostrarTodosLivres() {
		
//		for(Veiculos veiculos : repository.buscarTodos()) {
//			
//			if(veiculos.getStatus() == Status.LIVRE) {
//		
//		System.out.println(veiculos.getId() + " _ " + veiculos.getMarca() + ", " 
//				+ veiculos.getModelo() + ", " + veiculos.getCor() + ", R$" + veiculos.getValor());
//			}
//		}
		
		
		//EXPRESSAO LAMBIDA
		
		List<Veiculos> veiculos = repository.buscarTodos();
		
		veiculos.stream().filter(v -> v.getStatus() == Status.LIVRE)
				
		.forEach(v -> System.out.println(v));
		
//		.forEach(v -> {
//					System.out.println(v.getId() + " _ " + v.getMarca() + ", " 
//							+ v.getModelo() + ", " + v.getCor() + ", R$" + v.getValor());					
//				});
		
	}
	
	
	
	
	
	public Veiculos buscarPorId(Integer Id) {
		
		// Variavel temporária  "veiculo"
		Veiculos veiculo = this.repository.buscaPorId(Id);
		
		
		if(veiculo == null) {
			throw new VeiculoException("Veiculo não encontrado. ID: " + Id);
		}
		
		return veiculo;
	}
	
	
	public void atualizarVeiculo(Veiculos veiculos) {
		this.repository.salvar(veiculos.getId(), veiculos);
	}



	public void buscarVeiculosAlugados() {
		List<Veiculos> veiculos = this.repository.buscarTodos();
		
//		for(Veiculos veiculos : veiculos ) {
//			
//			if(veiculos.getStatus() == Status.ALUGADO) {
//				System.out.println("Cliente" + veiculos.getCliente().getNome() + " _ " +  veiculos.getId() + " _ " + veiculos.getMarca() + ", " 
//						+ veiculos.getModelo() + ", " + veiculos.getCor());
//			}
//		}
		
		
		// EXPRESSAO LAMBIDA - QUE NAO ABRIU COMO FUNÇÃO
		
		veiculos.stream().filter(v -> v.getStatus() == Status.ALUGADO)
		// Dessa forma ele vai mostrar o método toString
		.forEach(v -> System.out.println(v));
		
		
//		.forEach(v -> System.out.println("Cliente " + v.getCliente().getNome() + " _ " +  
//		v.getId() + " _ " + v.getMarca() + ", " + v.getModelo() + ", " + v.getCor() ) );
		
	}

}
