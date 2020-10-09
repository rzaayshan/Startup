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
public class Sailer {
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

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Product> products;
}
