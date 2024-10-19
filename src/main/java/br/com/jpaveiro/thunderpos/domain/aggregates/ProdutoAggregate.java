package br.com.jpaveiro.thunderpos.domain.aggregates;

import br.com.jpaveiro.thunderpos.infrastructure.entities.FuncionarioEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoAggregate {
    private String id;
    private String nome;
    private FuncionarioEntity registradoPor;
    private LocalDateTime registradoEm;
    private LocalDateTime alteradoEm;

    public ProdutoAggregate(String nome, FuncionarioEntity registradoPor)
    {
        this.nome = nome;
        this.registradoPor = registradoPor;
    }
}
