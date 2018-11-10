package lt.bit.systems.atm.services;

import org.springframework.stereotype.Service;

import lt.bit.systems.atm.ClientJpaRepository;
import lt.bit.systems.atm.TransactionType;

@Service
public class TransactionService {

	private final ClientJpaRepository rep;
	
	public TransactionService(ClientJpaRepository rep) {
		this.rep = rep;
	}
	
	public void updateBalance(TransactionType t, String id, int amount) {
		if(t.getType()){
			rep.updateBalance(id, amount);
		} else {
			rep.updateBalance(id, -amount);
		}
	}
}