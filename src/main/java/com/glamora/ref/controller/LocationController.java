package com.glamora.ref.controller;

import com.glamora.ref.common.model.CommonUtils;
import com.glamora.ref.common.model.ResponseModel;
import com.glamora.ref.common.util.MessageCode;
import com.glamora.ref.dtos.*;
import com.glamora.ref.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private static final Logger log = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @Autowired
    private CommonUtils commonUtils;

    @GetMapping("/country/{isoCode}")
    public ResponseEntity<ResponseModel> getCountry(@PathVariable String isoCode) {
        try {
            CountryDTO country = locationService.getCountryByIsoCode(isoCode);
            return ResponseEntity.ok(
                    commonUtils.createResponseModel(
                            MessageCode.COUNTRY_FOUND_SUCCESS.getCode(),
                            MessageCode.COUNTRY_FOUND_SUCCESS.getMessage(),
                            country
                    )
            );
        } catch (IllegalArgumentException e) {
            log.error("Country not found: {}", isoCode, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    commonUtils.createResponseModel(
                            MessageCode.COUNTRY_NOT_FOUND.getCode(),
                            MessageCode.COUNTRY_NOT_FOUND.getMessage()
                    )
            );
        }
    }

    @GetMapping("/states/{isoCode}")
    public ResponseEntity<ResponseModel> getStates(@PathVariable String isoCode) {
        try {
            List<StateDTO> states = locationService.getStatesByCountry(isoCode);
            return ResponseEntity.ok(
                    commonUtils.createResponseModel(
                            MessageCode.STATE_FOUND_SUCCESS.getCode(),
                            MessageCode.STATE_FOUND_SUCCESS.getMessage(),
                            states
                    )
            );
        } catch (IllegalArgumentException e) {
            log.error("States not found for country: {}", isoCode, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    commonUtils.createResponseModel(
                            MessageCode.STATE_NOT_FOUND.getCode(),
                            MessageCode.STATE_NOT_FOUND.getMessage()
                    )
            );
        }
    }

    @GetMapping("/districts/{stateCode}")
    public ResponseEntity<ResponseModel> getDistricts(@PathVariable String stateCode) {
        try {
            List<DistrictDTO> districts = locationService.getDistrictsByState(stateCode);
            return ResponseEntity.ok(
                    commonUtils.createResponseModel(
                            MessageCode.DISTRICT_FOUND_SUCCESS.getCode(),
                            MessageCode.DISTRICT_FOUND_SUCCESS.getMessage(),
                            districts
                    )
            );
        } catch (IllegalArgumentException e) {
            log.error("Districts not found for state: {}", stateCode, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    commonUtils.createResponseModel(
                            MessageCode.DISTRICT_NOT_FOUND.getCode(),
                            MessageCode.DISTRICT_NOT_FOUND.getMessage()
                    )
            );
        }
    }

    @GetMapping("/cities/{districtName}")
    public ResponseEntity<ResponseModel> getCities(@PathVariable String districtName) {
        try {
            List<CityDTO> cities = locationService.getCitiesByDistrict(districtName);
            return ResponseEntity.ok(
                    commonUtils.createResponseModel(
                            MessageCode.CITY_FOUND_SUCCESS.getCode(),
                            MessageCode.CITY_FOUND_SUCCESS.getMessage(),
                            cities
                    )
            );
        } catch (IllegalArgumentException e) {
            log.error("Cities not found for district: {}", districtName, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    commonUtils.createResponseModel(
                            MessageCode.CITY_NOT_FOUND.getCode(),
                            MessageCode.CITY_NOT_FOUND.getMessage()
                    )
            );
        }
    }

    @GetMapping("/areas/{cityName}")
    public ResponseEntity<ResponseModel> getAreas(@PathVariable String cityName) {
        try {
            List<AreaDTO> areas = locationService.getAreasByCity(cityName);
            return ResponseEntity.ok(
                    commonUtils.createResponseModel(
                            MessageCode.AREA_FOUND_SUCCESS.getCode(),
                            MessageCode.AREA_FOUND_SUCCESS.getMessage(),
                            areas
                    )
            );
        } catch (IllegalArgumentException e) {
            log.error("Areas not found for city: {}", cityName, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    commonUtils.createResponseModel(
                            MessageCode.AREA_NOT_FOUND.getCode(),
                            MessageCode.AREA_NOT_FOUND.getMessage()
                    )
            );
        }
    }

//    @PostMapping("/detect")
//    public ResponseEntity<LocationResponseDTO> detectLocation(@RequestBody LocationRequestDTO request) {
//        return ResponseEntity.ok(locationService.detectLocation(request));
//    }

    @PostMapping("/reverse")
    public ResponseEntity<LocationResponseDTO> getLocation(@RequestBody LocationRequestDTO coordinates) {
        return ResponseEntity.ok(locationService.getLocationFromCoordinates(coordinates));
    }

    @PostMapping("/forward")
    public ResponseEntity<LocationResponseDTO> getCoordinates(@RequestBody LocationRequestDTO request) {
        return ResponseEntity.ok(locationService.getCoordinatesFromAddress(request.getAddress()));
    }
}

