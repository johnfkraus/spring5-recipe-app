package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = {"recipes"})
@ToString(exclude = {"recipe"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories") //, fetch = FetchType.EAGER)
    private Set<Recipe> recipes;

}
