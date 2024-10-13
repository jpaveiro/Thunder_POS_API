package br.com.jpaveiro.thunderpos.domain.contracts;

public interface IMapperContract<Entity, Aggregate> {
    Aggregate toDomain(Entity entity);
    Entity toPersistence(Aggregate aggregate);
}
