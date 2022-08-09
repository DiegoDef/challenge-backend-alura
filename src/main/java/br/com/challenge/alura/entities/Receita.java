package br.com.challenge.alura.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "M_RECEITA", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"DESCRICAO", "MES_ANO"})
})
public class Receita extends Movimentacao {
}
