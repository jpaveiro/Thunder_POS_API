package br.com.jpaveiro.thunderpos.application.mappers;

import br.com.jpaveiro.thunderpos.domain.aggregates.ProdutoAggregate;
import br.com.jpaveiro.thunderpos.domain.contracts.IMapperContract;
import br.com.jpaveiro.thunderpos.infrastructure.entities.ProdutoEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoMapper implements IMapperContract<ProdutoEntity, ProdutoAggregate> {
    @Override
    public ProdutoAggregate toDomain(ProdutoEntity entity) {
        return new ProdutoAggregate(
                entity.getId(),
                entity.getNome(),
                entity.getRegistradoPor(),
                entity.getRegistradoEm(),
                entity.getAlteradoEm()
        );
    }

    @Override
    public ProdutoEntity toPersistence(ProdutoAggregate aggregate) {
        return new ProdutoEntity(
                aggregate.getId(),
                aggregate.getNome(),
                aggregate.getRegistradoPor(),
                aggregate.getRegistradoEm(),
                aggregate.getAlteradoEm()
        );
    }
}
