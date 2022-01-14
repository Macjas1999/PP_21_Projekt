package com.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="", scope= entities.Airport.class)

public class Airport {

    @Id @GeneratedValue
    @CollectionTable
    @Column
    private  int id;

    @Column
    private String IATA;

    @Column
    private  int f_elevation;


    public Airport(){}
    public Airport(String IATA, int f_elevation) {
        this.IATA = IATA;
        this.f_elevation = f_elevation;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIATA() {
        return IATA;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public int getF_elevation() {
        return f_elevation;
    }

    public void setF_elevation(int f_elevation) {
        this.f_elevation = f_elevation;
    }
}
