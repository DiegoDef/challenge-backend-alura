package br.com.challenge.alura.resources;

import br.com.challenge.alura.dto.ReceitaDTO;
import br.com.challenge.alura.entities.Receita;
import br.com.challenge.alura.service.ReceitaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receitas")
public class ReceitaResource extends AbstractMovimentacaoResource<Receita, ReceitaDTO, ReceitaService>{

    public ReceitaResource() {
        super(Receita.class, ReceitaDTO.class);
    }
}
