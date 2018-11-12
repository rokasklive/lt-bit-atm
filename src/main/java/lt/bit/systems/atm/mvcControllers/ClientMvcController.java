package lt.bit.systems.atm.mvcControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lt.bit.systems.atm.ClientJpaRepository;
import lt.bit.systems.atm.security.AuthSession;

@Controller
public class ClientMvcController {

	ClientJpaRepository rep;

	AuthSession auth;
	
	ClientMvcController(ClientJpaRepository rep){
		this.rep = rep;
		auth = AuthSession.getAuthSession();
	}
	
	@GetMapping("/balance")
	public String showBalance(Model model) {
		model.addAttribute("balance", rep.getClient(auth.getId()).get(0).getBalance());
		return "balance";
	}
	
	@GetMapping("/withdraw")
	public String withdrawRedirect(Model model) {
		return "withdraw";
	}
	
	@GetMapping("/deposit")
	public String depositView(Model model) {
		return "deposit";
	}
	
}
