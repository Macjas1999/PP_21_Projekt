package com.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
    private Airport testUnit;

    AirportTest(Airport testUnit) {
        this.testUnit = testUnit;
    }

    @BeforeEach
    void setUp() {
        testUnit = new Airport("NOPE", 54);

    }

//    @AfterEach
//    void tearDown() {
//    }


    @Test
    void getIATA() {
        String IATAOfTU = testUnit.getIATA();
        assertEquals("NOPE", IATAOfTU);
    }

    @Test
    void setIATA() {
        testUnit.setIATA("YES");
        String IATAOfTU = testUnit.getIATA();
        assertEquals("YES", IATAOfTU);
    }

    @Test
    void getF_elevation() {
        int felOfTU = testUnit.getF_elevation();
        assertEquals(54, felOfTU);
    }

    @Test
    void setF_elevation() {
        testUnit.setF_elevation(44);
        int felOfTU = testUnit.getF_elevation();
        assertEquals(44, felOfTU);
    }
}