package com.webflux.soccer.controller.v1.team;

import com.webflux.soccer.controller.model.request.TeamControllerRequest;
import com.webflux.soccer.controller.model.response.TeamControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/flux/team/")
public class TeamController {

    private final TeamControllerFacadeImpl teamControllerFacade;

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<TeamControllerResponse> save(@RequestBody @Valid TeamControllerRequest teamControllerRequest) {
        return teamControllerFacade.save(teamControllerRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public Mono<TeamControllerResponse> update(@RequestBody @Valid TeamControllerRequest teamControllerRequest,
                                               @PathVariable String id) {
        return teamControllerFacade.update(teamControllerRequest, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return teamControllerFacade.delete(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public Flux<TeamControllerResponse> findAll() {
        return teamControllerFacade.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Mono<TeamControllerResponse> findById(@PathVariable String id) {
        return teamControllerFacade.findById(id);
    }
}
