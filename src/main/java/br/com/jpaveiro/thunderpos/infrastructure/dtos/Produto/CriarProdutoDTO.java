package br.com.jpaveiro.thunderpos.infrastructure.dtos.Produto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CriarProdutoDTO(
    @NotNull(message = "Erro! Nome não preenchido.") @NotEmpty(message = "Erro! Nome não preenchido.") String nome,
    @NotNull(message = "Erro! Funcionário que registrou não preenchido.") @NotEmpty(message = "Erro! Funcionário que registrou não preenchido.") String registradoPor)
{
}
