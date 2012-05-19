package it.fantaenrico.client.model;

import java.util.List;

public class League {
	
	private String name; // The name identifies uniquely a league
	private String participants_number;
	private int team_budget;
	private boolean is_open; // In an open league, users are free to participate, in a not-open league the participants have to be invited by the owner or the administrators
	private String owner; // The username of the creator and owner of the league
	private List<String> administrators; // The list of the administrators username, they have to be authorized by the owner
	private List<String> participants; // The list of the teams' name participating in the league
	
	/* TEAM RULES */
	private int goalkeepers_number;
	private int defenders_number;
	private int midfielders_number;
	private int forwards_number;
	
	public int getGoalkeepers_number() {
		return goalkeepers_number;
	}
	public void setGoalkeepers_number(int goalkeepersNumber) {
		goalkeepers_number = goalkeepersNumber;
	}
	public int getDefenders_number() {
		return defenders_number;
	}
	public void setDefenders_number(int defendersNumber) {
		defenders_number = defendersNumber;
	}
	public int getMidfielders_number() {
		return midfielders_number;
	}
	public void setMidfielders_number(int midfieldersNumber) {
		midfielders_number = midfieldersNumber;
	}
	public int getForwards_number() {
		return forwards_number;
	}
	public void setForwards_number(int forwardsNumber) {
		forwards_number = forwardsNumber;
	}
	
	/* END TEAM RULES */
	
	@Override
	public boolean equals(Object that) {
		if(this==that)
			return true;
		else if(!(that instanceof League))
			return false;
		else {
			return ((this.name.equals(((League)that).name))&&
					(this.owner.equals(((League)that).owner)));
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+owner.hashCode();
	}
	
	


}
