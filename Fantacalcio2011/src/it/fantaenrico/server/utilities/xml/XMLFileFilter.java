package it.fantaenrico.server.utilities.xml;

import java.io.File;
import java.io.FileFilter;

public class XMLFileFilter implements FileFilter {

	private final String[] okFileExtensions = 
		new String[] {"xml"};

	public boolean accept(File file) {
		for (String extension : okFileExtensions) {
			if (file.getName().toLowerCase().endsWith(extension)) {
				return true;
			}
		}
		return false;
	}
}
