package br.com.challenge.alura.service;

import br.com.challenge.alura.entities.Receita;
import br.com.challenge.alura.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService extends AbstractMovimentacaoService<Receita, ReceitaRepository> {

    @Override
    protected List<Receita> getFindAllByDescricao(String descricao) {
        return repository.findAllByDescricaoIgnoreCaseContaining(descricao);
    }
}
