package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import components.UserSession;
import model.Person;
import repository.PersonRepository;

@Controller
public class UserController {
	@Inject
	private Result result;
	@Inject
	private UserSession userSession;
	
	PersonRepository personRepository = new PersonRepository();
	
	@Get("conta")
	public void myAccount() {
		
	}
	
	@Post("atualizeProfile")
	public void atualizeProfile(String name, String nickname, String birthday, String sex, String city, String street, String neighborhood, String number) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(format.parse(birthday).getTime());
		
		Person person = userSession.getPerson();
		person.setCode(userSession.getPerson().getCode());
		person.setName(name);
		
		person.getProfile().setNickname(nickname);
		person.getProfile().setBirthday(date);
		person.getProfile().setSex(sex);
		
		person.getAddress().setCity(city);
		person.getAddress().setStreet(street);
		person.getAddress().setNeighborhood(neighborhood);
		person.getAddress().setNumber(number);
		
		personRepository.updatePerson(person);
		userSession.setPerson(personRepository.searchPersonId(userSession.getPerson().getCode()));
		result.redirectTo(this).myAccount();
	}
	
	@Get("perfil")
	public void perfil() {
		
	}
}
