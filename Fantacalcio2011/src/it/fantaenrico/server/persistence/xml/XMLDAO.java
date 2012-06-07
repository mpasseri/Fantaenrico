package it.fantaenrico.server.persistence.xml;

import it.fantaenrico.server.persistence.exception.XMLDAOException;

import java.util.List;

public interface XMLDAO<T> {
	
	List<T> getAll(String filepath) throws XMLDAOException;
	
	T getByFilename(String filepath, String filename) throws XMLDAOException;
	
	T getObjectFromString(String xml) throws XMLDAOException;
	
	String getStringFromObject(T f) throws XMLDAOException;
	
	void save(String filePath, String filename, T object) throws XMLDAOException;

}
