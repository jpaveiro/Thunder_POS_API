package br.com.jpaveiro.thunderpos.domain.contracts;

import org.springframework.http.ResponseEntity;

public interface IControllerContract<Input, Output> {
    ResponseEntity<Output> perform(Input dto);
}