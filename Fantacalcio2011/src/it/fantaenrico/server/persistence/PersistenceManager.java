package it.fantaenrico.server.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PersistenceManager {

	private static EntityManagerFactory emfInstance = null;

	private PersistenceManager() {}

	public static EntityManagerFactory get() {
		if(emfInstance==null) {
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("javax.persistence.jdbc.user", "admin");
			properties.put("javax.persistence.jdbc.password", "admin");
			properties.put("javax.persistence.jdbc.driver", "org.apache.derby.jdbc.EmbeddedDriver");
			properties.put("javax.persistence.jdbc.url", "jdbc:derby:/Users/surfista153/Fantaenrico/Fantacalcio2011/data/db/");
			emfInstance = Persistence.createEntityManagerFactory("", properties);
		}
		return emfInstance;
	}
	public static void close() {
		if(emfInstance!=null&&emfInstance.isOpen())
			emfInstance.close();
	}
}