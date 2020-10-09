package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private long id;
    private String name;
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "r_customer_product",
            joinColumns = {@JoinColumn(name="product_id",
                    referencedColumnName = "p_id"),
            },
            inverseJoinColumns = {@JoinColumn(name = "customer_id",
                    referencedColumnName = "c_id")})
    private Customer customer;

    @ManyToOne
    @JoinTable(name = "r_product_category",
            joinColumns = {@JoinColumn(name="product_id",
                    referencedColumnName = "p_id"),
            },
            inverseJoinColumns = {@JoinColumn(name = "category_id",
                    referencedColumnName = "c_id")})
    private Category category;

}
