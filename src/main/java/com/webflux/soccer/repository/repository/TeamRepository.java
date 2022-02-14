package com.webflux.soccer.repository.repository;

import com.webflux.soccer.repository.entities.TeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<TeamEntity, String> {
}
