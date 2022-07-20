package model;

import java.util.ArrayList;
import java.util.List;

import util.Contador;

public class Cliente extends Pessoa {
	
	private List<Veiculos> veiculos = new ArrayList<>();

	public Cliente(String nome, String cpf, String senha) {
		//Id vai gerar automático
		super(Contador.proximoId(), nome, cpf, senha);
		
	}

	/**
	 * @return the veiculos
	 */
	public List<Veiculos> getVeiculos() {
		return veiculos;
	}

	/**
	 * @param veiculos the veiculos to set
	 */
	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}

	
}
