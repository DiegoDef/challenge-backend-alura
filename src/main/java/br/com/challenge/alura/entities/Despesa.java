package br.com.challenge.alura.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "M_DESPESA")
public class Despesa extends Movimentacao {
}
