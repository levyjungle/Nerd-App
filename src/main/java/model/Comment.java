package model;

import java.util.Date;
import java.util.Set;

import util.UuidGenerator;

public class Comment {
	private String code;
	private Set<Person> person;
	private Media media;
	private String comment;
	private Date datetime;

	UuidGenerator id = new UuidGenerator();

	public Comment() {
		this.code = id.Uuid();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<Person> getPerson() {
		return person;
	}

	public void setPerson(Set<Person> person) {
		this.person = person;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}
