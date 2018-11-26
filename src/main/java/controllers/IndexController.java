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

import model.Address;
import model.Person;
import model.Profile;
import repository.PersonRepository;
import repository.ProfileRepository;
import util.Crypt;
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

	}

	@Public
	@Post("logar")
	public void login(String email, String password) {
		ProfileRepository profileRepository = new ProfileRepository();
		Profile pro = profileRepository.searchEspecificProfileEmail(email);
		if (pro == null) {
			result.redirectTo(IndexController.class).index();
		} else {
			boolean confirmPassword = Crypt.verifyHash(password, pro.getPassword());
			System.out.println(confirmPassword);
			if (email.equals(pro.getEmail()) && confirmPassword) {
				userSession.setLogged(true);
				result.redirectTo(HomeController.class).home();
			} else {
				result.redirectTo(IndexController.class).index();
			}
		}
	}

	@Public
	@Get("/cadastro")
	public void register() {

	}

	@Public
	@Post("sendRegister")
	public void userRegister(String name, String nickname, String email, String password) {
		ProfileRepository profileRepository = new ProfileRepository();
		Profile pro = profileRepository.searchEspecificProfileEmail(email);
		if (pro == null) {
			PersonRepository personRepository = new PersonRepository();
			Person person = new Person();
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
			result.redirectTo(HomeController.class).home();
		} else {
			result.redirectTo(IndexController.class).index();
		}
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
	@UploadSizeLimit(sizeLimit = 100 * 1024 * 1024, fileSizeLimit = 100 * 1024 * 1024)
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
