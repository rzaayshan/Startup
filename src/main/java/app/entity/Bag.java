package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bag {
    /**
     * Since every customer must have a bag their ids are mapped e.g
     * customer id = bag id
     */
    @Id
    @Column(name = "bag_id")
    private long id;

    @JoinColumn(name = "c_id")
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Customer customer;

    @OneToMany
    private List<Product> products;

    public Bag(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Bag{id=%d}", id);
    }
}
