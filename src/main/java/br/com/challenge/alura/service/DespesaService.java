package br.com.challenge.alura.service;

import br.com.challenge.alura.entities.Despesa;
import br.com.challenge.alura.enums.Categoria;
import br.com.challenge.alura.repository.DespesaRepository;
import org.springframework.stereotype.Service;

@Service
public class DespesaService extends AbstractMovimentacaoService<Despesa, DespesaRepository> {

    @Override
    public Despesa insert(Despesa entidade) {
        if (entidade.getCategoria() == null) {
            entidade.setCategoria(Categoria.OUTRAS);
        }
        return super.insert(entidade);
    }
}
