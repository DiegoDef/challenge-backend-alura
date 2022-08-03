package br.com.challenge.alura.Resources;

import br.com.challenge.alura.DTO.ReceitaDTO;
import br.com.challenge.alura.entities.Receita;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ReceitaResource {

    @PostMapping("/receitas")
    public Receita insert(@Valid @RequestBody ReceitaDTO receitaDTO) {
        return null;
    }
}
