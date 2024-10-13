package br.com.jpaveiro.thunderpos.domain.contracts;

import org.springframework.http.ResponseEntity;

public interface IUsecaseContract<Input, T> {
    T run(Input dto);
}
