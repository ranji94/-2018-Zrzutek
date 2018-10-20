package pl.finanse.zrzutek.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.finanse.zrzutek.entity.ShoppingList;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long>{
	List<ShoppingList> findByOwner(String owner);
}
