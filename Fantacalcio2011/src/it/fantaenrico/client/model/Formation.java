package it.fantaenrico.client.model;

import java.util.HashMap;
import java.util.Map;

public class Formation {

	private Scheme scheme; // The scheme used in this formation, must be one from the enumeration type
	private LeagueTeam team; // The league team using this formation
	private int day; // The day of the football championship related to this formation
	private double score; // The total score of this formation

	/* The players composing this formation */
	private Map<Player, Double> goalkeepers;
	private Map<Player, Double> defenders;
	private Map<Player, Double> midfielders;
	private Map<Player, Double> forwards;

	public Formation(Scheme scheme) {
		this.scheme = scheme;
		goalkeepers = new HashMap<Player, Double>(2);
		defenders = new HashMap<Player, Double>(this.scheme.defenders+2);
		midfielders = new HashMap<Player, Double>(this.scheme.midfielders+2);
		forwards = new HashMap<Player, Double>(this.scheme.forwards+2);
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

	/* To reset the formation to empty */
	private void resetFormation() {
		goalkeepers = new HashMap<Player, Double>(2);
		defenders = new HashMap<Player, Double>(this.scheme.defenders+2);
		midfielders = new HashMap<Player, Double>(this.scheme.midfielders+2);
		forwards = new HashMap<Player, Double>(this.scheme.forwards+2);
	}
	
	/* To add players to the formation, the number of players in the lists must be checked everytime */
	public void addGoalkeeper(Player p, double vote) throws Exception {
		if(p==null)
			throw new Exception("Null player");
		else if(goalkeepers.size()>=2)
			throw new Exception("Goalkeepers are complete");
		else if (!goalkeepers.containsKey(p))
			throw new Exception("Goalkeeper already in formation");
		else 
			goalkeepers.put(p, vote);
	}
	public void addGoalkeeper(Player p) throws Exception {
		this.addGoalkeeper(p, 0);
	}
	
	public void addDefender(Player p, double vote) throws Exception {
		if(p==null)
			throw new Exception("Null player");
		else if(defenders.size()>=scheme.defenders+2)
			throw new Exception("Defenders are complete");
		else if (!defenders.containsKey(p))
			throw new Exception("Defender already in formation");
		else 
			defenders.put(p, vote);
	}
	public void addDefender(Player p) throws Exception {
		this.addDefender(p, 0);
	}
	
	public void addMidfielder(Player p, double vote) throws Exception {
		if(p==null)
			throw new Exception("Null player");
		else if(midfielders.size()>=scheme.midfielders+2)
			throw new Exception("Midfielders are complete");
		else if (!midfielders.containsKey(p))
			throw new Exception("Midfielder already in formation");
		else 
			midfielders.put(p, vote);
	}
	public void addMidfielder(Player p) throws Exception {
		this.addMidfielder(p, 0);
	}
	
	public void addForward(Player p, double vote) throws Exception {
		if(p==null)
			throw new Exception("Null player");
		else if(forwards.size()>=scheme.forwards+2)
			throw new Exception("Forwards are complete");
		else if (!forwards.containsKey(p))
			throw new Exception("Forward already in formation");
		else 
			forwards.put(p, vote);
	}
	public void addForward(Player p) throws Exception {
		this.addForward(p, 0);
	}
	
	/* To remove a player from the formation its name must be specified */
	public void removeGoalkeeper(Player p) throws Exception {
		Double removed=null;
		if(p!=null) {
			removed = goalkeepers.remove(p);
		}
		if(removed==null)
			throw new Exception("The player was not removed from the formation");
	}
	
	public void removeDefender(Player p) throws Exception {
		Double removed=null;
		if(p!=null) {
			removed = defenders.remove(p);
		}
		if(removed==null)
			throw new Exception("The player was not removed from the formation");
	}
	
	public void removeMidfielder(Player p) throws Exception {
		Double removed=null;
		if(p!=null) {
			removed = midfielders.remove(p);
		}
		if(removed==null)
			throw new Exception("The player was not removed from the formation");
	}
	
	public void removeForward(Player p) throws Exception {
		Double removed=null;
		if(p!=null) {
			removed = forwards.remove(p);
		}
		if(removed==null)
			throw new Exception("The player was not removed from the formation");
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


}
