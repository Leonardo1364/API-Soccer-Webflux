package com.webflux.soccer.repository.repository;

import com.webflux.soccer.repository.entity.TeamEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends ReactiveMongoRepository<TeamEntity, String> {
}
