package lt.bit.systems.atm;

public enum TransactionType {

	ADD(true),
	SUB(false);
	
	private boolean type;
	private TransactionType(boolean b){
		this.type = b;
	}
	
	public boolean getType() {
		return type;
	}
}
