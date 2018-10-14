package pl.finanse.zrzutek.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.finanse.zrzutek.entity.Product;
import pl.finanse.zrzutek.entity.ShoppingList;
import pl.finanse.zrzutek.repository.ShoppingListRepository;

@Service
public class ShoppingListService {
	private ShoppingListRepository shoppingListRepository;
	private ProductService productService;
	
	@Autowired
	public ShoppingListService(ShoppingListRepository shoppingListRepository, ProductService productService) {
		super();
		this.shoppingListRepository = shoppingListRepository;
		this.productService = productService;
	}
	
	public void addElement(ShoppingList shoppingList)
	{
		Product product = new Product();
		product.setName(shoppingList.getProduct_name());
		product.setPrice(shoppingList.getProduct_price());
		product.setShop(shoppingList.getProduct_shop());
		productService.addProduct(product);
		shoppingList.setDate();
		this.shoppingListRepository.save(shoppingList);
	}
	
	public List<ShoppingList> getAllShoppingList()
	{
		List<ShoppingList> shopping = new ArrayList<>();
		this.shoppingListRepository.findAll().forEach(shopping::add);
		return shopping;
	}
}
