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
	
	public static void updateAtmNominal(int WhichNominal, int HowMany) {
		getNominalCount();
		nominal.put(WhichNominal,nominal.get(WhichNominal) + HowMany);
	}
	// Two methods. One which takes int sum which you want to take out money from vault and
	// gives the highest available nominal
	// Other is same method that gives money from lowest nominal to biggest
	//
	// And make that when method called it gives you how many nominal left and how many nominal it takes
	
	public static void bigNominal(int sum) {
		
		if (sum >= 10 && sum <= 500) {
		
		int count100 = sum / 100;
		int h = 0;
			for ( int i = 0; i < count100; i++) {
				sum -= 100;
				nominal.put(100, nominal.get(100) - 1);
				h++;
			}
		int count50 = sum/50;
		int j = 0;
			for ( int i = 0; i < count50; i++) {
				sum -= 50;
				nominal.put(50, nominal.get(50) - 1);
				j++;
			}
		int count20 = sum/20;
		int k = 0;
			for ( int i = 0; i < count20; i++) {
				sum -= 20;
				nominal.put(20,  nominal.get(20) - 1);
				k++;
			}
		int count10 = sum/10;
		int l = 0;
			for ( int i = 0; i < count10; i++) {
				sum -= 10;
				nominal.put(10,  nominal.get(10) - 1);
				l++;
			}	
			System.out.println(h + " Hundreds was given " + nominal.get(100) + " Hundred money nominals left " + j +  " Fifties was given " + nominal.get(50) + " Fifties money nominals left " + k + " Twenties was given " + nominal.get(20) + " Twenties money nominals left " + l + " Tens was given " + nominal.get(10) + " Tens money nominals left " );
		} else {
		System.out.println(" You want to take wrong sum out of your balance ");
		}
	}
	
	public static void smallNominal(int sum) {
		
		if (sum >= 10 && sum <= 500) {
			
		int count10 = sum/10;
		int l = 0;
			for ( int i = 0; i < count10; i++) {
				sum -= 10;
				nominal.put(10,  nominal.get(10) - 1);
				l++;
			}
		int count20 = sum/20;
		int k = 0;
			for ( int i = 0; i < count20; i++) {
				sum -= 20;
				nominal.put(20,  nominal.get(20) - 1);
				k++;
				}
		int count50 = sum/50;
		int j = 0;
			for ( int i = 0; i < count50; i++) {
				sum -= 50;
				nominal.put(50, nominal.get(50) - 1);
				j++;
				}
		int count100 = sum / 100;
		int h = 0;
			for ( int i = 0; i < count100; i++) {
				sum -= 100;
				nominal.put(100, nominal.get(100) - 1);
				h++;
				}
			
			System.out.println(h + " Hundreds was given " + nominal.get(100) + " Hundred money nominals left " + j +  " Fifties was given " + nominal.get(50) + " Fifties money nominals left " + k + " Twenties was given " + nominal.get(20) + " Twenties money nominals left " + l + " Tens was given " + nominal.get(10) + " Tens money nominals left " );
		} else {
		System.out.println(" You want to take wrong sum out of your balance ");
		}
		
		
	}
	
	public static void main(String[]args) {
//	
		getVaultInstance();
		getNominalCount();
//		System.out.println(nominal);
//		updateAtmNominal(10, 300);
//		System.out.println(nominal);
//		updateAtmNominal(10, 5);
//		System.out.println(nominal);
//		updateAtmNominal(20, 500);
//		System.out.println(nominal);
//		int sum = 100;
//		int sum2 = 50;
//		int sum3 = 20;
//		int sum4 = 10;
//		
//		int newSum = sum % 200;
//		System.out.println(newSum);
//		int newSum2 = sum2 % 200;
//		System.out.println(newSum2);
//		int newSum3 = sum3 % 200;
//		System.out.println(newSum3);
//		int newSum4 = sum4 % 200;
//		System.out.println(newSum4);
		
		bigNominal(500);
		bigNominal(470);
		bigNominal(-10);
		bigNominal(510);
		bigNominal(10);
		
		smallNominal(10);
		smallNominal(20);
		
		
	}
	
	
	
}