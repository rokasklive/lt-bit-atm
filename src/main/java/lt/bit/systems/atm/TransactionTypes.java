package lt.bit.systems.atm;

public enum TransactionTypes {

	ADD(true),
	SUB(false);
	
	private boolean type;
	private TransactionTypes(boolean b){
		this.type = b;
	}
	
	public boolean getType() {
		return type;
	}
}
