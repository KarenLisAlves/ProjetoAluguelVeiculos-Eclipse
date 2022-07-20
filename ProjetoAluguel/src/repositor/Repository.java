package repositor;

import java.util.List;

import model.Cliente;

// O "I" é a chave e o "T" é o valor que é o Cliente! 

// É uma Interface pois tem apenas FUNÇÕES

public interface Repository<I, T> {

	// RETORNA TODOS DA LISTA
	public List<T> buscarTodos();
	
	// RETORNA A BUSCA PELO ID
	public T buscaPorId(I id);
	
	// Void nao retorna nada, só faz alguma coisa
	public void salvar(I chave, T objeto);
	
	public void excluir(I id);

}
