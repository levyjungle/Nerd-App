package model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import util.Crypt;

@Entity
public class Profile {
	
	@Id
	private String code;
	
	@Column(length = 30)
	private String nickname;
	
	@Column(length = 30, nullable = false, unique = true)
	private String email;
	
	@Column(length = 50 , nullable = false)
	private String password;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		this.password = Crypt.hash(password);
	}
	
	public void profileUuid() {
		this.code = UUID.randomUUID().toString();
	}
}
