package model;

import util.UuidGenerator;

public class Tag {
	private String code;
	private String taglist;
	
	UuidGenerator id = new UuidGenerator();
	
	public Tag() {
		this.code = id.Uuid();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTaglist() {
		return taglist;
	}

	public void setTaglist(String taglist) {
		this.taglist = taglist;
	}
	
}
