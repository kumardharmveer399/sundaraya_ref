package com.glamora.ref.dtos;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDTO {

    private Long id;

    private String code;

    private String name;

    private String categoryCode;
}

