package app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;

import java.util.Set;


@Data
@NoArgsConstructor
@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Bag bag;

    public Customer(String name, String surname, String email, String password) {
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.password=password;
    }

//    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
//    private Set<Role> roles;
}
