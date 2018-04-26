package com.ishare888.service;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface TestReactiveService {

	Mono<ServerResponse> getAll(ServerRequest request);

	Mono<ServerResponse> getById(ServerRequest request);
	
}
