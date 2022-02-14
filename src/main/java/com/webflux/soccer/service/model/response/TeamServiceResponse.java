package com.webflux.soccer.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeamServiceResponse {

    private String id;
    private String name;
    private Double balance;
}
