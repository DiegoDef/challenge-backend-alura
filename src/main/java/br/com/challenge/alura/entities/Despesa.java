package br.com.challenge.alura.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "M_DESPESA", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"DESCRICAO", "MES_ANO"})
})
public class Despesa extends Movimentacao {
}
