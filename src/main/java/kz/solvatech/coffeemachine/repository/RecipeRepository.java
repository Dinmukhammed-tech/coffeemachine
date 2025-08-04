package kz.solvatech.coffeemachine.repository;

import kz.solvatech.coffeemachine.model.RecipeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity,Long> {

}
