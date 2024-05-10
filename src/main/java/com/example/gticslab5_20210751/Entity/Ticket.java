package com.example.gticslab5_20210751.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ticketid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Siteid")
    private Site siteID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Technicianid")
    private Technician technicianID;

    @Size(max = 50)
    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "Openeddate")
    private Instant openedDate;

    @Column(name = "Closeddate")
    private Instant closedDate;
}
