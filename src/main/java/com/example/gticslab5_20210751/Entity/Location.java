package com.example.gticslab5_20210751.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "City")
    private String city;

    @Size(max = 255)
    @Column(name = "Country")
    private String country;

}
