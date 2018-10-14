package pl.finanse.zrzutek.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.finanse.zrzutek.entity.ShoppingList;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long>{

}
