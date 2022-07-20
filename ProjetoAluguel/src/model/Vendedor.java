package model;

import util.Contador;

public class Vendedor extends Pessoa {
	
	// Integer é um tipo de objeto. Por padrão vem Nulo aí dara um erro Point Exception. Então tem que inicializar ele com 0.
	private Double totalVendas;
	
	// Comissao de 1% no total de vendas. Esse total vendas vai pegar o Valor total.
	public static Double COMISSAO = 0.01;
	
	
	private Double salario;
	
	public Vendedor(String nome, String cpf, String senha) {
		super(Contador.proximoId(), nome, cpf, senha);
		
		totalVendas = 0.0;
		salario = 2000.0;
	}

	/**
	 * @return the totalVendas
	 */
	public Double getTotalVendas() {
		return totalVendas;
	}

	/**
	 * @param totalVendas the totalVendas to set
	 */
	public void setTotalVendas(Double totalVendas) {
		this.totalVendas = totalVendas;
	}

	/**
	 * @return the salario
	 */
	public Double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
}
