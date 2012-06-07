package it.fantaenrico.client.model;

import it.fantaenrico.client.entities.FootballChampionshipDay;

public abstract class Day {
	
	private int number;
	private FootballChampionshipDay championship_day; // the football championship day associated to this day
	private Tournament tournament; // The fantasy tournament this day belongs to
	
	@Override
	public boolean equals(Object that) {
		if(this==that)
			return true;
		else if(!(that instanceof Day))
			return false;
		else {
			return ((this.tournament.equals(((Day)that).tournament))&&
					(this.number==((Day)that).number));
		}
	}
	
	@Override
	public int hashCode() {
		return tournament.hashCode()+number;
	}

}
