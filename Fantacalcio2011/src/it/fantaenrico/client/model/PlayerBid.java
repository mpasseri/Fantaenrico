package it.fantaenrico.client.model;

import java.util.Date;

public class PlayerBid {
	
	private int bid; // the amount of the bid
	private LeagueTeam bidder; // the team of the league that is making the bid 
	private Date bid_date; // the date in which the bid was made
	
	public PlayerBid(int bid, LeagueTeam bidder, Date bid_date) {
		this.bid = bid;
		this.bidder = bidder;
		this.bid_date = bid_date;
	}
	
	/* GETTERS AND SETTERS */
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public LeagueTeam getBidder() {
		return bidder;
	}

	public void setBidder(LeagueTeam bidder) {
		this.bidder = bidder;
	}

	public Date getBid_date() {
		return bid_date;
	}

	public void setBid_date(Date bidDate) {
		bid_date = bidDate;
	}
	/* END GETTERS AND SETTERS */

	@Override
	public boolean equals(Object that) {
		if(this==that)
			return true;
		else if(!(that instanceof PlayerBid))
			return false;
		else {
			return ((this.bid==((PlayerBid)that).bid)&&this.bidder.equals(((PlayerBid)that).bidder));
		}
	}
	
	@Override
	public int hashCode() {
		return bid+bidder.hashCode();
	}
}
