package com.example.gticslab5_20210751.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Deviceid", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "Devicename")
    private String deviceName;

    @Size(max = 255)
    @Column(name = "Devicetype")
    private String deviceType;

    @Size(max = 255)
    @Column(name = "Model")
    private String model;

    @Size(max = 255)
    @Column(name = "Serialnumber")
    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Siteid")
    private Site siteID;
}
