package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "M_RECEITA")
public class Receita extends AbstractMovimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_RECEITA")
    private Long id;
}
