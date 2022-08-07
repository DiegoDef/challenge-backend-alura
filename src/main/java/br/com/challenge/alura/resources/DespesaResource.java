package br.com.challenge.alura.resources;

import br.com.challenge.alura.dto.DespesaDTO;
import br.com.challenge.alura.entities.Despesa;
import br.com.challenge.alura.service.DespesaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/despesas")
public class DespesaResource extends AbstractMovimentacaoResource<Despesa, DespesaDTO, DespesaService>{

    public DespesaResource() {
        super(Despesa.class, DespesaDTO.class);
    }
}
