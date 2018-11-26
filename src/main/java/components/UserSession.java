package components;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Person;

@SessionScoped
@Named("userSession")
public class UserSession implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isLogged;
	
	private Person person;
	
	public boolean isLogged() {
		return isLogged;
		
	}
	
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
