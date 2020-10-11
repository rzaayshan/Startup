package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String company;
    private String tel;
    private String address;
    private int voen;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Seller(String name, String surname, String email, String password, String company, String tel, String address, int voen) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        this.tel = tel;
        this.address = address;
        this.voen = voen;
    }
}
