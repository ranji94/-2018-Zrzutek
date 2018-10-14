package pl.finanse.zrzutek.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.finanse.zrzutek.entity.Product;
import pl.finanse.zrzutek.repository.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> products = new ArrayList<>();
		this.productRepository.findAll().forEach(products::add);
		return products;
	}
	
	public void addProduct(Product product)
	{
		if(productRepository.existsByName(product.getName()) && productRepository.existsByShop(product.getShop()))
		System.out.println("Produkt "+product.getName()+" ze sklepu "+ product.getShop() + " już istnieje w bazie danych.");
		else
		this.productRepository.save(product);
	}
	
	public float getTotal()
	{
		List<Product> products = this.getAllProducts();
		float total=0.0F;
		for(int i=0;i<this.productRepository.count();i++)
		{
			total+=products.get(i).getPrice();
		}
		return (float) (Math.round(total*100.0)/100.0);
	}
}
