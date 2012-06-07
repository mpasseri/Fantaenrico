package it.fantaenrico.client.entities;

import it.fantaenrico.client.model.FootballMatch;

import java.util.Date;
import java.util.List;

public enum FootballChampionshipDay {
	
	One(1),Two(2),Three(3),Four(4),Five(5),Six(6),Seven(7),Eight(8),Nine(9),Ten(10),
	Eleven(11),Twelve(12),Thirtheen(13),Fourteen(14),Fifteen(15),Sixteen(16),
	Seventeen(17),Eighteen(18),Nineteen(19),Twenty(20),TwentyOne(21),TwentyTwo(22),
	TwentyThree(23),TwentyFour(24),TwentyFive(25),TwentySix(26),TwentySeven(27),
	TwentyEight(28),TwentyNine(29),Thirty(30),ThirtyOne(31),ThirtyTwo(32),
	ThirtyThree(33),ThirtyFour(34),ThirtyFive(35),ThirtySix(36),ThirtySeven(37),
	ThirtyEight(38);
	
	final int daynumber;
	private Date firstmatchdate; // The date of start of the first match of the day
	private List<FootballMatch> matches;
	
	FootballChampionshipDay(int daynumber) {
		this.daynumber=daynumber;
	}

}
