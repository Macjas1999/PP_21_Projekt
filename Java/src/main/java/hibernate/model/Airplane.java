package hibernate.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Airplane {

    @Id @GeneratedValue
//    @Column(name = "id")
    private  int id;

//    @Column(name = "type")
    private String type;

//    @Column(name = "manufacturer")
    private  String manufacturer;

//    @Column(name = "registration_number", unique = true)
    private String registration_number;

//    @Column(name = "model")
    private  String model;


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
