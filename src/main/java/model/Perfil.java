package model;

import util.UuidGenerator;

public class Perfil {
	private String code;
	
	private Person person;
	
	private String nickname;
	
	private String email;
	
	private String password;
	
	UuidGenerator id = new UuidGenerator();
	
	public Perfil() {
		this.code = id.Uuid();
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
