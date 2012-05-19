package it.fantaenrico.client.entities;

import javax.persistence.*;

@Entity
public class FootballPlayer {
	
	@Id
	String name;
	
	int initial_value;
	int current_value;
	
	@Enumerated(EnumType.STRING)
	FootballTeam team;
	
	@Enumerated(EnumType.STRING)
	FootballPlayerRole role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInitial_value() {
		return initial_value;
	}

	public void setInitial_value(int initialValue) {
		initial_value = initialValue;
	}

	public int getCurrent_value() {
		return current_value;
	}

	public void setCurrent_value(int currentValue) {
		current_value = currentValue;
	}

	public FootballTeam getTeam() {
		return team;
	}

	public void setTeam(FootballTeam team) {
		this.team = team;
	}

	public FootballPlayerRole getRole() {
		return role;
	}

	public void setRole(FootballPlayerRole role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return name + " (" + role + ", " + team + ", " + current_value + ")";
	}
	

}
