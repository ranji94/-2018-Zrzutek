package pl.finanse.zrzutek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.finanse.zrzutek.auth.Users;
import pl.finanse.zrzutek.auth.UsersRepository;

@Controller
public class RegistrationController {
	private UsersRepository usersRepository;
	
	@Autowired
	public RegistrationController(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

	@GetMapping("/registration")
	public String formularz(Model model)
	{
		model.addAttribute("newuser", new Users());
		return "registration";
	}

	@PostMapping("/registration")
	public String productSubmit(@ModelAttribute Users user)
	{
		this.usersRepository.save(user);
		return "regsuccess";
	}
}
