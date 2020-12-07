package loja.dasmy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import loja.dasmy.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
