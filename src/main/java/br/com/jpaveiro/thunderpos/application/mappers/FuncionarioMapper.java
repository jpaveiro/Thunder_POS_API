package br.com.jpaveiro.thunderpos.application.mappers;

import br.com.jpaveiro.thunderpos.domain.aggregates.FuncionarioAggregate;
import br.com.jpaveiro.thunderpos.domain.contracts.IMapperContract;
import br.com.jpaveiro.thunderpos.infrastructure.entities.FuncionarioEntity;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioMapper implements IMapperContract<FuncionarioEntity, FuncionarioAggregate> {
    public FuncionarioAggregate toDomain(FuncionarioEntity funcionarioEntity)
    {
        return new FuncionarioAggregate(
                funcionarioEntity.getId(),
                funcionarioEntity.getNome(),
                funcionarioEntity.getCpf(),
                funcionarioEntity.getSenha(),
                funcionarioEntity.getEmail(),
                funcionarioEntity.getCargo(),
                funcionarioEntity.getNivelPermissao(),
                funcionarioEntity.getRegistradoEm(),
                funcionarioEntity.getAlteradoEm()
        );
    }

    public FuncionarioEntity toPersistence(FuncionarioAggregate funcionarioAggregate)
    {
        return new FuncionarioEntity(
            funcionarioAggregate.getId(),
            funcionarioAggregate.getNome(),
            funcionarioAggregate.getCpf(),
            funcionarioAggregate.getSenha(),
            funcionarioAggregate.getEmail(),
            funcionarioAggregate.getNivelPermissao(),
            funcionarioAggregate.getRegistradoEm(),
            funcionarioAggregate.getAlteradoEm(),
            funcionarioAggregate.getCargo()
    );
    }
}
