package it.fantaenrico.client.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TeamPlayer {
	
	private long uidteamplayer;
	
	private FootballPlayer footballplayer;
	private LeagueTeam leagueteam;
	
	private double price;

	@Id
	@SequenceGenerator(name="TEAMPLAYER_UIDTEAMPLAYER_GENERATOR", sequenceName="FE_SEQ_TEAMPLAYER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEAMPLAYER_UIDTEAMPLAYER_GENERATOR")
	@Column(unique=true, nullable=false, precision=19)
	public long getUidteamplayer() {
		return this.uidteamplayer;
	}

	public void setUidteamplayer(long uidteamplayer) {
		this.uidteamplayer = uidteamplayer;
	}

}
