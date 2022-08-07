package br.com.challenge.alura.resources;

import br.com.challenge.alura.dto.MovimentacaoDTO;
import br.com.challenge.alura.entities.Movimentacao;
import br.com.challenge.alura.service.AbstractMovimentacaoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractMovimentacaoResource<T extends Movimentacao, R extends MovimentacaoDTO, F extends AbstractMovimentacaoService<T, ?>> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private F service;

    private final Class<T> classeEntidade;

    private final Class<R> classeDto;

    protected AbstractMovimentacaoResource(Class<T> classeEntidade, Class<R> classeDto) {
        this.classeEntidade = classeEntidade;
        this.classeDto = classeDto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public R insert(@Valid @RequestBody R dto) {
        T entidade = modelMapper.map(dto, classeEntidade);
        return modelMapper.map(this.service.insert(entidade), classeDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public R update(@PathVariable("id") Long entidadeId, @Valid @RequestBody R dto) {
        T entidade = modelMapper.map(dto, classeEntidade);
        entidade.setId(entidadeId);
        return modelMapper.map(this.service.update(entidade), classeDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable() Long id) {
        this.service.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<T> findAll() {
        Type listType = new TypeToken<List<R>>(){}.getType();
        return modelMapper.map(this.service.findall(), listType);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @RequestMapping("/{id}")
    public R find(@PathVariable Long id) {
        return modelMapper.map(this.service.findById(id), classeDto);
    }
}
