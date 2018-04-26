package com.ishare888.web.webclient;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.alibaba.fastjson.JSON;
import com.ishare888.model.TestReactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 注：在springboot项目启动的情况下测试，否则会访问不了
 * @author wsc
 *
 */
public class TestLocalWebclient {
	

	public static void getUsers() {
		Flux<TestReactive> flux = WebClient.create("http://localhost:80").get().uri("/api/testReactive")
		.accept(MediaType.APPLICATION_JSON).exchange().block().bodyToFlux(TestReactive.class);
//		System.out.println(JSON.toJSONString(flux));
		List<TestReactive> list = flux.collectList().block();
		System.out.println("all=" + JSON.toJSONString(list));
		
	}
	
	public static void getUserById() {
		Mono<TestReactive> mono = WebClient.create("http://localhost:80").get().uri("/api/testReactive/1")
		.accept(MediaType.ALL).exchange().block().bodyToMono(TestReactive.class);
//		System.out.println(JSON.toJSONString(mono));
		TestReactive testReactive = mono.block();
		System.out.println("byId=" + JSON.toJSONString(testReactive));
	}
	
	public static void test() {
		Mono<ServerResponse> map = WebClient.create("http://localhost:80").get().uri("/api/testReactive")
				.accept(MediaType.APPLICATION_JSON).exchange().flatMap(resp -> ServerResponse.ok().body(resp.bodyToFlux(TestReactive.class), TestReactive.class));
		System.out.println(map.toString());
	}
	
	public static void main(String[] args) {
		getUsers();
		getUserById();
		test();
	}

}
