package com.glamora.ref.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CountryDTO {

    private Long id;

    private String name;

    private String isoCode;

    private String phoneCode;

    private List<StateDTO> states;

}
