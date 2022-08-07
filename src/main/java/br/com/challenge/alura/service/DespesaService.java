package br.com.challenge.alura.service;

import br.com.challenge.alura.entities.Despesa;
import br.com.challenge.alura.repository.DespesaRepository;
import org.springframework.stereotype.Service;

@Service
public class DespesaService extends AbstractMovimentacaoService<Despesa, DespesaRepository> {
}
