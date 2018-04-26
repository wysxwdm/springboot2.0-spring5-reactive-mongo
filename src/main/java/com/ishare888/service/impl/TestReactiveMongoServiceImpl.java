package com.ishare888.service.impl;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ishare888.model.TestReactiveMongo;
import com.ishare888.repository.TestReactiveMongoRepository;
import com.ishare888.service.TestReactiveMongoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TestReactiveMongoServiceImpl implements TestReactiveMongoService {

	@Autowired
    private TestReactiveMongoRepository testReactiveMongoRepository;

	@Override
    public Flux<TestReactiveMongo> findAll() {
        return testReactiveMongoRepository.findAll();
    }
    
    @Override
    public Mono<ResponseEntity<TestReactiveMongo>> getById(@NotNull String id) {
        
    	return testReactiveMongoRepository.findById(id)
                .map(testReactiveMongo -> ResponseEntity.ok(testReactiveMongo))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    public Mono<TestReactiveMongo> save(@Valid TestReactiveMongo testReactiveMongo) {
    	
    	testReactiveMongo.setCreatedAt(new Date());
        return testReactiveMongoRepository.save(testReactiveMongo);
    }

    @Override
    public Mono<ResponseEntity<TestReactiveMongo>> update(@NotNull String id, @Valid TestReactiveMongo testReactiveMongo) {
        
    	return testReactiveMongoRepository.findById(id)
                .flatMap(existing -> {
                	existing.setText(testReactiveMongo.getText());
                    return testReactiveMongoRepository.save(existing);
                })
                .map(update -> new ResponseEntity<>(update, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public Mono<ResponseEntity<Void>> delete(@NotNull String id) {

        return testReactiveMongoRepository.findById(id)
                .flatMap(existing ->
                        testReactiveMongoRepository.delete(existing)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                //.onErrorReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND))
                //.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND))
                ;
    }

	
}
