package com.glamora.ref.dtos;

import lombok.Data;

@Data
public class LocationRequestDTO {

    private double latitude;

    private double longitude;

    private String address;       // For forward geocoding

}
