package model;

import java.util.Set;

import util.UuidGenerator;

public class MediaTags {
	private String code;
	private Set<Media> media;
	private Set<Tag> tag;
	
	UuidGenerator id = new UuidGenerator();
	
	public MediaTags() {
		this.code = id.Uuid();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<Media> getMedia() {
		return media;
	}

	public void setMedia(Set<Media> media) {
		this.media = media;
	}

	public Set<Tag> getTag() {
		return tag;
	}

	public void setTag(Set<Tag> tag) {
		this.tag = tag;
	}
	
}
