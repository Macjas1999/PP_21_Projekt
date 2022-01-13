package hibernate.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="", scope=Aircraft.class)


public class Aircraft {

    @Id @GeneratedValue
    @CollectionTable
    @Column
    private  int id;

    @Column
    private String type;

    @Column
    private  String manufacturer;

    @Column
    private String registration_number;

    @Column
    private  String model;

    public Aircraft(){}
    public Aircraft(String type, String manufacturer, String registration_number, String model) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.registration_number = registration_number;
        this.model = model;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
