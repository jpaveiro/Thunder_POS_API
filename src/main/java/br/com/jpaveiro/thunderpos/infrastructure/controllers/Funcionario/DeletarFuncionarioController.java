package br.com.jpaveiro.thunderpos.infrastructure.controllers.Funcionario;

import br.com.jpaveiro.thunderpos.application.usecases.Funcionario.DeletarFuncionarioUsecase;
import br.com.jpaveiro.thunderpos.domain.contracts.IControllerContract;
import br.com.jpaveiro.thunderpos.domain.core.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionario")
public class DeletarFuncionarioController implements IControllerContract<String, StandardResponse> {
    private final DeletarFuncionarioUsecase usecase;

    public DeletarFuncionarioController(final DeletarFuncionarioUsecase usecase) {
        this.usecase = usecase;
    }


    @Override
    @DeleteMapping("/deletar")
    public ResponseEntity<StandardResponse> perform(@RequestParam String id) {
        usecase.run(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new StandardResponse(
                        HttpStatus.OK,
                        "Sucesso! A entidade foi deletada."
                ));
    }
}
