package Exceptions;

//run time exception - em tempo de execu��o

public class ClienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//private String erro;
	
	// Construtor
	
	public ClienteException(String erro) {
		super(erro);
		
		//this.erro = erro;
		//this.erro = "Cliente n�o encontrado";

	}

//
//	public String getErro() {
//		return erro;
//	}




	
	
}
