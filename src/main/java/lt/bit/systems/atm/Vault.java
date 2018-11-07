package lt.bit.systems.atm;

import java.util.HashMap;
import java.util.Map;

public class Vault {
	
	private static Map<Integer, Integer> nominal = new HashMap<Integer, Integer>();
	
	private static Vault instance;

	private Vault() {};
	
	public static Vault getVaultInstance() {
	
		if(instance == null) {
			instance = new Vault();
			
			nominal.put(10, 200);
			nominal.put(20, 150);
			nominal.put(50, 100);
			nominal.put(100, 50);
		}
		return instance;
	};
	
	
	public static Map<Integer, Integer> getNominalCount() {
		return nominal;
	}
	
}