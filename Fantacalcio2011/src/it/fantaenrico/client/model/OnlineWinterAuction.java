package it.fantaenrico.client.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class OnlineWinterAuction {
	
	private Date start_date; // It is possible to specify a start date for the auction or to start it manually
	private int possible_first_bid_period; // The number of days after the start during which it is possible to make the first bid for a player
	private int after_first_bid_period; // The number of days during which the auction for a player stays open after the first bid
	private int after_last_bid_period; // The number of days during which the auction for a player stays open after the last offer made, ONLY IF the after_first_bid_period is expired
	
	private List<Player> free_players;
	private HashMap<String, PlayerBid> highest_bids;
	
	public OnlineWinterAuction(List<Player> free_players, HashMap<String, PlayerBid> highest_bids) {
		this.free_players = free_players;
		this.highest_bids = highest_bids;
	}
	
	/* To remove a player that has been bought */
	public void removeFreePlayer(Player p) {
		free_players.remove(p);
	}
	
	/* To make a new bid for a player */
	public void makeBid(String player, PlayerBid new_bid) throws Exception {
		if(new_bid==null||new_bid.getBid()<=0)
			throw new Exception("Invalid bid!");
		PlayerBid current_bid = highest_bids.get(player);
		if(current_bid.getBidder().equals(new_bid.getBidder())) // if the current bid is from the same team the new bid is invalid
			throw new Exception("You already made the current bid for this player!");
		else if(current_bid==null||new_bid.getBid()>current_bid.getBid()) // if there are no current bids for this player or the new bid is greater than the current one, put it in the map
			highest_bids.put(player,new_bid);
		else
			throw new Exception("The value of the new bid is lower than the current one!");
	}
	
	/* To rise the current bid for a player */
	public void riseBid(String player, int rise, LeagueTeam team) throws Exception {
		PlayerBid current_bid = highest_bids.get(player);
		if(current_bid.getBidder().equals(team)) // if the current bid is from the same team the rise is invalid
			throw new Exception("You already made the current bid for this player!");
		else if(current_bid==null) 
			highest_bids.put(player, new PlayerBid(rise,team,new Date())); // If there are no bids for the player a new bid being equal to the rise is made
		else
			highest_bids.put(player, new PlayerBid(current_bid.getBid()+rise,team,new Date()));
	}

}
