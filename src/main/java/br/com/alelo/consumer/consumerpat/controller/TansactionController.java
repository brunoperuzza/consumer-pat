package br.com.alelo.consumer.consumerpat.controller;

import br.com.alelo.consumer.consumerpat.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/transaction")
public class TansactionController {

    @Autowired
    TransactionService service;


    @ResponseBody
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public void buy(int establishmentType, String establishmentName, long cardNumber, String productDescription, double value) {
        service.buy(establishmentType, establishmentName, cardNumber, productDescription, value);
    }

}
