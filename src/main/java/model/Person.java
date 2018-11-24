package model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	private String code;

	@Column(length = 100, nullable = false)
	private String name;

	@JoinColumn
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address address;

	@JoinColumn
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Profile profile;

	public String getCode() {
		return code;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public void setCode() {
		this.code = UUID.randomUUID().toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
