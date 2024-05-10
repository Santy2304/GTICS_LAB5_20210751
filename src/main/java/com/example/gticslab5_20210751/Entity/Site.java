package com.example.gticslab5_20210751.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteiD", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "Sitename")
    private String siteName;

    @ManyToOne
    @JoinColumn(name = "Locationid")
    private Location locationID;

    @Column(name = "Installationdate")
    private LocalDate installationDate;

    @Size(max = 45)
    @Column(name = "Latitude", length = 45)
    private String latitude;

    @Size(max = 45)
    @Column(name = "Longitude", length = 45)
    private String longitude;

}
