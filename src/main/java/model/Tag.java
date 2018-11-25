package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag {
	
	@Id
	private String code;
	
	@Column(length = 50, nullable = false)
	private String tagName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTaglist() {
		return tagName;
	}

	public void setTaglist(String tagName) {
		this.tagName = tagName;
	}
	
}
