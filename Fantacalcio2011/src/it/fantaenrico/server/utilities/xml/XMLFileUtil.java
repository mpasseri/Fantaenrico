package it.fantaenrico.server.utilities.xml;

import it.fantaenrico.server.persistence.exception.XMLDAOException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class XMLFileUtil {
	
	private Logger logger;
	
	public XMLFileUtil() {
		this.logger = Logger.getLogger(XMLFileUtil.class);
	}
	
	/**
	 * This method creates the file in which the xml content will be written.
	 * It verifies if the given file path exists and is a directory, or creates it if it does not exist.
	 * If the file already exists it is deleted completely.
	 * @param filepath The path of the directory in which the file must be created.
	 * @param filename The name of the file to create.
	 * @return The File representing the actual file to be written
	 * @throws XMLDAOException Throws an exception if the filepath is not a directory
	 * or cannot be created, and if the file already exists and cannot be deleted.
	 */
	public File createFile(String filepath, String filename) throws XMLDAOException {
		// Verifico che il filename specificato abbia estensione xml
		if(!filename.endsWith(".xml")) {
			String message = "The specified filename ("+filename+") does not have an xml extension.";
			throw new XMLDAOException(message);
		}
		// Creo la directory indicata
		File dir = new File(filepath);
		// Se la directory non esiste la creo
		if(!dir.exists()) {
			try {
				dir.mkdirs();
			}
			catch(SecurityException e) {
				String message = "The directory ("+filepath+") does not exist and could not be created.";
				throw new XMLDAOException(message);
			}
		}
		else if(!dir.isDirectory()) {
			String message = "The specified file path ("+filepath+") is not a directory.";
			throw new XMLDAOException(message);
		}
		File xmlFile = new File(dir, filename);
		// Se il file giˆ esiste prima lo elimino
		if(xmlFile.exists()) {
			try {
				xmlFile.delete();
			}
			catch(SecurityException e) {
				String message = "The file ("+filename+") at the specified path ("+filepath+") " +
				"already exists and cannot be deleted.";
				throw new XMLDAOException(message);
			}
			xmlFile = new File(dir, filename);
		}
		return xmlFile;
	}
	
	/**
	 * This method writes the given xml content in the specified file.
	 * @param xmlFile The file to write.
	 * @param content The xml content to be written in the file.
	 * @throws XMLDAOException If an error occurs during the writing of the file
	 */
	public void writeFile(File xmlFile, String content) throws XMLDAOException {
		FileWriter fstream = null;
		try {
			fstream = new FileWriter(xmlFile);
		} catch (IOException e) {
			String message = "The file ("+xmlFile.getAbsolutePath()+") cannot be opened to be written.";
			throw new XMLDAOException(message);
		}
		BufferedWriter out = new BufferedWriter(fstream);
		try {
			out.write(content);
		} catch (IOException e) {
			String message = "The file ("+xmlFile.getAbsolutePath()+") could not be written.";
			throw new XMLDAOException(message);
		}
		try {
			out.close();
			fstream.close();
		} catch (IOException e) {
			String message = "The writer ("+xmlFile.getAbsolutePath()+") could not be closed.";
			throw new XMLDAOException(message);
		}
	}

}
