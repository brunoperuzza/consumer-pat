package br.com.alelo.consumer.consumerpat.controller;

import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.entity.Extract;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import br.com.alelo.consumer.consumerpat.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ConsumerService service;


    /* Deve listar todos os clientes (cerca de 500) */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/consumerList", method = RequestMethod.GET)
    public List<Consumer> listAllConsumers() {
        return service.listAll();
    }


    /* Cadastrar novos clientes */
    @RequestMapping(value = "/createConsumer", method = RequestMethod.POST)
    public void createConsumer(@RequestBody Consumer consumer) {
        service.create(consumer);
    }

    // Não deve ser possível alterar o saldo do cartão
    @RequestMapping(value = "/updateConsumer", method = RequestMethod.POST)
    public void updateConsumer(@RequestBody Consumer consumer) {
        service.update(consumer);
    }


    /*
     * Deve creditar(adicionar) um valor(value) em um no cartão.
     * Para isso ele precisa indenficar qual o cartão correto a ser recarregado,
     * para isso deve usar o número do cartão(cardNumber) fornecido.
     */
    @RequestMapping(value = "/setcardbalance", method = RequestMethod.GET)
    public void setBalance(int cardNumber, double value) {
        service.setBalance(cardNumber, value);
    }

    @ResponseBody
    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public void buy(int establishmentType, String establishmentName, int cardNumber, String productDescription, double value) {
        service.buy(establishmentType, establishmentName, cardNumber, productDescription, value);
    }

}
