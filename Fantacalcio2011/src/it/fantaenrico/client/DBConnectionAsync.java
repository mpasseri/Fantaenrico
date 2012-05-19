package it.fantaenrico.client;

import it.fantaenrico.client.entities.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DBConnectionAsync {

	void authenticateUser(String username, String pass, AsyncCallback<User> callback);

}
