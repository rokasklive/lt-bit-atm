package lt.bit.systems.atm.services;

import org.springframework.stereotype.Service;

import lt.bit.systems.atm.ClientJpaRepository;
import lt.bit.systems.atm.Vault;
import lt.bit.systems.atm.security.AuthSession;

@Service
public class ClientService {

	AuthSession auth = AuthSession.getAuthSession();
	Vault vault = Vault.getVaultInstance();
	private final ClientJpaRepository client;
	
	ClientService(ClientJpaRepository client){
		this.client = client;
	}
	
	public boolean hasEnoughMoney(int amount) {
		if(auth.getClient().getBalance() >= amount) {
			return true;
		} else {
			return false;
		}
	}
	
	public void withdrawFunds(int amount) {
		vault.nominalCounting(amount);
		client.updateBalance(auth.getId(), -amount);
	}
	
	public void depositFunds(int amount) {
		client.updateBalance(auth.getId(), amount);
	}
	
	public void withdrawHandler(int amount) {
		if(this.hasEnoughMoney(amount)) {
			this.withdrawFunds(amount);
		}
	}
	
	}

