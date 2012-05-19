package it.fantaenrico.client.model;

public class LeagueTeam {

	/* The FantasyTeam which this team belongs to */
	private String fantasy_team_name;
	/* The league in which this squad is participating */
	private String league_name;
	private League league;
	private int remaining_budget;
	/* Arrays representing the players in a squad divided by role */
	private Player[] goalkeepers;
	private Player[] defenders;
	private Player[] midfielders;
	private Player[] forwards;

	public LeagueTeam(String fantasy_team_name, String league_name) {
		this.fantasy_team_name = fantasy_team_name;
		this.league_name = league_name;
	}


	/* GETTERS AND SETTERS */
	public String getFantasy_team_name() {
		return fantasy_team_name;
	}

	public void setFantasy_team_name(String fantasyTeamName) {
		fantasy_team_name = fantasyTeamName;
	}

	public String getLeague_name() {
		return league_name;
	}

	public void setLeague_name(String leagueName) {
		league_name = leagueName;
	}

	public League getLeague() {
		if(league!=null)
			return league;
		else
			return null; // LAZY LOAD FOR THE LEAGUE
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public int getRemaining_budget() {
		return remaining_budget;
	}

	public void setRemaining_budget(int remainingBudget) {
		remaining_budget = remainingBudget;
	}

	public Player[] getGoalkeepers() {
		return goalkeepers;
	}

	public void setGoalkeepers(Player[] goalkeepers) {
		this.goalkeepers = goalkeepers;
	}

	public Player[] getDefenders() {
		return defenders;
	}

	public void setDefenders(Player[] defenders) {
		this.defenders = defenders;
	}

	public Player[] getMidfielders() {
		return midfielders;
	}

	public void setMidfielders(Player[] midfielders) {
		this.midfielders = midfielders;
	}

	public Player[] getForwards() {
		return forwards;
	}

	public void setForwards(Player[] forwards) {
		this.forwards = forwards;
	}
	/* END GETTERS AND SETTERS */

	/* eauals() and hashCode() - A league team is identified by its fantasy team name and the name of the league it is participating into */
	@Override
	public boolean equals(Object that) {
		if(this==that)
			return true;
		else if(!(that instanceof LeagueTeam))
			return false;
		else {
			return ((this.fantasy_team_name.equals(((LeagueTeam)that).fantasy_team_name))&&
					(this.league_name.equals(((LeagueTeam)that).league_name)));
		}
	}

	@Override
	public int hashCode() {
		return fantasy_team_name.hashCode()+league_name.hashCode();
	}

}
