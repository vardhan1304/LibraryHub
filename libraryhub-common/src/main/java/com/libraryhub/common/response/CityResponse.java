package com.libraryhub.common.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityResponse {
    private Integer cityId;
    private String name;
}
