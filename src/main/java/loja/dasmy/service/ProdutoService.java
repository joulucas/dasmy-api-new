package loja.dasmy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import loja.dasmy.domain.Produto;
import loja.dasmy.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	ProdutoRepository repository;
	
	ProdutoService(ProdutoRepository repository){
		this.repository = repository;
	}
	
	public List<Produto> buscarTodos(){
		return repository.findAll();
	}
	
	public Optional<Produto> buscarPorID(Long codigo) {
		return repository.findById(codigo);
	}
	
}
