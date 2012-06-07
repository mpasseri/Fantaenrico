package it.fantaenrico.client.entities;

import it.fantaenrico.client.exception.FormationException;

import java.util.HashMap;
import java.util.Map;

public class Formation {

	private Scheme scheme; // The scheme used in this formation, must be one from the enumeration type
	private String team; // The league team using this formation
	private int day; // The day of the football championship related to this formation
	private double score; // The total score of this formation

	/* The players composing this formation, the String represents the unique name of the player */
	private Map<String, Double> goalkeepers;
	private Map<String, Double> defenders;
	private Map<String, Double> midfielders;
	private Map<String, Double> forwards;

	public Formation(Scheme scheme) {
		this.scheme = scheme;
		goalkeepers = new HashMap<String, Double>(2);
		defenders = new HashMap<String, Double>(this.scheme.defenders+2);
		midfielders = new HashMap<String, Double>(this.scheme.midfielders+2);
		forwards = new HashMap<String, Double>(this.scheme.forwards+2);
	}

	public Scheme getScheme() {
		return scheme;
	}

	/* If a new scheme is selected the formation must be reset */
	public void setScheme(Scheme scheme) {
		if(!this.scheme.name().equals(scheme.name())) {
			this.scheme = scheme;
			resetFormation();
		}
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	/* To reset the formation to empty */
	private void resetFormation() {
		goalkeepers = new HashMap<String, Double>(2);
		defenders = new HashMap<String, Double>(this.scheme.defenders+2);
		midfielders = new HashMap<String, Double>(this.scheme.midfielders+2);
		forwards = new HashMap<String, Double>(this.scheme.forwards+2);
	}
	
	/* To add players to the formation, the number of players in the lists must be checked everytime */
	public void addGoalkeeper(String p, double vote) throws FormationException {
		if(p==null||p.equals(""))
			throw new FormationException("Null player");
		else if(goalkeepers.size()>=2)
			throw new FormationException("Goalkeepers are complete");
		else if (goalkeepers.containsKey(p))
			throw new FormationException("Goalkeeper already in formation");
		else 
			goalkeepers.put(p, vote);
	}
	public void addGoalkeeper(String p) throws FormationException {
		this.addGoalkeeper(p, 0);
	}
	
	public void addDefender(String p, double vote) throws FormationException {
		if(p==null||p.equals(""))
			throw new FormationException("Null player");
		else if(defenders.size()>=scheme.defenders+2)
			throw new FormationException("Defenders are complete");
		else if (defenders.containsKey(p))
			throw new FormationException("Defender already in formation");
		else 
			defenders.put(p, vote);
	}
	public void addDefender(String p) throws FormationException {
		this.addDefender(p, 0);
	}
	
	public void addMidfielder(String p, double vote) throws FormationException {
		if(p==null||p.equals(""))
			throw new FormationException("Null player");
		else if(midfielders.size()>=scheme.midfielders+2)
			throw new FormationException("Midfielders are complete");
		else if (midfielders.containsKey(p))
			throw new FormationException("Midfielder already in formation");
		else 
			midfielders.put(p, vote);
	}
	public void addMidfielder(String p) throws FormationException {
		this.addMidfielder(p, 0);
	}
	
	public void addForward(String p, double vote) throws FormationException {
		if(p==null||p.equals(""))
			throw new FormationException("Null player");
		else if(forwards.size()>=scheme.forwards+2)
			throw new FormationException("Forwards are complete");
		else if (forwards.containsKey(p))
			throw new FormationException("Forward already in formation");
		else 
			forwards.put(p, vote);
	}
	public void addForward(String p) throws FormationException {
		this.addForward(p, 0);
	}
	
	/* To remove a player from the formation its name must be specified */
	public void removeGoalkeeper(String p) throws FormationException {
		Double removed=null;
		if(p!=null) {
			removed = goalkeepers.remove(p);
		}
		if(removed==null)
			throw new FormationException("The player was not removed from the formation");
	}
	
	public void removeDefender(String p) throws FormationException {
		Double removed=null;
		if(p!=null) {
			removed = defenders.remove(p);
		}
		if(removed==null)
			throw new FormationException("The player was not removed from the formation");
	}
	
	public void removeMidfielder(String p) throws FormationException {
		Double removed=null;
		if(p!=null) {
			removed = midfielders.remove(p);
		}
		if(removed==null)
			throw new FormationException("The player was not removed from the formation");
	}
	
	public void removeForward(String p) throws FormationException {
		Double removed=null;
		if(p!=null) {
			removed = forwards.remove(p);
		}
		if(removed==null)
			throw new FormationException("The player was not removed from the formation");
	}
	
	@Override
	public boolean equals(Object that) {
		if(this==that)
			return true;
		else if(!(that instanceof Formation))
			return false;
		else {
			return (this.team.equals(((Formation)that).team));
		}
	}
	
	@Override
	public int hashCode() {
		return team.hashCode();
	}
	
	@Override
	public String toString() {
		String result = "Team: "+this.team+"\n";
		result += "Scheme: "+this.scheme+"\n";
		result += "Score: "+this.score;
		return result;
	}


}
