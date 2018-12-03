package model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import util.Crypt;

@Entity
public class Profile {
	
	@Id
	private String code;
	
	@Column(length = 30)
	private String nickname;
	
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(length = 30)
	private Date birthday;
	
	@Column(length = 30)
	private String sex;
	
	@Column(length = 100 , nullable = false)
	private String password;
	
	private String urlProfile;
	
	private String urlBackground;
	
	public String getCode() {
		return code;
	}

	public String getUrlProfile() {
		return urlProfile;
	}

	public void setUrlProfile(String urlProfile) {
		this.urlProfile = urlProfile;
	}

	public String getUrlBackground() {
		return urlBackground;
	}

	public void setUrlBackground(String urlBackground) {
		this.urlBackground = urlBackground;
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
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void profileUuid() {
		this.code = UUID.randomUUID().toString();
	}
}
