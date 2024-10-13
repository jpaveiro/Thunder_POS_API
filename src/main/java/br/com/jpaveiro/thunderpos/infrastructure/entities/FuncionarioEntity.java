package br.com.jpaveiro.thunderpos.infrastructure.entities;

import br.com.jpaveiro.thunderpos.domain.enums.ECargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_funcionarios")
public class FuncionarioEntity extends UsuarioEntity {
    private ECargo cargo;

    @OneToMany(mappedBy = "funcionario")
    private Set<VendaEntity> vendasFeitas;

    @OneToMany(mappedBy = "registradoPor")
    private Set<ProdutoEntity> produtosCriados;
}
