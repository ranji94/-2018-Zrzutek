package pl.finanse.zrzutek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.finanse.zrzutek.services.UserSearchService;

@Controller
public class UserSearchController {
	private UserSearchService userSearchService;

	@Autowired
	public UserSearchController(UserSearchService userSearchService) {
		super();
		this.userSearchService = userSearchService;
	}

	@GetMapping("/usersearch")
	public String userSearch(Model model)
	{
		model.addAttribute("currentuser", userSearchService.getCurrentUser());
		return "usersearch";
	}

}
