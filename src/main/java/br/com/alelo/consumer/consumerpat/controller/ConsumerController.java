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
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Consumer> listAll() {
        return service.listAll();
    }


    /* Cadastrar novos clientes */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody Consumer consumer) {
        service.create(consumer);
    }


    // Não deve ser possível alterar o saldo do cartão
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void updateConsumer(@RequestBody Consumer consumer) {
        service.update(consumer);
    }

}
