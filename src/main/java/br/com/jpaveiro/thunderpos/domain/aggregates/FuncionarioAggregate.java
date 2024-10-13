package br.com.jpaveiro.thunderpos.domain.aggregates;

import br.com.jpaveiro.thunderpos.domain.enums.ECargo;
import br.com.jpaveiro.thunderpos.domain.enums.ENivelPermissao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioAggregate {
    private String id;
    private String nome;
    private String cpf;
    private String senha;
    private String email;
    private ECargo cargo;
    private ENivelPermissao nivelPermissao;
    private LocalDateTime registradoEm;
    private LocalDateTime alteradoEm;

    public FuncionarioAggregate(String nome, String senha, String email, ECargo cargo, ENivelPermissao nivelPermissao, String cpf) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cargo = cargo;
        this.nivelPermissao = nivelPermissao;
        this.cpf = cpf;
    }
}
