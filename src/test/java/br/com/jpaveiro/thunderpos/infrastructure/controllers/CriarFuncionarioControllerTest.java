package br.com.jpaveiro.thunderpos.infrastructure.controllers;

import br.com.jpaveiro.thunderpos.domain.core.StandardResponse;
import br.com.jpaveiro.thunderpos.domain.enums.ECargo;
import br.com.jpaveiro.thunderpos.infrastructure.controllers.Funcionario.CriarFuncionarioController;
import br.com.jpaveiro.thunderpos.infrastructure.dtos.CriarFuncionarioDTO;
import br.com.jpaveiro.thunderpos.infrastructure.entities.FuncionarioEntity;
import br.com.jpaveiro.thunderpos.infrastructure.repositories.FuncionarioRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class CriarFuncionarioControllerTest {
    private final Logger LOGGER = LoggerFactory.getLogger(CriarFuncionarioControllerTest.class);

    @Autowired
    private CriarFuncionarioController controller;

    @Autowired
    private FuncionarioRepository repository;

    private final CriarFuncionarioDTO dto;

    private FuncionarioEntity funcionarioCriado;

    public CriarFuncionarioControllerTest() {
        this.dto = CriarFuncionarioDTO.builder()
                .nome("Jonathan Joestar")
                .cpf("123.456.789-10")
                .senha("Jojo24@123")
                .email("example@example.com")
                .cargo(ECargo.OPERADOR_CAIXA)
                .build();
    }

    @Test
    @DisplayName("Should create a new user.")
    void perform() throws Exception
    {
        ResponseEntity<StandardResponse> response = controller.perform(dto);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        Assertions.assertTrue(response.hasBody());

        Optional<FuncionarioEntity> funcionario = repository.findByCpfAndEmail(dto.cpf(), dto.email());

        if (funcionario.isEmpty())
        {
            String message = "Test failed: Funcionario not found for CPF " + dto.cpf() + " and Email " + dto.email();
            LOGGER.error(message);
            throw new Exception(message);
        }

        funcionarioCriado = funcionario.get();
    }

    @AfterEach
    void tearDown()
    {
        repository.delete(funcionarioCriado);
        LOGGER.warn("Funcionário com CPF " + funcionarioCriado.getCpf() + " foi removido após o teste.");
    }
}
