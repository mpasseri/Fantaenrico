package it.fantaenrico.client.entities;

import javax.persistence.*;

@Entity
public class FootballPlayer {
	
	private long uidfootballplayer;
	
	private String name;
	
	private double initialvalue;
	private double currentvalue;
	
	@Enumerated(EnumType.STRING)
	private FootballTeam team;
	
	@Enumerated(EnumType.STRING)
	private FootballPlayerRole role;
	
	@Id
	@SequenceGenerator(name="FOOTBALLPLAYER_UIDTEAMPLAYER_GENERATOR", sequenceName="FE_SEQ_FOOTBALLPLAYER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FOOTBALLPLAYER_UIDTEAMPLAYER_GENERATOR")
	@Column(unique=true, nullable=false, precision=19)
	public long getUidfootballplayer() {
		return this.uidfootballplayer;
	}

	public void setUidfootballplayer(long uidfootballplayer) {
		this.uidfootballplayer = uidfootballplayer;
	}

	@Column(unique=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=3)
	public double getInitialvalue() {
		return initialvalue;
	}

	public void setInitialvalue(int initialvalue) {
		this.initialvalue = initialvalue;
	}

	@Column(length=3)
	public double getCurrentvalue() {
		return currentvalue;
	}

	public void setCurrentvalue(int currentvalue) {
		this.currentvalue = currentvalue;
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
		return name + " (" + role + ", " + team + ", " + currentvalue + ")";
	}
	

}
