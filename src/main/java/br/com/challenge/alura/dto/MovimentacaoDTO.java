package br.com.challenge.alura.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MovimentacaoDTO {

    @NotNull
    private String descricao;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private LocalDate data;
}
