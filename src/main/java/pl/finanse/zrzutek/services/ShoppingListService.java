package pl.finanse.zrzutek.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
		shoppingList.setOwner(getCurrentUser());
		this.shoppingListRepository.save(shoppingList);
	}
	
	public List<ShoppingList> getAllShoppingList()
	{
		List<ShoppingList> shopping = new ArrayList<>();
		this.shoppingListRepository.findByOwner(getCurrentUser()).forEach(shopping::add);
		return shopping;
	}
	
	public String getCurrentUser()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}
}
