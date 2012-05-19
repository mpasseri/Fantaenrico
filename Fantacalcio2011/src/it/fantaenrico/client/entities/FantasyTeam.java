package it.fantaenrico.client.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class FantasyTeam {

	@Id
	private String name;
	
	private String owner_userID; // the google account user id of the owner
	
	private List<String> manager_userID; // the google accounts user id of the managers of the team
	
}
