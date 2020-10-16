package app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    private String barcode;
    private int inStock;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    private Seller seller;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<ProductFeature> productFeatures;

    @OneToMany(mappedBy = "product")
    private List<ProductPhoto> photoList;

}
