package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.dto.ConsumerCreate;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository repository;


    public List<Consumer> listAll() {
        return repository.findAll();
    }


    public void create(@RequestBody ConsumerCreate consumerCreate) {
        Consumer consumer = new Consumer(consumerCreate);
        repository.save(consumer);
    }


    public void update(@RequestBody Consumer consumer) {
        Consumer consumerFromDb = repository.findById(consumer.getId()).orElseThrow();
        consumerFromDb.updateData(consumer);
        repository.save(consumer);
    }

}
