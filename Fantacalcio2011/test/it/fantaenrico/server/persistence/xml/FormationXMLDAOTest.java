package it.fantaenrico.server.persistence.xml;

import java.util.List;

import it.fantaenrico.client.entities.Formation;
import it.fantaenrico.client.entities.Scheme;
import it.fantaenrico.client.exception.FormationException;
import it.fantaenrico.server.persistence.exception.XMLDAOException;

import org.junit.Before;
import org.junit.Test;

public class FormationXMLDAOTest {
	
	private FormationXMLDAO dao;
	private Formation formation;
	
	@Before
	public void setUp() {
		this.dao = new FormationXMLDAO();
		// Create the formation
		formation = new Formation(Scheme.F_3_4_3);
		formation.setTeam("McSurferz");
		formation.setDay(1);
		formation.setScore(0);
		try {
			formation.addGoalkeeper("BUFFON");
			formation.addGoalkeeper("ZOFF");
			formation.addDefender("ODDO");
			formation.addDefender("ZIO");
			formation.addDefender("NESTA");
			formation.addDefender("JUAN");
			formation.addDefender("MAICON");
			formation.addMidfielder("DEROSSI");
			formation.addMidfielder("MARCHISIO");
			formation.addMidfielder("PIZARRO");
			formation.addMidfielder("PIRLO");
			formation.addMidfielder("NOCERINO");
			formation.addMidfielder("HAMSIK");
			formation.addForward("PINO");
			formation.addForward("TOTTI");
			formation.addForward("BALOTELLI");
			formation.addForward("KLOSE");
			formation.addForward("DELPIERO");
		} catch (FormationException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void runTest() {
		this.saveTest();
//		this.getAllTest();
		String xml = this.getStringFromObject(formation);
		System.out.println(xml);
		Formation f = this.getObjectFromStringTest(xml);
		System.out.println(f);
	}
	
	private void saveTest()  {
		
		// Create the xml for the formation
		try {
			dao.save("//Users//surfista153//Fantaenrico//Fantacalcio2011//data//xml//Formation", "formation.xml", formation);
		} catch (XMLDAOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void getAllTest() {
		
		List<Formation> flist = null;
		try {
			flist = dao.getAll("//Users//surfista153//Fantaenrico//Fantacalcio2011//data//xml//Formation");
		} catch (XMLDAOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		for(Formation f : flist)
			System.out.println(f);
		
		
	}
	
	private Formation getObjectFromStringTest(String xml) {
		try {
			return dao.getObjectFromString(xml);
		} catch (XMLDAOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	private String getStringFromObject(Formation f) {
		try {
			return dao.getStringFromObject(f);
		} catch (XMLDAOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return "";
	}

}
