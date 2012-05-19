package it.fantaenrico.client.model;

public class ConfrontationTournament extends Tournament {
	

	private int home_points; // Additional points for the team playing home can be added to the score

	public ConfrontationTournament(String leagueName, int startDay) {
		super(leagueName, startDay);
		// TODO Auto-generated constructor stub
	}
	
	public ConfrontationTournament(String leagueName, int startDay, int duration) {
		super(leagueName, startDay, duration);
		// TODO Auto-generated constructor stub
	}
	
}
