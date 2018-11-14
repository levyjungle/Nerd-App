package controllers;

import javax.inject.Inject;

import annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;


@Controller
public class IndexController {
   
	@Inject
	private Result result;
	
	
	@Public
    @Get("/")
    public void index(){
    }
	
	@Public
	@Get("/cadastro")
	public void register() {
		
	}
	
	@Public
	@Post("logar")
    public void authenticate(String email, String password) {
    	if(email.equals("ica@gmail.com") && password.equals("123")) {
    		result.redirectTo(HomeController.class).home();
    		
    	}
    }
}
