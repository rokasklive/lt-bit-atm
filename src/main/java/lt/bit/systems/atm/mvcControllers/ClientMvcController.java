package lt.bit.systems.atm.mvcControllers;

import org.springframework.stereotype.Controller;

import lt.bit.systems.atm.ClientJpaRepository;
import lt.bit.systems.atm.security.AuthSession;
import lt.bit.systems.atm.services.TransactionService;

@Controller
public class ClientMvcController {

	ClientJpaRepository rep;
	TransactionService transaction;
	AuthSession auth;
	
	ClientMvcController(ClientJpaRepository rep, TransactionService transaction){
		this.rep = rep;
		this.transaction = transaction;
		auth = AuthSession.getAuthSession();
	}
	
}
