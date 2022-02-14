package com.webflux.soccer.service.mapper.response;

import com.webflux.soccer.repository.entity.TeamEntity;
import com.webflux.soccer.service.model.response.TeamServiceResponse;

import java.util.Optional;

public class TeamServiceResponseMapper {

    public static TeamServiceResponse toResponseController(TeamEntity teamEntity) {
        return Optional.ofNullable(teamEntity)
                .map(teamEntity1 -> TeamServiceResponse.builder()
                        .id(teamEntity.getId())
                        .name(teamEntity.getName())
                        .balance(teamEntity.getBalance())
                        .build())
                .orElse(null);
    }
}
