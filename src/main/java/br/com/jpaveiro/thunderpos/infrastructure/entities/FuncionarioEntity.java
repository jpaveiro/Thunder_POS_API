package br.com.jpaveiro.thunderpos.infrastructure.entities;

import br.com.jpaveiro.thunderpos.domain.enums.ECargo;
import br.com.jpaveiro.thunderpos.domain.enums.ENivelPermissao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_funcionarios")
public class FuncionarioEntity extends UsuarioEntity {
    @Enumerated(EnumType.STRING)
    private ECargo cargo;

    @OneToMany(mappedBy = "funcionario")
    private Set<VendaEntity> vendasFeitas;

    @OneToMany(mappedBy = "registradoPor")
    private Set<ProdutoEntity> produtosCriados;

    public FuncionarioEntity(String id, String nome, String cpf, String senha, String email, ENivelPermissao nivelPermissao, LocalDateTime registradoEm, LocalDateTime alteradoEm, ECargo cargo) {
        super(id, nome, cpf, senha, email, nivelPermissao, registradoEm, alteradoEm);
        this.cargo = cargo;
    }
}
