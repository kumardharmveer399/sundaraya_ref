package com.glamora.ref.dtos;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StateDTO {

    private Long id;

    private String name;

    private String stateCode;

    private List<DistrictDTO> districts;

    private CountryDTO country;

}