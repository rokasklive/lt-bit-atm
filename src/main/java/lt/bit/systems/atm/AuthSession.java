package lt.bit.systems.atm;

public class AuthSession {

	private String hashPin;
	private String id;
	private boolean auth;
	private static final AuthSession instance = new AuthSession();
	
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
	
	public static void clearAuthSession() {
		instance.setAuth(false);
		instance.setHashPin(null);
		instance.setId(null);
	}
}
