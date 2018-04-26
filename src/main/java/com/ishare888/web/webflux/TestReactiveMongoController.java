package com.ishare888.web.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ishare888.exception.NotFoundException;
import com.ishare888.model.TestReactiveMongo;
import com.ishare888.response.ErrorResponse;
import com.ishare888.service.TestReactiveMongoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

import javax.validation.Valid;

@RestController
@RequestMapping("/testReactiveMongo")
public class TestReactiveMongoController {

    @Autowired
    private TestReactiveMongoService testReactiveMongoService;
    
    @GetMapping("/getAll")
    public Flux<TestReactiveMongo> getAll() {
        return testReactiveMongoService.findAll();
    }

    @PostMapping("/add")
    public Mono<TestReactiveMongo> add(@Valid @RequestBody TestReactiveMongo testReactiveMongo) {
    	testReactiveMongo.setCreatedAt(new Date());
        return testReactiveMongoService.save(testReactiveMongo);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<TestReactiveMongo>> getById(@PathVariable(value = "id", required = true) String id) {
        return testReactiveMongoService.getById(id);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<TestReactiveMongo>> update(@PathVariable(value = "id", required = true) String id,
                                                   @Valid @RequestBody TestReactiveMongo testReactiveMongo) {
        return testReactiveMongoService.update(id, testReactiveMongo);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable(value = "id", required = true) String id) {

        return testReactiveMongoService.delete(id);
    }

    //Sent to the client as Server Sent Events
    @GetMapping(value = "/streamAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TestReactiveMongo> streamAll() {
        return testReactiveMongoService.findAll();
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity handleDuplicateKeyException(DuplicateKeyException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("error"));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleTweetNotFoundException(NotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

}
