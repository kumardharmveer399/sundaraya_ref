package com.glamora.ref.common.util;


import lombok.Getter;

@Getter
public enum MessageCode {

    CATEGORY_LIST_SUCCESS("CATEGORY-S-001", "Categories fetched successfully"),
    CATEGORY_FOUND_SUCCESS("CATEGORY-S-002", "Category fetched successfully"),
    CATEGORY_NOT_FOUND("CATEGORY-F-001", "Category not found"),

    SERVICE_LIST_SUCCESS("SERVICE-S-001", "Services fetched successfully"),
    SERVICE_FOUND_SUCCESS("SERVICE-S-002", "Service fetched successfully"),
    SERVICE_NOT_FOUND("SERVICE-F-001", "Service not found"),

    COUNTRY_LIST_SUCCESS("COUNTRY-S-001", "Countries fetched successfully"),
    COUNTRY_FOUND_SUCCESS("COUNTRY-S-002", "Country fetched successfully"),
    COUNTRY_NOT_FOUND("COUNTRY-F-001", "Country not found"),

    STATE_LIST_SUCCESS("STATE-S-001", "States fetched successfully"),
    STATE_FOUND_SUCCESS("STATE-S-002", "State fetched successfully"),
    STATE_NOT_FOUND("STATE-F-001", "State not found"),

    DISTRICT_LIST_SUCCESS("DISTRICT-S-001", "Districts fetched successfully"),
    DISTRICT_FOUND_SUCCESS("DISTRICT-S-002", "District fetched successfully"),
    DISTRICT_NOT_FOUND("DISTRICT-F-001", "District not found"),

    CITY_LIST_SUCCESS("CITY-S-001", "Cities fetched successfully"),
    CITY_FOUND_SUCCESS("CITY-S-002", "City fetched successfully"),
    CITY_NOT_FOUND("CITY-F-001", "City not found"),

    AREA_LIST_SUCCESS("AREA-S-001", "Areas fetched successfully"),
    AREA_FOUND_SUCCESS("AREA-S-002", "Area fetched successfully"),
    AREA_NOT_FOUND("AREA-F-001", "Area not found");

    private final String code;
    private final String message;

    MessageCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
