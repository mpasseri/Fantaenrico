package it.fantaenrico.server.persistence.xml;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.KXml2Driver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import it.fantaenrico.client.entities.Formation;
import it.fantaenrico.client.entities.Scheme;
import it.fantaenrico.server.persistence.exception.XMLDAOException;
import it.fantaenrico.server.utilities.xml.XMLFileFilter;
import it.fantaenrico.server.utilities.xml.XMLFileUtil;

/**
 * Classe per accedere e scrivere una Formation da file XML
 * 
 * Esempio di un file XML di una formazione:
 * <Formation>
 * 	<Scheme>3-4-3<Scheme/>
 * 	<LeagueTeam>team name<LeagueTeam/>
 * 	<Day>1<Day/>
 * 	<Score>66<Score/>
 * 	<Goalkeepers>
 * 	 <Goalkeeper>
 * 	  <Player>Buffon<Player/>
 * 	  <Score>6<Score/>
 *   <Goalkeeper/>
 *   ...
 *  <Goalkeepers/>
 *  <Defenders>
 * 	 <Defender>
 * 	  <Player>Nesya<Player/>
 * 	  <Score>6<Score/>
 *   <Defender/>
 *   ...
 *  <Defenders/>
 *  <Midfielders>
 * 	 <Midfielder>
 * 	  <Player>DeRossi<Player/>
 * 	  <Score>6<Score/>
 *   <Midfielder/>
 *   ...
 *  <Midfielders/>
 *  <Forwards>
 * 	 <Forward>
 * 	  <Player>Buffon<Player/>
 * 	  <Score>6<Score/>
 *   <Forward/>
 *   ...
 *  <Forwards/>
 * <Formation/>
 * 
 * @author surfista153
 *
 */
public class FormationXMLDAO implements XMLDAO<Formation> {
	
	private XStream xstream = null;
	private XMLFileUtil xmlfileutil = null;
	private Logger logger;
	
	public FormationXMLDAO() {
		this.logger = Logger.getLogger(FormationXMLDAO.class);
		this.initializeXStream();
		this.xmlfileutil = new XMLFileUtil();
	}

	public List<Formation> getAll(String filepath) throws XMLDAOException {
		
		logger.debug("Retrieving Formation xml files at the path: "+filepath);
		// Return a list of Formation retrieved from the xml files at the path
		List<Formation> result = new ArrayList<Formation>();
		
		File dir = new File(filepath);
		// Retrieve only the xml files using a FileFilter
		File[] xmlFiles = null;
		if(dir.isDirectory()) {
			xmlFiles = dir.listFiles(new XMLFileFilter());
		}
		else {
			String message = "The given path ("+filepath+") is not a directory.";
			throw new XMLDAOException(message);
		}
		logger.debug(xmlFiles.length+" files were retrieved.");
		for(File f : xmlFiles) {
			try {
				result.add((Formation)xstream.fromXML(f));
			}
			catch(XStreamException e) {
				String message = "It was not possible to deserialize the file ("+f.getAbsolutePath()+") as a Formation object.";
				logger.warn(message);
			}
		}
		logger.debug(result.size()+" Formation were retrieved.");
		return result;
	}

	public Formation getByFilename(String filepath, String filename) throws XMLDAOException {
		logger.debug("Retrieving the xml file at the path ("+filepath+") with the name ("+filename+").");
		// Returns a Formation retrieved from the file at the given filepath
		Formation result = null;
		
		File dir = new File(filepath);
		if(dir.isDirectory()) {
			File xml = new File(dir, filename);
			try {
				result = ((Formation)xstream.fromXML(xml));
			}
			catch(XStreamException e) {
				String message = "It was not possible to deserialize the file ("+xml.getAbsolutePath()+") as a Formation object.";
				throw new XMLDAOException(message);
			}
		}
		else {
			String message = "The given path ("+filepath+") is not a directory.";
			throw new XMLDAOException(message);
		}
		return result;
	}
	
	public Formation getObjectFromString(String xml) throws XMLDAOException {
		try {
			return (Formation)xstream.fromXML(xml);
		}
		catch(XStreamException e) {
			String message = "It was not possible to deserialize the xml string.";
			throw new XMLDAOException(message);
		}
	}
	
	public String getStringFromObject(Formation f) throws XMLDAOException {
		try {
			return this.xstream.toXML(f);
		}
		catch(XStreamException e) {
			String message = "It was not possible to serialize the Formation object.";
			throw new XMLDAOException(message);
		}
	}

	public void save(String filepath, String filename, Formation object) throws XMLDAOException {

		// Creo la stringa XML
		String xml = getStringFromObject(object);
		// Faccio creare il file in cui salvare la stringa xml
		File xmlfile = this.xmlfileutil.createFile(filepath, filename);
		// Salvo la stringa xml nel file
		this.xmlfileutil.writeFile(xmlfile, xml);
		
	}
	
	/* Metodo per inizializzare l'xstream impostando gli alias delle classi etc. */
	private void initializeXStream() {
		if(xstream==null) {
			this.xstream = new XStream(new StaxDriver());
			this.xstream.alias("Formation", Formation.class);
			this.xstream.alias("Scheme", Scheme.class);
			this.xstream.useAttributeFor(Formation.class, "team");
			this.xstream.useAttributeFor(Formation.class, "day");
			this.xstream.useAttributeFor(Formation.class, "score");
		}
	}

}
