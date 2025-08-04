package kz.solvatech.coffeemachine.repository;

import kz.solvatech.coffeemachine.model.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    @Query(value = "SELECT recipe_id FROM orders GROUP BY recipe_id ORDER BY COUNT(recipe_id) DESC LIMIT 1", nativeQuery = true)
    Long findMostPopularRecipe();
}
