package kz.solvatech.coffeemachine.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="date",nullable=false)
    private LocalDateTime orderDateTime;
    private Long recipeId;
}
