package com.example.detalhes.repository;

import com.example.detalhes.models.DetalhesPersonagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DetalhesPersonagemRepository extends JpaRepository<DetalhesPersonagem, Long> {

    Optional<DetalhesPersonagem> findByPersonagemId(Long id);
}
