package br.com.challenge.alura.testes;

import br.com.challenge.alura.entities.Despesa;
import br.com.challenge.alura.entities.Receita;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CriacaoEntidades {

    public static void main(String[] args) {
        String descricao = "Descricao teste";
        BigDecimal valor = BigDecimal.valueOf(3000);
        LocalDate data = LocalDate.now();

        Receita receita = new Receita();
        receita.setDescricao(descricao);
        receita.setData(data);
        receita.setValor(valor);

        Despesa despesa = new Despesa();
        despesa.setDescricao(descricao + " 2");
        despesa.setValor(valor.add(BigDecimal.valueOf(2000)));
        despesa.setData(data);

        List.of(receita, despesa)
                .forEach(entity ->
                        System.out.println("Descrição: " + entity.getDescricao() +
                                "\nValor: " + entity.getValor() +
                                "\nData: " + entity.getData() + "\n")
                );
    }
}
