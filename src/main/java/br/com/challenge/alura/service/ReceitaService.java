package br.com.challenge.alura.service;

import br.com.challenge.alura.dto.ReceitaDTO;
import br.com.challenge.alura.entities.Receita;
import br.com.challenge.alura.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita insert(ReceitaDTO receitaDTO){
        Receita receita = this.popularReceita(receitaDTO);
        return receitaRepository.save(receita);
    }

    public Receita popularReceita(@NotNull ReceitaDTO receitaDTO) {
        Receita receita = new Receita();
        receita.setDescricao(receitaDTO.getDescricao());
        receita.setValor(receitaDTO.getValor());
        receita.setData(receitaDTO.getData());
        receita.setMes(receita.getData().getMonth().getValue());
        return receita;
    }
}
