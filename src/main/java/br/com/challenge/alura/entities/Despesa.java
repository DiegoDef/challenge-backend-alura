package br.com.challenge.alura.entities;

import br.com.challenge.alura.enums.Categoria;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "M_DESPESA", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"DESCRICAO", "MES_ANO"})
})
public class Despesa extends Movimentacao {

    @NotNull
    @Column(name = "CATEGORIA")
    @Enumerated(value = EnumType.STRING)
    private Categoria categoria;
}
