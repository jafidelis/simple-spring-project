package br.com.edward.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.edward.restfull.domain.Fornecedor;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    String query = "SELECT c FROM Fornecedor c WHERE lower(c.nome) LIKE lower(concat('%', :nome, '%'))";

    @Query(query)
    List<Fornecedor> findByNome(String nome);
}
