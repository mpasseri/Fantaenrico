package it.fantaenrico.client;

import it.fantaenrico.client.entities.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("db")
public interface DBConnection extends RemoteService {
	
	public User authenticateUser(String username, String pass);

}
