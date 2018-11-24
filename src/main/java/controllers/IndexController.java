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
import model.Person;
import model.Profile;
import repository.FactoryManager;
import repository.PersonRepository;
import util.FilesUpload;

@Controller
public class IndexController {

	@Inject
	private Result result;
	@Inject
	private UserSession userSession;

	@Public
	@Get("/")
	public void index() {
		System.out.println(FactoryManager.getManager());
		/*	
           Person p = new Person();
           Profile profile = new Profile();
           
           profile.setEmail("jao@gmail.com");
           profile.setNickname("jao");
           profile.setPassword("123");
           
           p.setName("jao");
           p.setProfile(profile);
           
           PersonRepository personRepository = new PersonRepository();
           personRepository.savePerson(p);
           */
	}

	@Public
	@Post("logar")
	public void login(String email, String password) {
		if (email.equalsIgnoreCase("jao") && password.equals("123")) {
			userSession.setLogged(true);
			result.redirectTo(HomeController.class).home();
		} else {
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

	@Get("/upload")
	public void upload() {

	}

	@Post("uploadfile")
	@UploadSizeLimit(sizeLimit=100 * 1024 * 1024, fileSizeLimit=100 * 1024 * 1024)
	public void uploadfile(UploadedFile fileUpload) {
		FilesUpload upload = new FilesUpload();
		String url = upload.upload(fileUpload);
                System.out.println(url);
		result.redirectTo(HomeController.class).home();
	}
	
	@Get("/error.jsp")
	@Public
	public void error() {
		
	}
}
