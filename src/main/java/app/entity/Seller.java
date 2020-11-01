package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seller{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String company;
    private String phone;
    private String address;
    private String tin;
    private String token;
    private String role;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    private List<Product> products;

    @ManyToOne
    @JoinTable(name = "r_seller_style",
            joinColumns = {@JoinColumn(name = "seller_id",
                    referencedColumnName = "s_id")},
            inverseJoinColumns = {@JoinColumn(name = "style_id",
                    referencedColumnName = "s_id")
            })
    private Style style;

    public Seller(String name, String surname, String email, String password, String company, String phone, String address, String tin) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        this.phone = phone;
        this.address = address;
        this.tin = tin;
    }

    public Seller(String name, String surname, String email, String password, String company, String phone, String address, String tin, String token) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        this.phone = phone;
        this.address = address;
        this.tin = tin;
        this.token=token;

    }

    public Seller(String name, String surname, String email, String password, String company, String phone, String address, String tin, String token, String role, Style style) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        this.phone = phone;
        this.address = address;
        this.tin = tin;
        this.token = token;
        this.role = role;
        this.style = style;
    }
}
