package controllers;

import javax.inject.Inject;

import annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import components.UserSession;
import java.util.List;
import java.util.Set;
import model.Media;
import model.Person;
import repository.MediaRepository;

@Controller
public class IndexController {
	
	@Inject
	private UserSession userSession;
	@Inject
	private Result result;
	MediaRepository mediaRepository = new MediaRepository();
	
	@Public
	@Get("/")
	public void index() {
		if(userSession.isLogged()) {
                    result.redirectTo(UserController.class).perfil();
		}
	}
            
        @Get("comment")
        public void comment() {

        }
        
}
