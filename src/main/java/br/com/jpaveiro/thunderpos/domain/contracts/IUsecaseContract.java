package br.com.jpaveiro.thunderpos.domain.contracts;

public interface IUsecaseContract<Input, T> {
    T run(Input dto);
}
