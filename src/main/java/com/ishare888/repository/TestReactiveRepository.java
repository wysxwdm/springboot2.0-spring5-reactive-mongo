package com.ishare888.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ishare888.model.TestReactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TestReactiveRepository {

	private final List<TestReactive> list = Arrays.asList(new TestReactive(1L, "name1"), new TestReactive(2L, "name2"));

	public Mono<TestReactive> getById(String id) {
		return Mono.justOrEmpty(list.stream().filter(user -> {
			return user.getId().equals(Long.valueOf(id));
		}).findFirst().orElse(null));
	}

	public Flux<TestReactive> getAll() {
		return Flux.fromIterable(list);
	}

}
