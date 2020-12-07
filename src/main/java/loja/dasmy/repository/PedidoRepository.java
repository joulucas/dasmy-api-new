package loja.dasmy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import loja.dasmy.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
