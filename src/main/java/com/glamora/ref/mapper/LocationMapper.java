package com.glamora.ref.mapper;

import com.glamora.ref.dtos.*;
import com.glamora.ref.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    CountryDTO toCountryDTO(Country country);

    @Mapping(source = "country", target = "country")
    StateDTO toStateDTO(State state);

    @Mapping(source = "state", target = "state")
    DistrictDTO toDistrictDTO(District district);

    @Mapping(source = "district", target = "district")
    CityDTO toCityDTO(City city);

    @Mapping(source = "city", target = "city")
    AreaDTO toAreaDTO(Area area);

}

