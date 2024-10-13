package br.com.jpaveiro.thunderpos.infrastructure.repositories;

import br.com.jpaveiro.thunderpos.infrastructure.entities.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, String> {
    Boolean existsByEmailOrCpf(String email, String cpf);
}
