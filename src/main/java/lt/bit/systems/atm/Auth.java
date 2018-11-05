package lt.bit.systems.atm;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_auth")
public class Auth {
	@Id
	@Column(name="atm_id")
	private Integer atmId;
	
	@Column(name="imei")
	private String imei;	
	
	public int getAtmId() {
		return atmId;
	}
	
	public String getImei() {
		return imei;
}

	
}
