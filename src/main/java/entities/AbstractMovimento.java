package entities;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AbstractMovimento {

    @NotBlank
    @Column(name = "DESCRICAO")
    private String descricao;

    @NotNull
    @Column(name = "VALOR", precision = 16, scale = 2)
    @DecimalMax(value = "99999999999999.99")
    @DecimalMin(value = "0.00")
    private BigDecimal valor;

    @NotNull
    @Column(name = "DATA")
    private LocalDate data;

}
