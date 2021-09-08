package br.com.alelo.consumer.consumerpat.dto;


import br.com.alelo.consumer.consumerpat.entity.Card;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
public class ConsumerCreate {

    String name;
    int documentNumber;
    Date birthDate;

    //contacts
    int mobilePhoneNumber;
    int residencePhoneNumber;
    int phoneNumber;
    String email;

    //Address
    String street;
    int number;
    String city;
    String country;
    int portalCode;

    //cards
    @OneToMany
    List<Card> cards;

}
