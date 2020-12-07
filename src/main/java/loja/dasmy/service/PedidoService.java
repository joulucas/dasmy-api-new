package loja.dasmy.service;

import org.springframework.stereotype.Service;

import loja.dasmy.domain.ItemPedido;
import loja.dasmy.domain.Pedido;
import loja.dasmy.repository.ItemPedidoRepository;
import loja.dasmy.repository.PedidoRepository;

@Service
public class PedidoService {
	
	PedidoRepository repository;
	ItemPedidoRepository itemRepository;
	
	PedidoService(PedidoRepository repository,ItemPedidoRepository itemRepository) {
		 this.repository = repository;
		 this.itemRepository = itemRepository;
	}
	
	public Pedido criarPedido(Pedido pedido) {
		
		Pedido pedidoCriado = new Pedido();	
		
		pedidoCriado.setCodigoVendedor(pedido.getCodigoVendedor());
		pedidoCriado.setData(pedido.getData());
		pedidoCriado.setStatus(pedido.getStatus());
		repository.save(pedidoCriado);
		
		for(ItemPedido itens : pedido.getItensPedido()){
			
			ItemPedido itemPedido = new ItemPedido();
			
			itemPedido.setNumeroPedido(pedidoCriado.getNumeroPedido().longValue());
			itemPedido.setCodigoItem(itens.getCodigoItem().longValue());
			
			itemRepository.save(itemPedido);			
		}
		
		return pedidoCriado;
	}
	
}
