package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private long id;
    private String name;
    private int price;
    private String barcode;
    private int inStock;
    private String photo;
    private int discount;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    @JsonIgnore
    private Seller seller;

    @ManyToOne
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductFeature> productFeatures;

//    @OneToMany(mappedBy = "product")
//    @JsonIgnore
//    private List<ProductPhoto> photoList;

}
