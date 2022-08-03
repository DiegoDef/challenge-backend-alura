package br.com.challenge.alura.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "M_DESPESA")
public class Despesa extends AbstractMovimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_DESPESA")
    private Long id;
}
