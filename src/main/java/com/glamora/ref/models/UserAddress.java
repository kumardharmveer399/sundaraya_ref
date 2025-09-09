package com.glamora.ref.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_addresses")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String addressLine;
    private Double latitude;
    private Double longitude;

    private String placeId;
    private String placeType;        // GOOGLE_PLACE, CUSTOM, etc.

    private Long cityId;             // FK → cities table
    private Long districtId;
    private Long stateId;
    private Long countryId;

    private Boolean isDefault;
}

