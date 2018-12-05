package controllers;

import javax.inject.Inject;

import annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import components.UserSession;
import model.Person;
import repository.PersonRepository;
import util.Crypt;

@Controller
public class LoginController {
	@Inject
	private PersonRepository personRepository;
	@Inject
	private Result result;
	@Inject
	private UserSession userSession;
	
	//page login return to home if isLogged true
	@Public
	@Get("/login")
	public void login() {
		if (userSession.isLogged()) {
			result.redirectTo(HomeController.class).home();
		}
	}
	
	//login validation
	@Public
	@Post("sendLogin")
	public void sendLogin(String email, String password) {
		Person person = personRepository.searchSpecificEntityValueIntoPerson("profile", "email", email);
		if (person == null) {
			result.redirectTo(LoginController.class).login();
		} else {
			boolean confirmPassword = Crypt.verifyHash(password, person.getProfile().getPassword());
			if (email.equals(person.getProfile().getEmail()) && confirmPassword) {
				userSession.setLogged(true);

				userSession.setPerson(person);
				result.redirectTo(UserController.class).index();
			} else {
				result.redirectTo(LoginController.class).login();
			}
		}

	}
}
