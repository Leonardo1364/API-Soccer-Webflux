package com.webflux.soccer.controller.v1.team;

import com.webflux.soccer.controller.mapper.response.TeamControllerResponseMapper;
import com.webflux.soccer.controller.model.request.TeamControllerRequest;
import com.webflux.soccer.controller.model.response.TeamControllerResponse;
import com.webflux.soccer.service.v1.facade.TeamFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.webflux.soccer.controller.mapper.request.TeamControllerRequestMapper.toServiceWithId;
import static com.webflux.soccer.controller.mapper.request.TeamControllerRequestMapper.toServiceWithoutId;

@AllArgsConstructor
@Component
public class TeamControllerFacadeImpl {

    private final TeamFacade teamFacade;

    public Mono<TeamControllerResponse> save(TeamControllerRequest teamControllerRequest) {
        return teamFacade.save(toServiceWithoutId(teamControllerRequest))
                .map(TeamControllerResponseMapper::toResponseController);
    }

    public Mono<TeamControllerResponse> update(TeamControllerRequest teamControllerRequest, String id) {
        return teamFacade.update(toServiceWithId(teamControllerRequest, id))
                .map(TeamControllerResponseMapper::toResponseController);
    }

    public Mono<Void> delete(String id) {
        return teamFacade.delete(id);
    }

    public Flux<TeamControllerResponse> findAll() {
        return teamFacade.findAll()
                .map(TeamControllerResponseMapper::toResponseController);
    }

    public Mono<TeamControllerResponse> findById(String id) {
        return teamFacade.findById(id)
                .map(TeamControllerResponseMapper::toResponseController);
    }
}
