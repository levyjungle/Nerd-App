package model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MediaTags {

	@Id
	private String code;
	
	@JoinColumn
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Media media;
	
	@JoinColumn
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Tag> tag;
	

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public String getCode() {
		return code;
	}

	public void setCode() {
		this.code = UUID.randomUUID().toString();
	}

	public Set<Tag> getTag() {
		return tag;
	}

	public void setTag(Set<Tag> tag) {
		this.tag = tag;
	}

}
