package br.com.challenge.alura.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@MappedSuperclass
public abstract class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "VALOR")
    private BigDecimal valor;

    @NotNull
    @Column(name = "DATA")
    private LocalDate data;

    @NotBlank
    @Column(name = "DESCRICAO")
    private String descricao;
}
