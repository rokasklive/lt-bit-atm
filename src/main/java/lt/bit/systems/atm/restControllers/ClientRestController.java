package lt.bit.systems.atm.restControllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.bit.systems.atm.security.AuthSession;
import lt.bit.systems.atm.services.ClientService;

@Controller
@RequestMapping("/")
public class ClientRestController {

	@Autowired
	ClientService client;
	AuthSession auth = AuthSession.getAuthSession();
	
	
	@GetMapping("/withdraw/{amount}")
	public void withdrawFunds(@PathParam("amount") int amount) {
		if(client.hasEnoughMoney(amount)) {
			client.withdrawFunds(amount);
			auth.setWithdrawState("Success");
		}else {
			auth.setWithdrawState("Insufficient funds");
		}
	}
	
	@GetMapping("/deposit")
	public void depositFunds(int amount) {
		client.depositFunds(amount);
	}
	
	
}
