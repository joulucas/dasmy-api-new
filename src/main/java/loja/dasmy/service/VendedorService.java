package loja.dasmy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import loja.dasmy.domain.Vendedor;
import loja.dasmy.repository.VendedorRepository;

@Service
public class VendedorService {
	
	private final VendedorRepository repository;
	
	 VendedorService(VendedorRepository repository) {
		this.repository = repository;
	}
	
	public List<Vendedor> buscarTodos(){
		return repository.findAll();
	}
}
