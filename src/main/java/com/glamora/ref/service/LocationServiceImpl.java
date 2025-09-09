package com.glamora.ref.service;

import com.glamora.ref.common.constants.AppConstants;
import com.glamora.ref.dtos.*;
import com.glamora.ref.mapper.LocationMapper;
import com.glamora.ref.models.Country;
import com.glamora.ref.repositories.*;
import jakarta.transaction.Transactional;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;


import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private LocationMapper locationMapper;

//    @Value("${google.maps.api.key}")
//    private String googleApiKey;


//    private final RestTemplate restTemplate = new RestTemplate();


    @Override
    public CountryDTO getCountryByIsoCode(String isoCode) {
        Country country = countryRepository.findByIsoCode(isoCode)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        return locationMapper.toCountryDTO(country);
    }

    @Override
    public List<StateDTO> getStatesByCountry(String isoCode) {
        return stateRepository.findByCountryIsoCode(isoCode)
                .stream().map(locationMapper::toStateDTO).toList();
    }

    @Override
    public List<DistrictDTO> getDistrictsByState(String stateCode) {
        return districtRepository.findByStateStateCode(stateCode)
                .stream().map(locationMapper::toDistrictDTO).toList();
    }

    @Override
    public List<CityDTO> getCitiesByDistrict(String districtName) {
        return cityRepository.findByDistrictName(districtName)
                .stream().map(locationMapper::toCityDTO).toList();
    }

    @Override
    public List<AreaDTO> getAreasByCity(String cityName) {
        return areaRepository.findByCityName(cityName)
                .stream().map(locationMapper::toAreaDTO).toList();
    }


//    @Override
//    @Transactional(rollbackOn = Exception.class)
//    public LocationResponseDTO detectLocation(LocationRequestDTO request) {
//
//        String url = String.format(
//                "https://maps.googleapis.com/maps/api/geocode/json?latlng=%f,%f&key=%s",
//                request.getLatitude(), request.getLongitude(), googleApiKey
//        );
//
//        String response = restTemplate.getForObject(url, String.class);
//        JSONObject json = new JSONObject(response);
//
//        if (!"OK".equals(json.getString("status"))) {
//            throw new RuntimeException("Unable to fetch location from Google API");
//        }
//
//        JSONObject result = json.getJSONArray("results").getJSONObject(0);
//
//        LocationResponseDTO dto = new LocationResponseDTO();
//        dto.setPlaceId(result.getString("place_id"));
//        dto.setDisplayTitle(result.getString("formatted_address"));
//        dto.setLatitude(request.getLatitude());
//        dto.setLongitude(request.getLongitude());
//
//        var components = result.getJSONArray("address_components");
//        for (int i = 0; i < components.length(); i++) {
//            var comp = components.getJSONObject(i);
//            var types = comp.getJSONArray("types").toList();
//
//            if (types.contains("country")) dto.setCountryName(comp.getString("long_name"));
//            if (types.contains("administrative_area_level_1")) dto.setStateName(comp.getString("long_name"));
//            if (types.contains("administrative_area_level_2")) dto.setDistrictName(comp.getString("long_name"));
//            if (types.contains("locality")) dto.setCityName(comp.getString("long_name"));
//            if (types.contains("sublocality") || types.contains("neighborhood"))
//                dto.setAreaName(comp.getString("long_name"));
//        }
//
//        return dto;
//    }


    @Override
    @Transactional(rollbackOn = Exception.class)
    public LocationResponseDTO getLocationFromCoordinates(LocationRequestDTO coordinates) {
        String url = AppConstants.NOMINATIM_URL + "/reverse?format=json&lat="
                + coordinates.getLatitude() + "&lon="
                + coordinates.getLongitude() + "&addressdetails=1";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(response);
        JSONObject address = json.getJSONObject("address");

        return LocationResponseDTO.builder()
                .displayTitle(json.optString("display_name"))
                .countryName(address.optString("country"))
                .stateName(address.optString("state"))
                .districtName(address.optString("county"))
                .cityName(address.optString("city", address.optString("town", address.optString("village", ""))))
                .placeId(address.optString("postcode"))
                .latitude(json.optDouble("lat"))
                .longitude(json.optDouble("lon"))
                .build();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public LocationResponseDTO getCoordinatesFromAddress(String address) {

        String url = AppConstants.NOMINATIM_URL + "/search?format=json&q=" + address + "&limit=1&addressdetails=1";

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);

        JSONArray jsonArray = new org.json.JSONArray(response);

        if (jsonArray.isEmpty()) {
            throw new RuntimeException("Address not found");
        }

        JSONObject json = jsonArray.getJSONObject(0);

        JSONObject addressObj = json.getJSONObject("address");

        return LocationResponseDTO.builder()
                .districtName(json.optString("display_name"))
                .cityName(addressObj.optString("country"))
                .stateName(addressObj.optString("state"))
                .districtName(addressObj.optString("county"))
                .cityName(addressObj.optString("city",
                        addressObj.optString("town",
                                addressObj.optString("village", ""))))
                .placeId(addressObj.optString("postcode"))
                .latitude(json.optDouble("lat"))
                .longitude(json.optDouble("lon"))
                .build();
    }

}

