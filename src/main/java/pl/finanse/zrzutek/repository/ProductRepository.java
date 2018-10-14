package pl.finanse.zrzutek.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.finanse.zrzutek.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	public long findByName(String name);
	public boolean existsByName(String name);
	public boolean existsByShop(String shop);
}
