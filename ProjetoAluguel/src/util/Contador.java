package util;

public abstract class Contador {
	
	public static int VALOR = 0;
	
	// NAO POSSO USAR O THIS PQ ELE � ESTATICO, NAO FAZ PARTE DA CLASSE
	public static Integer proximoId() {
		VALOR++;
		return VALOR;
		
	}
	
}

