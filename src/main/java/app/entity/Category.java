package app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
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
    private Set<Product> products;

    @OneToMany(mappedBy = "category")
    Set<CategoryFeature> categoryFeatures;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "parent_category_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private Set<Category> subCategory;
}
