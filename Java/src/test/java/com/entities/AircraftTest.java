package com.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AircraftTest {

    private Aircraft testUnit;

    @BeforeEach
    void setUp() {
        Aircraft testUnit = new Aircraft("civil", "TestMan", "TEST343","T1");
    }

//    @AfterEach
//    void tearDown() {
//    }


    @Test
    void getType() {
        String typeOfTU = testUnit.getType();
        assertEquals("civil", typeOfTU);
    }

    @Test
    void setType() {
        testUnit.setType("military");
        String typeOfTU = testUnit.setType();
        assertEquals("military", typeOfTU);
    }

    @Test
    void getManufacturer() {
        String manufOfTU = testUnit.getManufacturer();
        assertEquals("TestMan", manufOfTU);
    }

    @Test
    void setManufacturer() {
        testUnit.setManufacturer("DIY");
        String manufOfTU = testUnit.getManufacturer();
        assertEquals("DIY", manufOfTU);
    }

    @Test
    void getRegistration_number() {
        String regNumOfTU = testUnit.getType();
        assertEquals("TEST343", regNumOfTU);
    }

    @Test
    void setRegistration_number() {
        testUnit.setRegistration_number("FAKE");
        String regNumOfTU = testUnit.getRegistration_number();
        assertEquals("FAKE", regNumOfTU);
    }

    @Test
    void getModel() {
        String modelOfTU = testUnit.getModel();
        assertEquals("T1", modelOfTU);
    }

    @Test
    void setModel() {
        testUnit.setModel("1T");
        String modelOfTU = testUnit.getModel();
        assertEquals("1T", modelOfTU);
    }
}