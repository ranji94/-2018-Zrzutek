package pl.finanse.zrzutek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import pl.finanse.zrzutek.entity.ShoppingList;
import pl.finanse.zrzutek.services.ShoppingListService;

@Controller
public class UserpanelController implements WebMvcConfigurer{
	private ShoppingListService shoppingListService;
	
	@Autowired
	public UserpanelController(ShoppingListService shoppingListService) {
		super();
		this.shoppingListService = shoppingListService;		////CHOĆBY SKAŁY SRAŁY DEKLAROWAĆ KAŻDA USLUGE
	}

	@GetMapping("/shopping")
	public String formularz(ShoppingList shoppingList, Model model)
	{
		model.addAttribute("lista", shoppingListService.getAllShoppingList());
		model.addAttribute("currentuser", shoppingListService.getCurrentUser());
		//model.addAttribute("shopping", new ShoppingList());
		return "shoppinglist";
	}

	@PostMapping("/shopping")
	public String productSubmit(@Valid ShoppingList shoppingList, BindingResult bindingResult, Model model)
	{
		model.addAttribute("lista", shoppingListService.getAllShoppingList());
		model.addAttribute("currentuser", shoppingListService.getCurrentUser());
		if(bindingResult.hasErrors())
		{
			return "shoppinglist";
		}
		else
		{
		this.shoppingListService.addElement(shoppingList);
		return "redirect:/shopping";
		}
	}
}
