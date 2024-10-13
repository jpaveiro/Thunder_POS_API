package br.com.jpaveiro.thunderpos.application.usecases;

import br.com.jpaveiro.thunderpos.domain.contracts.IUsecaseContract;
import br.com.jpaveiro.thunderpos.infrastructure.entities.FuncionarioEntity;
import br.com.jpaveiro.thunderpos.infrastructure.repositories.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletarFuncionarioUsecase implements IUsecaseContract<String, Void> {
    private final FuncionarioRepository repository;

    public DeletarFuncionarioUsecase(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void run(String id) {
        Optional<FuncionarioEntity> entity = repository.findById(id);

        entity.ifPresentOrElse(
                repository::delete,
                () -> { throw new EntityNotFoundException(); }

        );
        return null;
    }
}
