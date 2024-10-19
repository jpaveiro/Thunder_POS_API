package br.com.jpaveiro.thunderpos.application.usecases.Funcionario;

import br.com.jpaveiro.thunderpos.application.mappers.FuncionarioMapper;
import br.com.jpaveiro.thunderpos.domain.contracts.IUsecaseContract;
import br.com.jpaveiro.thunderpos.domain.models.FuncionarioSecureDataModel;
import br.com.jpaveiro.thunderpos.infrastructure.entities.FuncionarioEntity;
import br.com.jpaveiro.thunderpos.infrastructure.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarFuncionariosUseCase implements IUsecaseContract<Integer, List<FuncionarioSecureDataModel>> {
    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public ListarFuncionariosUseCase(FuncionarioRepository repository, FuncionarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<FuncionarioSecureDataModel> run(Integer number) {
        List<FuncionarioEntity> listaFuncionarios = repository.findAll();
        List<FuncionarioSecureDataModel> secureList = new ArrayList<>();

        for (FuncionarioEntity funcionario : listaFuncionarios) {
            if (secureList.size() == number) {
                break;
            }
            secureList.add(mapper.toSecureModel(funcionario));
        }
        return secureList;
    }
}
