package model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Media {

	@Id
	private String code;

	@JoinColumn
	@OneToOne(fetch = FetchType.EAGER)
	private Person person;
	
	@Column(length = 50)
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String synopsis;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	private String urlVideo;
	
	private String urlPhoto;
	
	private String mediaVideoName;
	
	private String mediaPhotoName;
	
	public String getMediaVideoName() {
		return mediaVideoName;
	}

	public void setMediaVideoName(String mediaVideoName) {
		this.mediaVideoName = mediaVideoName;
	}

	public String getMediaPhotoName() {
		return mediaPhotoName;
	}

	public void setMediaPhotoName(String mediaPhotoName) {
		this.mediaPhotoName = mediaPhotoName;
	}

	@Column(length = 50)
	private String mediaVideoType;
	
	@Column(length = 50)
	private String mediaPhotoType;
	
	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public String getMediaVideoType() {
		return mediaVideoType;
	}

	public void setMediaVideoType(String mediaVideoType) {
		this.mediaVideoType = mediaVideoType;
	}

	public String getMediaPhotoType() {
		return mediaPhotoType;
	}

	public void setMediaPhotoType(String mediaPhotoType) {
		this.mediaPhotoType = mediaPhotoType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	public void mediaUuid() {
		this.code = UUID.randomUUID().toString();
	}

}
