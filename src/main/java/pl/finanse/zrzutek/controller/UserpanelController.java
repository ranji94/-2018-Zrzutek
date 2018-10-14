package pl.finanse.zrzutek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.finanse.zrzutek.entity.ShoppingList;
import pl.finanse.zrzutek.services.ShoppingListService;

@Controller
public class UserpanelController {
	private ShoppingListService shoppingListService;
	
	@Autowired
	public UserpanelController(ShoppingListService shoppingListService) {
		super();
		this.shoppingListService = shoppingListService;		////CHOĆBY SKAŁY SRAŁY DEKLAROWAĆ KAŻDA USLUGE
	}

	@GetMapping("/shopping")
	public String formularz(Model model)
	{
		model.addAttribute("shopping", new ShoppingList());
		model.addAttribute("shoppinglist", shoppingListService.getAllShoppingList());
		return "shoppinglist";
	}

	@PostMapping("/shopping")
	public String productSubmit(@ModelAttribute ShoppingList shoppinglist)
	{
		this.shoppingListService.addElement(shoppinglist);
		return "redirect:/shopping";
	}
}
