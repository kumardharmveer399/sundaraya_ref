package com.glamora.ref.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreaDTO {

    private Long id;

    private String name;

    private String pincode;

    private CityDTO city;

}