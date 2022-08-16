package br.com.challenge.alura.service;

import br.com.challenge.alura.entities.Receita;
import br.com.challenge.alura.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReceitaService extends AbstractMovimentacaoService<Receita, ReceitaRepository> {

    @Override
    public List<Receita> getFindAllByDescricao(String descricao) {
        return repository.findAllByDescricaoIgnoreCaseContaining(descricao);
    }

    @Override
    public List<Receita> findAllByDataBetween(LocalDate firstDay, LocalDate lastDay) {
        return repository.findAllByDataBetween(firstDay, lastDay);
    }
}
