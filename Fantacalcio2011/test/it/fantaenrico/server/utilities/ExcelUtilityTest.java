package it.fantaenrico.server.utilities;

import it.fantaenrico.client.entities.FootballPlayer;

import java.util.List;

import org.junit.Test;

public class ExcelUtilityTest {
	
	@Test
	public void getFootballPlayersFromExcelTest() {
		
		// Ottengo la lista di giocatori dalle quotazioni
		List<FootballPlayer> players = ExcelUtility.getFootballPlayersFromExcel("quotazioni_11_giornata.xls");
		
		System.out.println("Numero di giocatori recuperati = "+players.size());
		for(FootballPlayer p : players)
			System.out.println(p);
	}
	

}
