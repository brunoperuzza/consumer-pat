package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.Card;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.entity.Extract;
import br.com.alelo.consumer.consumerpat.respository.CardRepository;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository repository;


    public void addValue(long cardNumber, double value, long typeId) {
        Card card = this.getByNumberAndType(cardNumber, typeId);

        if(card != null) {
            card.addValue(value);
            repository.save(card);
        }
    }

    public Card getByNumberAndType(long cardNumber, long typeId) {
        // TODO - tratamento de erros
        return repository.findByNumberAndType(cardNumber, typeId);
    }

    public void updateBalance(Card card, Double value) {
        card.setBalance(card.getBalance() - value);
        repository.save(card);
    }
}
