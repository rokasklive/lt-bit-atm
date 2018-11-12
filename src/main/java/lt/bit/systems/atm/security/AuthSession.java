package lt.bit.systems.atm.security;

import lt.bit.systems.atm.Client;

public class AuthSession {

	private String hashPin;
	private String id;
	private boolean auth;
	private static final AuthSession instance = new AuthSession();
	private Client client;
	
	private AuthSession() {};
	
	public static AuthSession getAuthSession() {
		return instance;
	}
	
	public void setHashPin(String hashPin) {
		this.hashPin = hashPin;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getHashPin() {
		return hashPin;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean isAuth() {
		return auth;
	}
	
	public void setAuth(boolean auth) {
		this.auth = auth;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void clearAuthSession() {
		instance.setAuth(false);
		instance.setHashPin(null);
		instance.setId(null);
		instance.setClient(null);
	}
	
	public void setSession(String hashPin, String id, Client client) {
		instance.setAuth(true);
		instance.setHashPin(hashPin);
		instance.setId(id);
		instance.setClient(client);
	}
}
