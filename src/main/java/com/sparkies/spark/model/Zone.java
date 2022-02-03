package com.sparkies.spark.model;

import javax.persistence.*;

@Entity
@Table(name = "ZONE")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_zone")
    private Long idZone;

    private String nom;

    private double minute;

}
