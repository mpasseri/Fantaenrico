package it.fantaenrico.server.utilities;

import it.fantaenrico.client.entities.FootballPlayer;
import it.fantaenrico.client.entities.FootballPlayerRole;
import it.fantaenrico.client.entities.FootballTeam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtility {

	public static List<FootballPlayer> getFootballPlayersFromExcel(String playerQuotationFile) {

		List<FootballPlayer> players = new ArrayList<FootballPlayer>();

		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(new File("war/WEB-INF/resources/excel/quotazioni/"+playerQuotationFile)); // carica il file excel
			Sheet sheet = workbook.getSheet(0); // seleziona lo sheet del documento excel
			int rowsNumber = sheet.getRows();
			for(int i=1; i<rowsNumber; i++) {

				Cell id = sheet.getCell(0, i);
				Cell ruolo = sheet.getCell(1, i);
				Cell nominativo = sheet.getCell(2, i);
				Cell squadra = sheet.getCell(3, i);
				Cell quotazione = sheet.getCell(4, i);
				Cell quotazioneIniziale = sheet.getCell(5, i);

				FootballPlayer player = new FootballPlayer();

				// Set the player name (ID)
				player.setName(nominativo.getContents());
				// Set the correct role for the player
				if(ruolo.getContents().equals("P"))
					player.setRole(FootballPlayerRole.GOALKEEPER);
				else if(ruolo.getContents().equals("D"))
					player.setRole(FootballPlayerRole.DEFENDER);
				else if(ruolo.getContents().equals("C"))
					player.setRole(FootballPlayerRole.MIDFIELDER);
				else if(ruolo.getContents().equals("A"))
					player.setRole(FootballPlayerRole.FORWARD);
				// Set the football team
				for(FootballTeam team : FootballTeam.values())
					if(team.name().toLowerCase().equals(squadra.getContents().toLowerCase())) {
						player.setTeam(team);
						break;
					}

				// Set the actual quotation of the player
				player.setCurrent_value(Integer.valueOf(quotazione.getContents()));
				// Set the initial quotation of the player
				player.setInitial_value(Integer.valueOf(quotazioneIniziale.getContents()));

				players.add(player);
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return players;

	}

}
