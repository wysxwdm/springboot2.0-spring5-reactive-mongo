package com.ishare888.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ishare888.model.TestReactive;
import com.ishare888.repository.TestReactiveRepository;
import com.ishare888.service.TestReactiveService;

import reactor.core.publisher.Mono;

@Service
public class TestReactServiceImpl implements TestReactiveService {

	@Autowired
	private TestReactiveRepository testReactiveRepository;

	@Override
	public Mono<ServerResponse> getAll(ServerRequest request) {
		return ServerResponse.ok().body(testReactiveRepository.getAll(), TestReactive.class);
	}

	@Override
	public Mono<ServerResponse> getById(ServerRequest request) {
		return testReactiveRepository.getById(request.pathVariable("id"))
				.flatMap(testReactive -> ServerResponse.ok().body(Mono.just(testReactive), TestReactive.class))
				.switchIfEmpty(ServerResponse.notFound().build());
	}
	
}
