package br.com.challenge.alura.resources;

import br.com.challenge.alura.dto.ResumoMesDTO;
import br.com.challenge.alura.service.ResumoPorMesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resumo")
public class ResumoPorMesResource {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResumoPorMesService resumoPorMesService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    @RequestMapping("/{ano}/{mes}")
    public ResumoMesDTO obterResumoMes(@PathVariable int ano, @PathVariable int mes) {
        return this.resumoPorMesService.obterResumoDoMes(ano, mes);
    }
}
