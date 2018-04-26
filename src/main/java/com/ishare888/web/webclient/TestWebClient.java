package com.ishare888.web.webclient;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.ishare888.model.TestReactive;

import reactor.core.publisher.Mono;

public class TestWebClient {

	public static void main(String[] args) {
		Mono<ClientResponse> mono = WebClient.create("https://baidu.com").get().uri("/s").accept(MediaType.ALL).exchange();
		ClientResponse response = mono.block();
		response.bodyToFlux(TestReactive.class);
	}
	
}
