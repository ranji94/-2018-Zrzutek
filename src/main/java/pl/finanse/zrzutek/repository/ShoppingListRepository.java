package pl.finanse.zrzutek.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import pl.finanse.zrzutek.entity.ShoppingList;

@Repository
public interface ShoppingListRepository extends PagingAndSortingRepository<ShoppingList, Long>{
	List<ShoppingList> findByOwner(String owner, Sort sort);
}
