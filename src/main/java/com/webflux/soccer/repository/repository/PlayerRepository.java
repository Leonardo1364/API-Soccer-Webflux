package com.webflux.soccer.repository.repository;

import com.webflux.soccer.repository.entity.PlayerEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends ReactiveMongoRepository<PlayerEntity, String> {
}
