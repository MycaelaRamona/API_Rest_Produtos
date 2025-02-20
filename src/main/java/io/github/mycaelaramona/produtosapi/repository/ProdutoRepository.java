package io.github.mycaelaramona.produtosapi.repository;

import io.github.mycaelaramona.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
