package com.webflux.soccer.service.v1.facade;

import com.webflux.soccer.service.mapper.response.TeamServiceResponseMapper;
import com.webflux.soccer.service.model.request.TeamServiceRequest;
import com.webflux.soccer.service.model.response.TeamServiceResponse;
import com.webflux.soccer.service.v1.service.TeamService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.webflux.soccer.service.mapper.request.TeamServiceRequestMapper.toEntity;

/*@AllArgsConstructor
@NoArgsConstructor*/
@Component
public class TeamFacade {

    @Autowired
    private TeamService teamService;

    public TeamFacade(TeamService teamService) {
        this.teamService = teamService;
    }

    public TeamFacade() {}

    public Mono<TeamServiceResponse> save(TeamServiceRequest teamServiceRequest) {
        return teamService.save(toEntity(teamServiceRequest))
                .map(TeamServiceResponseMapper::toResponseController);
    }

    public Mono<TeamServiceResponse> update(TeamServiceRequest teamServiceRequest) {
        return teamService.findById(teamServiceRequest.getId())
                .flatMap(teamEntity -> teamService.update(toEntity(teamServiceRequest)))
                .map(TeamServiceResponseMapper::toResponseController);
    }

    public Mono<Void> delete(String id) {
        return teamService.findById(id)
                .flatMap(teamEntity -> teamService.delete(id));
    }

    public Flux<TeamServiceResponse> findAll() {
        return teamService.findAll()
                .map(TeamServiceResponseMapper::toResponseController);
    }

    public Mono<TeamServiceResponse> findById(String id) {
        return teamService.findById(id)
                .map(TeamServiceResponseMapper::toResponseController);
    }

}
