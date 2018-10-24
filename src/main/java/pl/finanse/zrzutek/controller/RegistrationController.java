package pl.finanse.zrzutek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String formularz(Users users)
	{
		return "registration";
	}

	@PostMapping("/registration")
	public String productSubmit(@Valid Users users, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "registration";
		}
		else
		{
			this.usersRepository.save(users);
			return "regsuccess";
		}
	}
}
