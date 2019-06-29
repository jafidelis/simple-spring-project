package br.com.edward.restfull.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edward.restfull.domain.ItemCarrinho;
import br.com.edward.restfull.domain.Produto;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {

	List<ItemCarrinho> findByProduto(Produto produto);

}
