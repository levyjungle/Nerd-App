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
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Person person;
	
	@Column(length = 50)
	private String name;

	private String synopsis;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	private String url;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = UUID.randomUUID().toString();
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
