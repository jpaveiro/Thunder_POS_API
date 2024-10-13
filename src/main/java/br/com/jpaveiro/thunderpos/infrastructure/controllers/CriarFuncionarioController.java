package br.com.jpaveiro.thunderpos.infrastructure.controllers;

import br.com.jpaveiro.thunderpos.application.usecases.CriarFuncionarioUsecase;
import br.com.jpaveiro.thunderpos.domain.contracts.IControllerContract;
import br.com.jpaveiro.thunderpos.domain.core.StandardResponse;
import br.com.jpaveiro.thunderpos.infrastructure.dtos.CriarFuncionarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionario")
public class CriarFuncionarioController implements IControllerContract<CriarFuncionarioDTO, StandardResponse> {
    private final CriarFuncionarioUsecase usecase;

    @Autowired
    public CriarFuncionarioController(CriarFuncionarioUsecase usecase)
    {
        this.usecase = usecase;
    }

    @PostMapping("/criar")
    public ResponseEntity<StandardResponse> perform(@Valid @RequestBody CriarFuncionarioDTO dto)
    {
        usecase.run(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new StandardResponse(
                        HttpStatus.ACCEPTED,
                        "Sucesso! O usuário foi criado.")
        );
    }

}
