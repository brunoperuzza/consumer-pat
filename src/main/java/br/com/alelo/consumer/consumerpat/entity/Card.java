package br.com.alelo.consumer.consumerpat.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Data
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Long number;
    Double balance;

    @ManyToOne
    CardType cardType;


    public void addValue(Double value) {
        this.balance += value;
    }
}
