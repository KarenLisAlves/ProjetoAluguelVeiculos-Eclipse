package model;

import util.Contador;

public class Veiculos {
		
		// Valores constantes pré definidos
		
		public enum Status{
			ALUGADO,
			LIVRE
		}
		
		
		public enum Tipo{
			CARRO,
			MOTO,
			CAMINHAO
		}
		
		// Definição de Propriedades
		private Integer id;
		private String placa;
		private String modelo;
		private String marca;
		private String cor;
		// Double com D MAUSCULO não é o tipo primitivo, ele pode ser nulo enquanto o d minusculo é tipo primitivo e não pode ser nulo, ele precisa receber algo por exemplo um 0.
		// double x = 0;
		//Double y = null; Pode dar o erro: No point Exception.  Nao pode pegar nulo!
		private Double valor;
		private Status status;
		private Tipo tipo;
		private Cliente cliente ;
		
		// Construtor
		public Veiculos(String placa, String modelo, String marca, String cor, Double valor, Tipo tipo) {
			
			this.id = Contador.proximoId();
			this.status = Status.LIVRE;
			
			this.placa = placa;
			this.modelo = modelo;
			this.marca = marca;
			this.cor = cor;
			this.valor = valor;
			this.tipo = tipo;
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
		 * @return the placa
		 */
		public String getPlaca() {
			return placa;
		}
		/**
		 * @param placa the placa to set
		 */
		public void setPlaca(String placa) {
			this.placa = placa;
		}
		/**
		 * @return the modelo
		 */
		public String getModelo() {
			return modelo;
		}
		/**
		 * @param modelo the modelo to set
		 */
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		/**
		 * @return the marca
		 */
		public String getMarca() {
			return marca;
		}
		/**
		 * @param marca the marca to set
		 */
		public void setMarca(String marca) {
			this.marca = marca;
		}
		/**
		 * @return the cor
		 */
		public String getCor() {
			return cor;
		}
		/**
		 * @param cor the cor to set
		 */
		public void setCor(String cor) {
			this.cor = cor;
		}
		/**
		 * @return the valor
		 */
		public Double getValor() {
			return valor;
		}
		/**
		 * @param valor the valor to set
		 */
		public void setValor(Double valor) {
			this.valor = valor;
		}
		/**
		 * @return the status
		 */
		public Status getStatus() {
			return status;
		}
		/**
		 * @param status the status to set
		 */
		public void setStatus(Status status) {
			this.status = status;
		}
		/**
		 * @return the tipo
		 */
		public Tipo getTipo() {
			return tipo;
		}
		/**
		 * @param tipo the tipo to set
		 */
		public void setTipo(Tipo tipo) {
			this.tipo = tipo;
		}

		
		/**
		 * @return the idCliente
		 */
		public Cliente getCliente() {
			return cliente;
		}


		/**
		 * @param idCliente the idCliente to set
		 */
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}


		//Reescreve as informações do Veículo - MÉTODO TOSTRING
		
		@Override
		public String toString() {
//			return "Veiculos [id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", cor="
//					+ cor + ", valor=" + valor + ", status=" + status + ", tipo=" + tipo + "]";
			
			return this.id + " - " + this.marca + " - " + this.modelo + " - " 
			+ this.cor + " - R$ " + this.valor;
		}
		
		
		

	}



