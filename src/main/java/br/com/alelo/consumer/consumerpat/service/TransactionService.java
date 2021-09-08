package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.Card;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.entity.Extract;
import br.com.alelo.consumer.consumerpat.respository.CardRepository;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    CardService cardService;

    @Autowired
    ExtractService extractService;

    public void buy(int establishmentType, String establishmentName, long cardNumber, String productDescription, double value) {
        /* O valores só podem ser debitados dos cartões com os tipos correspondentes ao tipo do estabelecimento da compra.
         *  Exemplo: Se a compra é em um estabelecimeto de Alimentação(food) então o valor só pode ser debitado do cartão e alimentação
         *
         * Tipos de estabelcimentos
         * 1 - Alimentação (food)
         * 2 - Farmácia (DrugStore)
         * 3 - 'Posto de combustivel (Fuel)'
         */
        Card card = cardService.getByNumberAndType(cardNumber, establishmentType);
        Double finalValue = value * card.getCardType().getTax();
        cardService.updateBalance(card, finalValue);

        extractService.addTransaction(card, establishmentName, productDescription, finalValue);
    }

}
