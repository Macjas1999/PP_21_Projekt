package hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Airport {

    @Id @GeneratedValue
//    @Column(name = "id")
    private  int id;

//    @Column(name = "IATA")
    private String IATA;

//    @Column(name = "f_elevation")
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
