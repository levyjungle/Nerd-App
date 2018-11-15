package controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import components.UserSession;

@Controller
public class HomeController {
	
	@Inject
	private UserSession userSession;
	@Inject
	private Result result;
	
	
	@Get("home")
	public void home() {
		
	}

}
