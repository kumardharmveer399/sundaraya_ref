package com.glamora.ref.service;

import com.glamora.ref.dtos.*;

import java.util.List;

public interface LocationService {
    CountryDTO getCountryByIsoCode(String isoCode);

    List<StateDTO> getStatesByCountry(String isoCode);

    List<DistrictDTO> getDistrictsByState(String stateCode);

    List<CityDTO> getCitiesByDistrict(String districtName);

    List<AreaDTO> getAreasByCity(String cityName);

//    LocationResponseDTO detectLocation(LocationRequestDTO request);

    LocationResponseDTO getLocationFromCoordinates(LocationRequestDTO coordinates);

    LocationResponseDTO getCoordinatesFromAddress(String address);
}
