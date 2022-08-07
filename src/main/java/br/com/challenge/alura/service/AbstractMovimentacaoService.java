package br.com.challenge.alura.service;

import br.com.challenge.alura.entities.Movimentacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public abstract class AbstractMovimentacaoService<T extends Movimentacao, R extends JpaRepository<T, Long>> {

    @Autowired
    private R repository;

    public T insert(T entidade){
        return repository.save(entidade);
    }

    public T update(T entidade) {
        return repository.save(entidade);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<T> findall() {
        return repository.findAll();
    }

    public T findById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }
}