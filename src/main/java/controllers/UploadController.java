package controllers;

import java.util.Date;
import java.util.Map;

import javax.inject.Inject;

import annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadSizeLimit;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import components.UserSession;

import model.Address;
import model.Media;
import model.Person;
import model.Profile;
import repository.MediaRepository;
import repository.PersonRepository;
import util.Crypt;
import util.FilesUpload;


@Controller
public class UploadController {
	
	@Inject
	private Result result;
	@Inject
	private UserSession userSession;
	
	/*
	@Public
	@Get("/")
	public void index() {
		if(userSession.isLogged()) {
			result.redirectTo(HomeController.class).home();
		}
	}
	

	@Public
	@Post("logar")
	public void login(String email, String password) {
		PersonRepository personRepository = new PersonRepository();
		Person person = personRepository.searchSpecificEntityValueIntoPerson("profile", "email", email);
		if (person == null) {
			result.redirectTo(IndexController.class).index();
		} else {
			boolean confirmPassword = Crypt.verifyHash(password, person.getProfile().getPassword());
			if (email.equals(person.getProfile().getEmail()) && confirmPassword) {
				userSession.setLogged(true);
			
				userSession.setPerson(person);
				result.redirectTo(HomeController.class).home();
			} else {
				result.redirectTo(IndexController.class).index();
			}
		}
	}

	@Public
	@Get("/cadastro")
	public void register() {
		if(userSession.isLogged()) {
			result.redirectTo(HomeController.class).home();
		}
	}

	@Public
	@Post("sendRegister")
	public void userRegister(String name, String nickname, String email, String password) {
		PersonRepository personRepository = new PersonRepository();
		Person p = personRepository.searchSpecificEntityValueIntoPerson("profile", "email", email);
		if (p == null) {
			final Person person = new Person();
			Profile profile = new Profile();
			Address address = new Address();

			profile.profileUuid();
			profile.setEmail(email);
			profile.setNickname(nickname);
			profile.setPassword(password);

			address.addressUuid();

			person.personUuid();
			person.setName(name);
			person.setAddress(address);
			person.setProfile(profile);

			userSession.setLogged(true);
			personRepository.savePerson(person);

			userSession.setPerson(person);
			result.redirectTo(HomeController.class).home();
		} else {
			result.redirectTo(IndexController.class).index();
		}
	}
	*/
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
	@UploadSizeLimit(sizeLimit = 100 * 1024 * 1024, fileSizeLimit = 100 * 1024 * 1024)
	public void uploadfile(String title, String synopsis, UploadedFile fileUpload) {
		if(fileUpload != null) {
			FilesUpload upload = new FilesUpload();
			MediaRepository mediaRepository = new MediaRepository();
			
			Media media = new Media();
			Map<String, String> uploadResult = upload.upload(fileUpload);
			
			media.mediaUuid();
			media.setDatetime(new Date(System.currentTimeMillis()));
			media.setName(title);
			media.setSynopsis(synopsis);
			media.setPerson(userSession.getPerson());
			media.setUrl(uploadResult.get("url"));
			media.setMediaName(uploadResult.get("public_id"));
			media.setMediaType(fileUpload.getContentType());
			
			mediaRepository.saveMedia(media);
		}
		
		result.redirectTo(IndexController.class).index();
	}
	
}
