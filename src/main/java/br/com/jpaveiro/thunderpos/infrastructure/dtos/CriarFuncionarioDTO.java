package br.com.jpaveiro.thunderpos.infrastructure.dtos;

import br.com.jpaveiro.thunderpos.domain.enums.ECargo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CriarFuncionarioDTO(
        @NotNull(message = "Erro! Nome não preenchido.") @NotEmpty(message = "Erro! Nome não preenchido.") String nome,
        @NotNull(message = "Erro! CPF não preenchido.") @NotEmpty(message = "Erro! CPF não preenchido.") String cpf,
        @NotNull(message = "Erro! Senha não preenchida.") @NotEmpty(message = "Erro! Senha não preenchida.") String senha,
        @NotNull(message = "Erro! E-mail não preenchido") @NotEmpty(message = "Erro! E-mail não preenchido.") String email,
        @NotNull(message = "Erro! Cargo não preenchido.") ECargo cargo
)
{

}
