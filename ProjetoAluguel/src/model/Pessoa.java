package model;

import java.util.List;

// DEFINE O QUE A PESSOA TEM

public abstract class Pessoa {
	
// Como a classe sera herdada as PROPRIEDADES devem ser colocadas como protegidas (protected) !
	protected Integer id;
	protected String nome;
	protected String cpf;
	protected String senha;

	// Criando o construtor. Tambem poderia ser "int" (Tipo primitivo)
	public Pessoa(Integer id, String nome, String cpf, String senha) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

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


	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}


	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	@Override
	public String toString() {
		return this.id + " - " + this.nome;
	}
	
	
}
