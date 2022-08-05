package br.com.challenge.alura.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "M_RECEITA", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"DESCRICAO", "MES"})
})
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_RECEITA")
    private Long id;

    @NotNull
    @Column(name = "VALOR", precision = 16, scale = 2)
    @DecimalMax(value = "99999999999999.99")
    @DecimalMin(value = "0.00")
    private BigDecimal valor;

    @NotNull
    @Column(name = "DATA")
    private LocalDate data;

    @NotBlank
    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "MES")
    private int mes;
}
