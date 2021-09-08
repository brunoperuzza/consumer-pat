package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.entity.Extract;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository repository;


    public List<Consumer> listAll() {
        return repository.findAll();
    }


    public void create(@RequestBody Consumer consumer) {
        repository.save(consumer);
    }


    public void update(@RequestBody Consumer consumer) {
        repository.save(consumer);
    }

}
