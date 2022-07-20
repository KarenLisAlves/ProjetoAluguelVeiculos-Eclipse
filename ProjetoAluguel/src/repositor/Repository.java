package repositor;

import java.util.List;

import model.Cliente;

// O "I" � a chave e o "T" � o valor que � o Cliente! 

// � uma Interface pois tem apenas FUN��ES

public interface Repository<I, T> {

	// RETORNA TODOS DA LISTA
	public List<T> buscarTodos();
	
	// RETORNA A BUSCA PELO ID
	public T buscaPorId(I id);
	
	// Void nao retorna nada, s� faz alguma coisa
	public void salvar(I chave, T objeto);
	
	public void excluir(I id);

}
