package lt.bit.systems.atm;

public class Authenticator {

	private String imei;
	private String model;
	
	public Authenticator(String imei, String model) {
		this.imei = imei;
		this.model = model;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
	
}
