package com.glamora.ref.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DistrictDTO {

    private Long id;

    private String name;

    private List<CityDTO> cities;

    private StateDTO state;

}
