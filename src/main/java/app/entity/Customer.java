package app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;

    public Customer(String name, String surname, String email, String password) {
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.password=password;
    }
}
