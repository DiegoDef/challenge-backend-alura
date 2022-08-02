package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "M_DESPESA")
public class Despesa extends AbstractMovimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_DESPESA")
    private Long id;
}
