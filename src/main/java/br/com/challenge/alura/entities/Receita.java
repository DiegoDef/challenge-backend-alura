package br.com.challenge.alura.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "M_RECEITA")
public class Receita extends Movimentacao {
}
