package it.fantaenrico.client.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class League {
	
	@Id
	private String name; // The name identifies uniquely a league
	
	private String participants_number;
	private int team_budget;
	private boolean is_open; // In an open league, users are free to participate, in a not-open league the participants have to be invited by the owner or the administrators
	private String owner; // The username of the creator and owner of the league
	private List<String> administrators; // The list of the administrators username, they have to be authorized by the owner
	private List<String> participant_fantasy_teams; // The list of the teams' name participating in the league
	
	/* TEAM RULES - Indicates how many player per role a team can have - A value of -1 means no limits */
	private int goalkeepers_number;
	private int defenders_number;
	private int midfielders_number;
	private int forwards_number;

}
