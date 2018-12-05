package controllers;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import components.UserSession;
import model.Media;
import model.MediaTags;
import model.Tag;
import repository.MediaRepository;
import repository.MediaTagRepository;
import repository.TagRepository;

@Controller
@Path("admin/movie")
public class MovieController {
	@Inject
	private Result result;
	@Inject
	private UserSession userSession;
	
	MediaRepository mediaRepository = new MediaRepository();
	MediaTagRepository mediaTagRepository = new MediaTagRepository();
	TagRepository tagRepository = new TagRepository();
	
	//main return all media in database
	@Get("/")
	public void edittagmovie() {
		if(userSession.getPerson().getAdmin().equals("1")) {
			 List<Media> media = mediaRepository.listAllVideo();
			 result.include("media", media);
		}else{
			result.redirectTo(HomeController.class).home();
		}
	}
	
	//get url code and search this in database 
	@Get("edit/{code}")
	public void movietagmanager(String code) {
		if(userSession.getPerson().getAdmin().equals("1")) {
			Media media = mediaRepository.searchMediaCode(code);
			List<MediaTags> mediaTag = mediaTagRepository.searchTagByMediaCode(code);
			List<Tag> tag = tagRepository.listAllTag();
			result.include("tag", tag);
			result.include("mediaTag", mediaTag);
			result.include("media", media);
		}else{
			result.redirectTo(HomeController.class).home();
		}
	}
}
