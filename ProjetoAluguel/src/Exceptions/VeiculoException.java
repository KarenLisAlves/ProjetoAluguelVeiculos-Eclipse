package Exceptions;

// RuntimeException extende Exception. � uma filha de Exception
// Excecao em tempo de execu��o. Nao � obrigada que tenha um Try Catch (Sempre que abre uma conexaso SQL � obrigat�rio o Try Catch).
// O Null Pointer Exception nao precisa Try Catch. 

public class VeiculoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	// N�o precisa - private String erro;
	
	public VeiculoException(String erro) {
		// N�o precisa - this.erro = erro;
		super(erro);
	}

	
	// N�o precisa
	// public String getErro() {
	//	return erro;
	//}

	

}
