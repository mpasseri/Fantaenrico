package it.fantaenrico.client.entities;

public enum Scheme {
	
	F_3_4_3(3,4,3),
	F_3_5_2(3,5,2),
	F_4_3_3(4,3,3),
	F_4_4_2(4,4,2),
	F_4_5_1(4,5,1),
	F_5_4_1(5,4,1),
	F_5_3_2(5,3,2);
	
	final int goalkeepers;
	final int defenders;
	final int midfielders;
	final int forwards;
	
	Scheme(int defenders, int midfielders, int forwards) {
		this.goalkeepers = 1;
		this.defenders = defenders;
		this.midfielders = midfielders;
		this.forwards = forwards;
	}

}
