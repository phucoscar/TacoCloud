package tacos;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
//import org.hibernate.validator.constraints.CreditCardNumber;
//import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "taco_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date placedAt;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();
    public void addDesign(Taco design){this.tacos.add(design);}
    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}