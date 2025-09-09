package com.glamora.ref.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CityDTO {

    private Long id;

    private String name;

    private List<AreaDTO> areas;

    private DistrictDTO district;

}
