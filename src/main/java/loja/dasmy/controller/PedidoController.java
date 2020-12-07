package loja.dasmy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loja.dasmy.domain.Pedido;
import loja.dasmy.repository.PedidoRepository;
import loja.dasmy.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	PedidoRepository repository;
	PedidoService service;
	
	public PedidoController(PedidoService service, PedidoRepository repository) {
		this.service = service;
		this.repository = repository;
	}
	
	@GetMapping("/pesquisa")
	public ResponseEntity<?> buscarTodos(){
		return  ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> salvarPedido(@RequestBody Pedido pedido){
		return ResponseEntity.ok(service.criarPedido(pedido));
	}
}
