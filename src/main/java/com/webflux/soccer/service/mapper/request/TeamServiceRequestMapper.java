package com.webflux.soccer.service.mapper.request;

import com.webflux.soccer.repository.entity.TeamEntity;
import com.webflux.soccer.service.model.request.TeamServiceRequest;

import java.util.Optional;

public class TeamServiceRequestMapper {

    public static TeamEntity toEntity(TeamServiceRequest teamServiceRequest) {
        return Optional.ofNullable(teamServiceRequest)
                .map(teamServiceRequest1 -> TeamEntity.builder()
                        .id(teamServiceRequest.getId())
                        .name(teamServiceRequest.getName())
                        .balance(teamServiceRequest.getBalance())
                        .build())
                .orElse(null);
    }

}
