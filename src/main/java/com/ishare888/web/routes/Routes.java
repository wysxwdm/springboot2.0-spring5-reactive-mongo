package com.ishare888.web.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import com.ishare888.service.TestReactiveService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class Routes {
	
	private TestReactiveService testReactiveService;

	@Bean
	public RouterFunction<?> routerFunction() {
		return
				route(GET("/api/testReactive").and(accept(MediaType.APPLICATION_JSON)), testReactiveService::getAll)
				.and(route(GET("/api/testReactive/{id}").and(accept(MediaType.APPLICATION_JSON)), testReactiveService::getById))
				;
	}

}
