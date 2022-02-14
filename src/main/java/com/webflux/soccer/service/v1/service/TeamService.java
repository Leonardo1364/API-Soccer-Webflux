package com.webflux.soccer.service.v1.service;

import com.webflux.soccer.repository.entity.TeamEntity;
import com.webflux.soccer.repository.repository.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/*@AllArgsConstructor
@NoArgsConstructor*/
@Service
public class TeamService {

    private static final String OBJECT_NOT_FOUND = "ID not found";

    @Autowired
    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamService() {}

    public Mono<TeamEntity> save(TeamEntity teamEntity) {
        return teamRepository.save(teamEntity);
    }

    public Mono<TeamEntity> update(TeamEntity teamEntity) {
        return teamRepository.save(teamEntity);
    }

    public Mono<Void> delete(String id) {
        return teamRepository.deleteById(id);
    }

    public Flux<TeamEntity> findAll() {
        return teamRepository.findAll();
    }

    public Mono<TeamEntity> findById(String id) {
        return teamRepository.findById(id)
                .switchIfEmpty(
                        Mono.error(new ResponseStatusException(NOT_FOUND, OBJECT_NOT_FOUND)));
    }
}
