package lt.bit.systems.atm.mvcControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/balance")
	public String showBalance(Model model) {
		model.addAttribute("balance", rep.getClient(auth.getId()).get(0).getBalance());
		return "balance";
	}
	
	@GetMapping("/withdraw")
	public String withdrawRedirect(Model model) {
		model.addAttribute("withdrawStatus", auth.getWithdrawState());
		return "withdraw";
	}
	
	@GetMapping("/deposit")
	public String depositView(Model model) {
		return "deposit";
	}
	
}
