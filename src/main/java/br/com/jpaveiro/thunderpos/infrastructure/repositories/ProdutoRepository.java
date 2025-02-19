package br.com.jpaveiro.thunderpos.infrastructure.repositories;

import br.com.jpaveiro.thunderpos.infrastructure.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {
}
