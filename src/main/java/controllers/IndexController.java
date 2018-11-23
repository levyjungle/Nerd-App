package controllers;

import javax.inject.Inject;

import annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadSizeLimit;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
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
		
    }

	@Public
	@Post("logar")
	public void login(String email, String password) {
		if(email.equalsIgnoreCase("jao") && password.equals("123")) {
			userSession.setLogged(true);
			result.redirectTo(HomeController.class).home();;
		}else {
			result.redirectTo(IndexController.class).index();
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
	
	@Public
	@Get("/upload")
	public void upload(UploadedFile fileUpload) {
		
	}
	
	@Public
	@Post("uploadfile")
	@UploadSizeLimit(sizeLimit = 70 * 1024 * 1024, fileSizeLimit = 20 * 1024 * 1024)
	public void uploadfile(UploadedFile fileUpload) {
			FilesUpload upload = new FilesUpload();
			upload.upload(fileUpload);
                        result.redirectTo(HomeController.class).home();
	}
    
}
