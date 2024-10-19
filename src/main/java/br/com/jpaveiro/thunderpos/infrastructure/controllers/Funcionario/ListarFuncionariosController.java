package br.com.jpaveiro.thunderpos.infrastructure.controllers.Funcionario;

import br.com.jpaveiro.thunderpos.application.usecases.Funcionario.ListarFuncionariosUseCase;
import br.com.jpaveiro.thunderpos.domain.contracts.IControllerContract;
import br.com.jpaveiro.thunderpos.domain.models.FuncionarioSecureDataModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
public class ListarFuncionariosController implements IControllerContract<Integer, List<FuncionarioSecureDataModel>> {
    private final ListarFuncionariosUseCase usecase;

    public ListarFuncionariosController(final ListarFuncionariosUseCase usecase) {
        this.usecase = usecase;
    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioSecureDataModel>> perform(@RequestParam Integer number)
    {
        if (number <= 0)
            throw new InvalidParameterException("number");

        return ResponseEntity.status(HttpStatus.OK)
                .body(usecase.run(number));
    }
}
