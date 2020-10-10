package app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private long id;
    private String name;

    @OneToMany(mappedBy = "category")
    Set<Product> products;

    @OneToMany(mappedBy = "category")
    Set<CategoryFeature> categoryFeatures;

    @OneToOne
    private ParentCategory parentCategory;
}
