package com.ishare888.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ishare888.model.TestReactiveMongo;

@Repository
public interface TestReactiveMongoRepository extends ReactiveMongoRepository<TestReactiveMongo, String> {

}
