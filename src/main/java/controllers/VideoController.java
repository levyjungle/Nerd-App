package controllers;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import components.UserSession;
import model.Comment;
import model.Media;
import repository.CommentRepository;
import repository.MediaRepository;

@Controller
@Path("video")
public class VideoController {
	@Inject
	private Result result;
	@Inject
	private UserSession userSession;

	MediaRepository mediaRepository = new MediaRepository();
	CommentRepository commentRepository = new CommentRepository();
	
	@Get("/todos_os_videos")
	public void lista() {
		List<Media> media = mediaRepository.listAllVideo();
		result.include("media", media);
		result.include("result", "false");
	}
	
	@Get("/meus_videos")
	 public void myvideo(){            
        String personCode = userSession.getPerson().getCode();
        List<Media> media =  mediaRepository.sharedMediaBySpecificUser(personCode, "person.code");
        result.include("media", media);
        result.include("result", "true");
    }
	
	@Get("/editar/{code}")
	public void edit(String code) {
		Media media = mediaRepository.searchMediaCode(code);	
		if (!media.getPerson().getCode().equals(userSession.getPerson().getCode())) {
			result.redirectTo(IndexController.class).index();
		}else {
			List<Comment> comment = commentRepository.searchCommentByMedia(code);
			result.include("comment", comment);
			result.include("media", media);
		}
	}

	@Get("/assistir/{code}")
	public void watch(String code) {
		Media media = mediaRepository.searchMediaCode(code);
		List<Comment> comment = commentRepository.searchCommentByMedia(code);
		result.include("comment", comment);
		result.include("media", media);
	}
	
	@Post("editFile")
	public void editFile(String code, String name, String synopsis) {
		Media media = mediaRepository.searchMediaCode(code);
		if(media.getPerson().getCode().equals(userSession.getPerson().getCode())) {
			media.setName(name);
			media.setSynopsis(synopsis);
			
			mediaRepository.updateMedia(media);
		}
		result.redirectTo(IndexController.class).index();
	}
	
	@Post("videoComment")
	public void videoComment(String videoCode, String message) {	
		Media media = mediaRepository.searchMediaCode(videoCode);
		if(media != null) {
			Comment comment = new Comment();
			
			comment.commentUuid();
			comment.setComment(message);
			comment.setDatetime(new Date(System.currentTimeMillis()));
			comment.setPerson(userSession.getPerson());
			comment.setMedia(media);
			
			commentRepository.saveComment(comment);
		}
		result.redirectTo(this).watch(media.getCode());
	}
	
	@Get("delete/{code}/{pageCode}")
	public void eraseComment(String code, String pageCode) {
		Comment comment = commentRepository.searchCommentCode(code);
		commentRepository.deleteComment(comment.getCode());
		result.redirectTo(this).watch(pageCode);
	}
	
}
