package it.fantaenrico.client.model;

import java.util.Map;
import java.util.Set;

public abstract class Tournament {
	
	private String league_name;
	
	private int start_day; // The beginning day of the tournament in referral to the soccer league
	private int duration; // The number of days of the tournament
	private Map<LeagueTeam, Double> standings; // The standings of the tournament
	private Set<Day> tournament_days;
	
	public Tournament(String league_name, int start_day) {
		this.league_name = league_name;
		this.start_day = start_day;
	}
	
	public Tournament(String league_name, int start_day, int duration) {
		this(league_name, start_day);
		this.duration = duration;
	}
	
	@Override
	public boolean equals(Object that) {
		if(this==that)
			return true;
		else if(!(that instanceof Tournament))
			return false;
		else {
			return ((this.start_day==((Tournament)that).start_day)&&
					this.league_name.equals(((Tournament)that).league_name));
		}
	}
	
	@Override
	public int hashCode() {
		return start_day+league_name.hashCode();
	}
	
	

}
