package it.fantaenrico.client.model;

public class Player {
	
	private String name;
	private PlayerRole role;
	private String football_team;
	private int initial_value;
	private int current_value;
	
	public Player(String name) {
		this.name = name;
	}
	
	public Player(String name, PlayerRole role) {
		this(name);
		this.role = role;
	}
	
	public Player(String name, PlayerRole role, String football_team) {
		this(name,role);
		this.football_team = football_team;
	}
	
	@Override
	public boolean equals(Object that) {
		if(this==that)
			return true;
		else if(!(that instanceof Player))
			return false;
		else {
			return (((Player)that).name.equals(this.name));
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
