package Exceptions;

// RuntimeException extende Exception. É uma filha de Exception
// Excecao em tempo de execução. Nao é obrigada que tenha um Try Catch (Sempre que abre uma conexaso SQL é obrigatório o Try Catch).
// O Null Pointer Exception nao precisa Try Catch. 

public class VeiculoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	// Não precisa - private String erro;
	
	public VeiculoException(String erro) {
		// Não precisa - this.erro = erro;
		super(erro);
	}

	
	// Não precisa
	// public String getErro() {
	//	return erro;
	//}

	

}
