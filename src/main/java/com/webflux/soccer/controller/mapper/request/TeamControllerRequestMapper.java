package com.webflux.soccer.controller.mapper.request;

import com.webflux.soccer.controller.model.request.TeamControllerRequest;
import com.webflux.soccer.service.model.request.TeamServiceRequest;

import java.util.Optional;

public class TeamControllerRequestMapper {

    public static TeamServiceRequest toServiceWithId(TeamControllerRequest teamControllerRequest, String id) {
        return Optional.ofNullable(teamControllerRequest)
                .map(teamControllerRequest1 -> TeamServiceRequest.builder()
                        .id(id)
                        .name(teamControllerRequest.getName())
                        .balance(teamControllerRequest.getBalance())
                        .build())
                .orElse(null);
    }

    public static TeamServiceRequest toServiceWithoutId(TeamControllerRequest teamControllerRequest) {
        return Optional.ofNullable(teamControllerRequest)
                .map(teamControllerRequest1 -> TeamServiceRequest.builder()
                        .name(teamControllerRequest.getName())
                        .balance(teamControllerRequest.getBalance())
                        .build())
                .orElse(null);
    }
}
