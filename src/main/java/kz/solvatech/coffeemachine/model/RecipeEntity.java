package kz.solvatech.coffeemachine.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="recipe")
@Data
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
