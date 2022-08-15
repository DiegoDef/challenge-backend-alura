package br.com.challenge.alura.repository;

import br.com.challenge.alura.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findAllByDescricaoIgnoreCaseContaining(String descricao);
}