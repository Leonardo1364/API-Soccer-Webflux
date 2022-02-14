package com.webflux.soccer.controller.mapper.response;

import com.webflux.soccer.controller.model.response.TeamControllerResponse;
import com.webflux.soccer.service.model.response.TeamServiceResponse;

import java.util.Optional;

public class TeamControllerResponseMapper {

    public static TeamControllerResponse toResponseController(TeamServiceResponse teamServiceResponse) {
        return Optional.ofNullable(teamServiceResponse)
                .map(teamServiceResponse1 -> TeamControllerResponse.builder()
                        .id(teamServiceResponse.getId())
                        .name(teamServiceResponse.getName())
                        .balance(teamServiceResponse.getBalance())
                        .build())
                .orElse(null);
    }
}
