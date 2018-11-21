package controllers;

import javax.inject.Inject;

import annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import components.UserSession;
import repository.FactoryManager;
import util.FilesUpload;

@Controller
public class IndexController {
   
	@Inject
	private Result result;
	@Inject
	private UserSession userSession;
	
	@Public
    @Get("/")
    public void index(){
		//FilesUpload upload = new FilesUpload();
		//upload.upload();
    }

	@Public
	@Post("logar")
	public void login(String email, String password) {
		if(email.equalsIgnoreCase("jao") && password.equals("123")) {
			userSession.setLogged(true);
			result.redirectTo(HomeController.class).home();;
		}
	}
	
	@Public
	@Get("/cadastro")
	public void register() {
		
	}
	
	@Public
	@Get("sair")
	public void logOut() {
		userSession.setLogged(false);
		result.redirectTo(IndexController.class).index();
	}
    
}
