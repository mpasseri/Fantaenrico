package it.fantaenrico.client.entities;

import javax.persistence.*;

import com.google.gwt.user.client.rpc.IsSerializable;

@Entity
public class User implements IsSerializable {
	
	private String name;
	private String surname;
	private String email;
	
	@Id
	private String username;
	
	public User() {
		
	}
	
	public User(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	public User(String name, String surname, String username, String email) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
	}

}
