package br.com.jpaveiro.thunderpos.infrastructure.entities;

import br.com.jpaveiro.thunderpos.domain.enums.ENivelPermissao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "tb_usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, nullable = false)
    private String id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(
            length = 14,
            unique = true,
            nullable = true,
            updatable = false

    )
    private String cpf;

    @Column(length = 50, nullable = false)
    private String senha;

    @Column(length = 70, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_permissao", nullable = false)
    private ENivelPermissao nivelPermissao;

    @CreationTimestamp
    @Column(name = "registrado_em")
    private LocalDateTime registradoEm;

    @UpdateTimestamp
    @Column(name = "mudado_em")
    private LocalDateTime alteradoEm;
}
