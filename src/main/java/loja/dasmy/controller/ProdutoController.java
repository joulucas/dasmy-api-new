package loja.dasmy.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loja.dasmy.domain.Produto;
import loja.dasmy.helper.ZXingHelper;
import loja.dasmy.repository.ProdutoRepository;
import loja.dasmy.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	private final ProdutoService service;
	private final ProdutoRepository repository;
	
	public ProdutoController(ProdutoService service,ProdutoRepository repository ) {
		this.service = service;
		this.repository = repository;
	}
	
	@GetMapping("/pesquisar")
	public List<Produto> buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping("/pesquisar/{codigo}")
	public Optional<Produto> buscarPorID(@PathVariable Long codigo){
		return service.buscarPorID(codigo);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Produto produto){
		return ResponseEntity.ok(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody Produto produto){
		return ResponseEntity.ok(repository.save(produto));
	}
	
	@GetMapping(value = "qrcode/{codigo}")
	public void qrcode(@PathVariable("codigo") String id, HttpServletResponse response) throws Exception {
		//response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getQRCodeImage(id, 200, 200));
		outputStream.flush();
		outputStream.close();
	}	
}
