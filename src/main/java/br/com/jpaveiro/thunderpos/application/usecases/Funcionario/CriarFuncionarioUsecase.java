package br.com.jpaveiro.thunderpos.application.usecases.Funcionario;

import br.com.jpaveiro.thunderpos.application.mappers.FuncionarioMapper;
import br.com.jpaveiro.thunderpos.application.utils.Utils;
import br.com.jpaveiro.thunderpos.domain.aggregates.FuncionarioAggregate;
import br.com.jpaveiro.thunderpos.domain.contracts.IUsecaseContract;
import br.com.jpaveiro.thunderpos.domain.enums.ENivelPermissao;
import br.com.jpaveiro.thunderpos.infrastructure.dtos.Funcionario.CriarFuncionarioDTO;
import br.com.jpaveiro.thunderpos.infrastructure.entities.FuncionarioEntity;
import br.com.jpaveiro.thunderpos.infrastructure.repositories.FuncionarioRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class CriarFuncionarioUsecase implements IUsecaseContract<CriarFuncionarioDTO, Void> {
    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public CriarFuncionarioUsecase(FuncionarioRepository repository, FuncionarioMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Void run(CriarFuncionarioDTO dto) {
        if (repository.existsByEmailOrCpf(dto.email(), dto.cpf()))
        {
            throw new EntityExistsException();
        }
        else if (!Utils.validarEmail(dto.email()))
        {
            throw new InvalidParameterException("email");
        }

        FuncionarioAggregate aggregate = new FuncionarioAggregate(
                dto.nome(),
                dto.senha(),
                dto.email(),
                dto.cargo(),
                ENivelPermissao.PADRAO,
                dto.cpf()
        );

        FuncionarioEntity entity = mapper.toPersistence(aggregate);
        repository.save(entity);

        return null;
    }
}
