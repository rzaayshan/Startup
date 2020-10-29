package app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Bag bag;


    public Customer(String name, String surname, String email, String password, String role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Customer(String name, String surname, String email, String password, String role, Bag bag) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.bag = bag;
    }

    @Override
    public String toString() {
        return String.format("Customer{id=%d, name='%s', surname='%s', email='%s', password='%s', role='%s'}", id, name, surname, email, password, role);
    }
}
