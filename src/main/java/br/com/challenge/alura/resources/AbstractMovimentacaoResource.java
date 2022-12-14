package br.com.challenge.alura.resources;

import br.com.challenge.alura.dto.MovimentacaoDTO;
import br.com.challenge.alura.entities.Movimentacao;
import br.com.challenge.alura.service.AbstractMovimentacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public abstract class AbstractMovimentacaoResource<T extends Movimentacao, R extends MovimentacaoDTO, F extends AbstractMovimentacaoService<T, ?>> {

    @Autowired
    protected ModelMapper modelMapper;

    @Autowired
    protected F service;

    private final Class<T> entityClass;

    private final Class<R> dtoClass;

    protected AbstractMovimentacaoResource(Class<T> entityClass, Class<R> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    protected abstract Type getTypeFindAll();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public R insert(@Valid @RequestBody R dto) {
        T entidade = modelMapper.map(dto, entityClass);
        return modelMapper.map(this.service.insert(entidade), dtoClass);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public R update(@PathVariable("id") Long entidadeId, @Valid @RequestBody R dto) {
        T entidade = modelMapper.map(dto, entityClass);
        entidade.setId(entidadeId);
        return modelMapper.map(this.service.update(entidade), dtoClass);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable() Long id) {
        this.service.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<R> findAll(@RequestParam(required = false) String descricao) {
        if (descricao == null) {
            return modelMapper.map(this.service.findAll(), getTypeFindAll());
        }
        return modelMapper.map(this.service.findAll(descricao), getTypeFindAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @RequestMapping("/{id}")
    public R find(@PathVariable Long id) {
        return modelMapper.map(this.service.findById(id), dtoClass);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{ano}/{mes}")
    public List<R> findAllAnoMes(@PathVariable int ano, @PathVariable int mes) {
        LocalDate firstDay = LocalDate.of(ano, mes, 1).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDay = LocalDate.of(ano, mes, 1).with(TemporalAdjusters.lastDayOfMonth());

        return modelMapper.map(this.service.findAllByDataBetween(firstDay, lastDay), this.getTypeFindAll());
    }
}
