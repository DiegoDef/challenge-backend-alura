package br.com.challenge.alura.dto;

import br.com.challenge.alura.enums.Categoria;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DespesaDTO extends MovimentacaoDTO {

    private Categoria categoria;
}