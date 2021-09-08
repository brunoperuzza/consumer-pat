package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.Card;
import br.com.alelo.consumer.consumerpat.entity.Extract;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ExtractService {

    @Autowired
    ExtractRepository repository;


    public void addTransaction(Card card, String establishmentName, String productDescription, double value) {

        Extract extract = new Extract(card, establishmentName, productDescription, value);
        repository.save(extract);
    }

}
