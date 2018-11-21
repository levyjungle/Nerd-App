package model;

import util.UuidGenerator;

public class Person {
	
	private String code;
	
	private String name;
	
	UuidGenerator  id = new UuidGenerator();
	
	public Person() {
		this.code = id.Uuid();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
