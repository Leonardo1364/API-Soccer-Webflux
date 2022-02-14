package com.webflux.soccer.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeamServiceRequest {

    private String id;
    private String name;
    private Double balance;
}
