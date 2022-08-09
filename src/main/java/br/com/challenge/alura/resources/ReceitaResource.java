package br.com.challenge.alura.resources;

import br.com.challenge.alura.dto.ReceitaDTO;
import br.com.challenge.alura.entities.Receita;
import br.com.challenge.alura.service.ReceitaService;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaResource extends AbstractMovimentacaoResource<Receita, ReceitaDTO, ReceitaService>{

    public ReceitaResource() {
        super(Receita.class, ReceitaDTO.class);
    }

    @Override
    protected Type getTypeFindAll() {
        return new TypeToken<List<ReceitaDTO>>(){}.getType();
    }
}
