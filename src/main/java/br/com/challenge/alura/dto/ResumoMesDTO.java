package br.com.challenge.alura.dto;

import br.com.challenge.alura.enums.Categoria;
import lombok.Data;

import java.math.BigDecimal;
import java.util.EnumMap;

@Data
public class ResumoMesDTO {

    private BigDecimal totalReceitas;

    private BigDecimal totalDespesas;

    private BigDecimal saldoFinalDoMes;

    private EnumMap<Categoria, BigDecimal> gastoTotalPorCategoria;
}