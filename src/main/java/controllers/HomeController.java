package controllers;

import annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class HomeController {

	@Public
	@Get("home")
	public void home() {
		
	}
}
