package repositor;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import util.Contador;

// Tipo de Repository. Nao precisa criar esses m�todos pra todos. Serao metodos automaticos, que precisaremos apenas colocar os tipos e eles ser�o para todos. 
// Criou um tipo generico e ele pode receber qualquer tipo e funcionar para qualquer um. Dessa forma nao precisa criar varias classes, ele fez s� uma classe que vai  receber o tipo e trabalhar dessa forma.

public class RepositoryImpl<I, T> implements Repository<I, T>{

	// o I seria o Integer e o T o ve�culo OU cliente
	//Pega a chave(I) e o valor(T). Na posicao 1 tem o cliente tal Map<Integer (Key) e Valor (Cliente) ou (Vendedor) ou (Ve�culo)>
	Map<I, T> repository = new TreeMap<>();

	
	public List<T> buscarTodos() {
		return repository.values().stream().collect(Collectors.toList()); 
	}
	

	public T buscaPorId(I id) {
		return repository.get(id);
	}
	

	//Nao tem retorno, s� vai fazer alguma coisa!
	public void salvar(I chave, T objeto) {
		repository.put(chave, objeto);
		
	}
	

	public void excluir(I id) {
		repository.remove(id);
		
	}
	
}
