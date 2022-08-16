package br.com.challenge.alura.repository;

import br.com.challenge.alura.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findAllByDescricaoIgnoreCaseContaining(String descricao);

    List<Despesa> findAllByDataBetween(LocalDate firstDay, LocalDate lastDay);
}