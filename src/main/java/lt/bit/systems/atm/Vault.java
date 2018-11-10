package lt.bit.systems.atm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	public static void updateAtmNominal(int WhichNominal, int HowMany) {
		getNominalCount();
		nominal.put(WhichNominal,nominal.get(WhichNominal) + HowMany);
	}
	public static void main(String[]args) {
	
		getVaultInstance();
		getNominalCount();
		System.out.println(nominal);
		updateAtmNominal(10, 300);
		System.out.println(nominal);
		updateAtmNominal(10, 5);
		System.out.println(nominal);
		updateAtmNominal(20, 500);
		System.out.println(nominal);
		
	}
	
	
}