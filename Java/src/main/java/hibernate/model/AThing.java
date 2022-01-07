package hibernate.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class AThing {
    @Id @GeneratedValue

    @Column(name = "id")
    private int id;

    public String getGeneralName() {
        return generalName;
    }

    public void setGeneralName(String generalName) {
        this.generalName = generalName;
    }

    @Column(name = "general_name")
    private  String generalName;

}
