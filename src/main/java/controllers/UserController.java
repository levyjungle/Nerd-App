package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadSizeLimit;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import components.UserSession;
import model.Media;
import model.Person;
import repository.MediaRepository;
import repository.PersonRepository;
import util.FilesUpload;

@Controller
public class UserController {
	@Inject
	private Result result;
	@Inject
	private UserSession userSession;
	
	PersonRepository personRepository = new PersonRepository();
	MediaRepository mediaRepository = new MediaRepository();
	FilesUpload filesUpload = new FilesUpload();
	
	@Get("conta")
	public void myAccount() {
		
	}
	
	@Post("atualizeProfile")
	public void atualizeProfile(String name, String nickname, String birthday, String sex, String city, String street, String neighborhood, String number) throws ParseException {
		
		Person person = userSession.getPerson();
		if(birthday != null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(format.parse(birthday).getTime());
			person.getProfile().setBirthday(date);
		}
	
		person.setCode(userSession.getPerson().getCode());
		person.setName(name);
		
		person.getProfile().setNickname(nickname);
		person.getProfile().setSex(sex);
		
		person.getAddress().setCity(city);
		person.getAddress().setStreet(street);
		person.getAddress().setNeighborhood(neighborhood);
		person.getAddress().setNumber(number);
		
		personRepository.updatePerson(person);
		userSession.setPerson(personRepository.searchPersonId(userSession.getPerson().getCode()));
		result.redirectTo(this).myAccount();
	}
	
	@Post("atualizeProfilePhoto")
	@UploadSizeLimit(sizeLimit = 10 * 1024 * 1024, fileSizeLimit = 10 * 1024 * 1024)
	public void atualizeProfilePhoto(UploadedFile fileUpload) {
		System.out.println(fileUpload.getFileName());
		if(fileUpload != null) {
			Map<String, String> uploadResult = filesUpload.atualizeFile(fileUpload, userSession.getPerson().getProfile().getFileProfileTag());	
			Person p = userSession.getPerson();
			
			userSession.getPerson().getProfile().setUrlProfile(uploadResult.get("url"));
			userSession.getPerson().getProfile().setFileProfileTag(uploadResult.get("public_id"));
			
			p.getProfile().setFileProfileTag(uploadResult.get("public_id"));
			p.getProfile().setUrlProfile(uploadResult.get("url"));
			
			personRepository.updatePerson(p);
		}
		result.redirectTo(this).index();
	}
	
	@Post("atualizeProfileBackground")
	@UploadSizeLimit(sizeLimit = 10 * 1024 * 1024, fileSizeLimit = 10 * 1024 * 1024)
	public void atualizeProfileBacjground(UploadedFile fileUpload) {
		System.out.println(fileUpload.getFileName());
		if(fileUpload != null) {
			Map<String, String> uploadResult = filesUpload.atualizeFile(fileUpload, userSession.getPerson().getProfile().getFileBackgroundTag());	
			Person p = userSession.getPerson();
			
			userSession.getPerson().getProfile().setUrlBackground(uploadResult.get("url"));
			userSession.getPerson().getProfile().setFileBackgroundTag(uploadResult.get("public_id"));
			
			p.getProfile().setFileBackgroundTag(uploadResult.get("public_id"));
			p.getProfile().setUrlBackground(uploadResult.get("url"));
			
			personRepository.updatePerson(p);
		}
		result.redirectTo(this).index();
	}
	
	@Get("index")
	public void index() {
		List<Media> media = mediaRepository.listAllVideo();
		result.include("media", media);
		List<Media> m = media;
		Collections.shuffle(m);
		result.include("banner", m);
	}
	
	@Get("searchMediaByName")
	public void listMediaByName(String movieName) {
		List<Media> media = mediaRepository.searchMediaByName(movieName);
		result.include("movie", media);
		result.redirectTo(this).index();
	}
	
}
