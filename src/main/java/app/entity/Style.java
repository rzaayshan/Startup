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
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private long id;

    private String font;
    private String color_back;
    private String color;

    @OneToMany(mappedBy = "style")
    private Set<Seller> seller;

    public Style(String font, String color_back, String color) {
        this.font = font;
        this.color_back = color_back;
        this.color = color;
    }
}
