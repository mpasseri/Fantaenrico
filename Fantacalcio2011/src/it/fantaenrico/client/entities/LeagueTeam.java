package it.fantaenrico.client.entities;

import javax.persistence.*;

@Entity
public class LeagueTeam {
	
	/* The FantasyTeam which this team belongs to */
	@Id
	private String fantasy_team_name;
	/* The league in which this squad is participating */
	private String league_name;
	private League league;
	private int remaining_budget;
	/* Arrays representing the players in a squad divided by role */
	private TeamPlayer[] goalkeepers;
	private TeamPlayer[] defenders;
	private TeamPlayer[] midfielders;
	private TeamPlayer[] forwards;

}
