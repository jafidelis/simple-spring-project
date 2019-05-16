package br.com.edward.restfull.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edward.restfull.domain.Carrinho;
import br.com.edward.restfull.enuns.EnumStatusCarrinho;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    List<Carrinho> findByStatus(EnumStatusCarrinho status);
}
