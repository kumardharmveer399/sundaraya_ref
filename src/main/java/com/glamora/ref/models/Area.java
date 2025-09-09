package com.glamora.ref.models;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "areas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String pincode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;
}