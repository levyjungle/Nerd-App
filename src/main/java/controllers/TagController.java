package controllers;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import components.UserSession;
import model.Tag;
import repository.TagRepository;

@Controller
@Path("admin/tag")
public class TagController {
	@Inject
	private Result result;
	@Inject
	private UserSession userSession;
	
	TagRepository tagRepository = new TagRepository();
	
	@Get("/")
	public void addtag() {
		List<Tag> tag = tagRepository.listAllTag();
		result.include("tag", tag);
		
	}
	
	@Post("insertTag")
	public void insertTag(String tagName) {
		if(userSession.getPerson().getAdmin().equals("1")) {
			Tag tag = new Tag();
			
			tag.UuidTag();
			tag.setTagName(tagName);
			
			tagRepository.saveTag(tag);
			
			result.redirectTo(this).addtag();
		}else{
			result.redirectTo(HomeController.class).home();
		}
	}
	
	@Get("removeTag/{code}")
	public void removeTag(String code) {
		if(userSession.getPerson().getAdmin().equals("1")) {
			Tag tag = tagRepository.searchTagByCode(code);
			tagRepository.deleteTag(tag.getCode());
			result.redirectTo(this).addtag();
		}else {
			result.redirectTo(HomeController.class).home();
		}
	}
	
	@Post("searchTag")
	public void searchTag(String tagName) {
		if(userSession.getPerson().getAdmin().equals("1")) {
			if(tagName !=null) {
				List<Tag> tag = tagRepository.searchTagByName(tagName);
				result.include("result",tag);
			}else {
				result.include("result", "null");
			}
			result.redirectTo(this).addtag();
		}else {
			result.redirectTo(HomeController.class).home();
		}
	}
}
