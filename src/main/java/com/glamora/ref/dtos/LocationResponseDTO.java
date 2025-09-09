package com.glamora.ref.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationResponseDTO {
    private String placeId;
    private String displayTitle;   // full formatted address
    private String countryName;
    private String stateName;
    private String districtName;
    private String cityName;
    private String areaName;
    private double latitude;
    private double longitude;
}

