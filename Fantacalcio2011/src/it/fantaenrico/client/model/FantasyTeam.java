package it.fantaenrico.client.model;

import java.util.List;

public class FantasyTeam {
	
	private String name; // The name of a team that identifies it uniquely in the application
	private String owner; // The username of the owner of the team
	private List<String> managers; // The list of the usernames of the secondary managers of the team, selected by the owner

	@Override
	public boolean equals(Object that) {
		if(this==that)
			return true;
		else if(!(that instanceof FantasyTeam))
			return false;
		else {
			return ((this.name.equals(((FantasyTeam)that).name))&&
					(this.owner.equals(((FantasyTeam)that).owner)));
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+owner.hashCode();
	}
	
	
}
