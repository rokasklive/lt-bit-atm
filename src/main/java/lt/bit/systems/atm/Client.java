package lt.bit.systems.atm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Client {
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="firstname")
	private String name;
	
	@Column(name="lastname")
	
	private String lastName;
	
	@Column(name="balance")
	private int balance;
	public Client(String id, String name, String lastName, int balance) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Client() {}
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return "Vartotojo vardas: " + name + ", pavardė: " + lastName;
	}
	
	
	
}
