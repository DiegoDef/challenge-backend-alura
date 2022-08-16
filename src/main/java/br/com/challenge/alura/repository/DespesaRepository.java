package br.com.challenge.alura.repository;

import br.com.challenge.alura.entities.Despesa;
import br.com.challenge.alura.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findAllByDescricaoIgnoreCaseContaining(String descricao);

    List<Despesa> findAllByDataBetween(LocalDate firstDay, LocalDate lastDay);

    Set<Despesa> findAllByCategoriaAndDataBetween(Categoria categoria, LocalDate firstDay, LocalDate lastDay);
}