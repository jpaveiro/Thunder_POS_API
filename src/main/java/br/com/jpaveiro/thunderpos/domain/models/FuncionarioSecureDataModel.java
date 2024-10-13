package br.com.jpaveiro.thunderpos.domain.models;

import br.com.jpaveiro.thunderpos.domain.enums.ECargo;
import br.com.jpaveiro.thunderpos.domain.enums.ENivelPermissao;
import br.com.jpaveiro.thunderpos.infrastructure.entities.FuncionarioEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioSecureDataModel {
    private String id;
    private String nome;
    private String cpf;
    private String email;
    private String funcao;
    private Double salario;
    private ENivelPermissao nivelPermissao;
    private LocalDateTime registradoEm;
    private LocalDateTime alteradoEm;
}
