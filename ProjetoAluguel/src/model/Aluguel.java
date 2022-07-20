package model;


import util.Contador;

public class Aluguel {
	
	private Integer id;
	private Veiculos veiculos;
	private Cliente cliente;
	private Vendedor vendedor;
//	private LocalDate data;
	
	//LocalDate data
	
	public Aluguel(Veiculos veiculos, Cliente cliente, Vendedor vendedor) {
		this.id = Contador.proximoId();
		this.veiculos = veiculos;
		this.cliente = cliente;
		this.vendedor = vendedor;
//		this.data = data;
	}


	/**
	 * @return the veiculos
	 */
	public Veiculos getVeiculos() {
		return veiculos;
	}


	/**
	 * @param veiculos the veiculos to set
	 */
	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}


	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}


	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	/**
	 * @return the vendedor
	 */
	public Vendedor getVendedor() {
		return vendedor;
	}


	/**
	 * @param vendedor the vendedor to set
	 */
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	/**
	 * @return the data
	 */
//	public LocalDate getData() {
//		return data;
//	}
//
//
//	/**
//	 * @param data the data to set
//	 */
//	public void setData(LocalDate data) {
//		this.data = data;
//	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



}
