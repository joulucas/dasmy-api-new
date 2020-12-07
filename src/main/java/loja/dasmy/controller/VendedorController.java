package loja.dasmy.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loja.dasmy.domain.Vendedor;
import loja.dasmy.repository.VendedorRepository;
import loja.dasmy.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
	
	private final VendedorService service;
	private final VendedorRepository repository;
	
	public VendedorController(VendedorService service, VendedorRepository repository) {
		this.service = service;
		this.repository = repository;
	}
	
	@GetMapping("/pesquisar")
	public List<Vendedor> buscarTodos(){
		return service.buscarTodos();
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Vendedor vendedor){
		return ResponseEntity.ok(repository.save(vendedor));
	}
	
}
