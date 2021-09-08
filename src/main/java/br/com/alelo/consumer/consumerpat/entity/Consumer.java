package br.com.alelo.consumer.consumerpat.entity;


import br.com.alelo.consumer.consumerpat.dto.ConsumerCreate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
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

    public Consumer(ConsumerCreate consumerCreate) {
        this.name = consumerCreate.getName();
        this.documentNumber = consumerCreate.getDocumentNumber();
        this.birthDate = consumerCreate.getBirthDate();
        this.mobilePhoneNumber = consumerCreate.getMobilePhoneNumber();
        this.residencePhoneNumber = consumerCreate.getResidencePhoneNumber();
        this.phoneNumber = consumerCreate.getPhoneNumber();
        this.email = consumerCreate.getEmail();
        this.street = consumerCreate.getStreet();
        this.number = consumerCreate.getNumber();
        this.city = consumerCreate.getCity();
        this.country = consumerCreate.getCountry();
        this.portalCode = consumerCreate.getPortalCode();
        this.cards = consumerCreate.getCards();
    }

    public void updateData(Consumer consumer) {
        // Não deve ser possível alterar o saldo do cartão
        this.name = consumer.getName();
        this.documentNumber = consumer.getDocumentNumber();
        this.birthDate = consumer.getBirthDate();
        this.mobilePhoneNumber = consumer.getMobilePhoneNumber();
        this.residencePhoneNumber = consumer.getResidencePhoneNumber();
        this.phoneNumber = consumer.getPhoneNumber();
        this.email = consumer.getEmail();
        this.street = consumer.getStreet();
        this.number = consumer.getNumber();
        this.city = consumer.getCity();
        this.country = consumer.getCountry();
        this.portalCode = consumer.getPortalCode();
    }
}
