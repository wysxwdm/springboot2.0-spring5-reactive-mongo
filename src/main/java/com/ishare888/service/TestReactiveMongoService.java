package com.ishare888.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;

import com.ishare888.model.TestReactiveMongo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TestReactiveMongoService {

	Mono<ResponseEntity<Void>> delete(@NotNull String id);

	Mono<ResponseEntity<TestReactiveMongo>> update(@NotNull String id, @Valid TestReactiveMongo testReactiveMongo);

	Mono<TestReactiveMongo> save(@Valid TestReactiveMongo testReactiveMongo);

	Mono<ResponseEntity<TestReactiveMongo>> getById(@NotNull String id);

	Flux<TestReactiveMongo> findAll();

}
