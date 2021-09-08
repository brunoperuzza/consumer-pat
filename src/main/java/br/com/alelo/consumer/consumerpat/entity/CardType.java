package br.com.alelo.consumer.consumerpat.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;


@Data
@Entity
public class CardType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    // tax é referente ao cashback ou aumento de valor para a compra. Valor positivo é aumento, valor negativo é cashback.
    double tax;

}
