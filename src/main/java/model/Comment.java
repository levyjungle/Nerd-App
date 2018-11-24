package model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {

	@Id
	private String code;

	@JoinColumn
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Person> person;

	@JoinColumn
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Media media;

	private String comment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	public String getCode() {
		return code;
	}

	public void setCode() {
		this.code = UUID.randomUUID().toString();
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
