package br.com.jpaveiro.thunderpos.domain.enums;

import lombok.Getter;

@Getter
public enum ECargo {
    OPERADOR_CAIXA("Operador de Caixa", 1412.00);

    private final String nomeFuncao;
    private final double salario;

    ECargo(String nomeFuncao, double salario)
    {
        this.nomeFuncao = nomeFuncao;
        this.salario = salario;
    }
}
