package com.vitorpandini.fakeapi.infrastructure.repositories;

import com.vitorpandini.fakeapi.infrastructure.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

    Boolean existsByNome(String nome);

    Produto  findByNome(String nome);
}
