package Exceptions;

public class VendedorException extends RuntimeException {

	//Adicionado como obrigatório no VendedorException pois extende do Exception
	private static final long serialVersionUID = 1L;
	
	//private String erro;
	
	public VendedorException (String erro) {
			
		super(erro);
		
	}

//	public String getErro() {
//		return erro;
//	}


	
	
	
}
