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
    protected R repository;

    protected abstract List<T> getFindAllByDescricao(String descricao);

    public T insert(T entidade) {
        this.setMesAno(entidade);
        return repository.save(entidade);
    }

    public T update(T entidade) {
        this.setMesAno(entidade);
        return repository.save(entidade);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public List<T> findAll(String descricao) {
        return this.getFindAllByDescricao(descricao);
    }


    public T findById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    private void setMesAno(T entidade) {
        String ano = Long.toString(entidade.getData().getYear());
        String mes = Long.toString(entidade.getData().getMonth().getValue());
        entidade.setMesAno(mes + "/" + ano);
    }
}
