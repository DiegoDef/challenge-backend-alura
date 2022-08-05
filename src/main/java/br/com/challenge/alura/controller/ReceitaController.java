package br.com.challenge.alura.controller;

import br.com.challenge.alura.dto.ReceitaDTO;
import br.com.challenge.alura.entities.Receita;
import br.com.challenge.alura.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Transactional
    public Receita insert(@Valid @RequestBody ReceitaDTO receitaDTO) {
        return receitaService.insert(receitaDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @Transactional
    public String find() {
        return "receitaService.insert(receitaDTO)";
    }
}
