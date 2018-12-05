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
	
	
	@Get("todos_os_videos")
	public void list() {
		List<Media> media = mediaRepository.listAllVideo();
		result.include("media", media);
	}
	
	//video's page by code
	@Get("/assistir/{code}")
	public void watch(String code) {
		Media media = mediaRepository.searchMediaCode(code);
		List<Comment> comment = commentRepository.searchCommentByMedia(code);
		result.include("comment", comment);
		result.include("media", media);
	}
	//video's comments
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
	
	//delete comment in video
	@Get("delete/{code}/{pageCode}")
	public void eraseComment(String code, String pageCode) {
		Comment comment = commentRepository.searchCommentCode(code);
		commentRepository.deleteComment(comment.getCode());
		result.redirectTo(this).watch(pageCode);
	}
	
}
