package br.com.jpaveiro.thunderpos.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_produtos")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, nullable = false)
    private String id;

    @Column(nullable = false, length = 150)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private FuncionarioEntity registradoPor;

    @CreationTimestamp
    @Column(name = "registrado_em")
    private LocalDateTime registradoEm;

    @UpdateTimestamp
    @Column(name = "mudado_em")
    private LocalDateTime alteradoEm;
}
