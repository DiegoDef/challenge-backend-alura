package br.com.challenge.alura.service;

import br.com.challenge.alura.dto.ResumoMesDTO;
import br.com.challenge.alura.entities.Movimentacao;
import br.com.challenge.alura.enums.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.EnumMap;

@Service
public class ResumoPorMesService {

    @Autowired
    private DespesaService despesaService;

    @Autowired
    private ReceitaService receitaService;


    public ResumoMesDTO obterResumoDoMes(int ano, int mes) {
        LocalDate firstDay = LocalDate.of(ano, mes, 1).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDay = LocalDate.of(ano, mes, 1).with(TemporalAdjusters.lastDayOfMonth());
        BigDecimal totalDespesas = this.getTotalDespesas(firstDay, lastDay);
        BigDecimal totalReceitas = this.getTotalReceitas(firstDay, lastDay);
        return this.popularResumoMesDTO(totalDespesas, totalReceitas, this.getGastoTotalPorCategoria(firstDay, lastDay));
    }

    private EnumMap<Categoria, BigDecimal> getGastoTotalPorCategoria(LocalDate firstDay, LocalDate lastDay) {
        EnumMap<Categoria, BigDecimal> gastoPorCategoria = new EnumMap<>(Categoria.class);
        for (Categoria cat : Categoria.values()) {
            BigDecimal totalDespesa = this.despesaService.findAllByCategoriaAndDataBetween(cat, firstDay, lastDay).stream()
                    .map(Movimentacao::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            gastoPorCategoria.put(cat, totalDespesa);
        }
        return gastoPorCategoria;
    }

    private BigDecimal getTotalReceitas(LocalDate firstDay, LocalDate lastDay) {
        return receitaService.findAllByDataBetween(firstDay, lastDay).stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getTotalDespesas(LocalDate firstDay, LocalDate lastDay) {
        return despesaService.findAllByDataBetween(firstDay, lastDay).stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private ResumoMesDTO popularResumoMesDTO(BigDecimal totalDespesas, BigDecimal totalReceitas, EnumMap<Categoria, BigDecimal> gastoTotalPorCategoria) {
        ResumoMesDTO resumoMes = new ResumoMesDTO();
        resumoMes.setTotalDespesas(totalDespesas);
        resumoMes.setTotalReceitas(totalReceitas);
        resumoMes.setSaldoFinalDoMes(totalReceitas.subtract(totalDespesas));
        resumoMes.setGastoTotalPorCategoria(gastoTotalPorCategoria);
        return resumoMes;
    }
}
