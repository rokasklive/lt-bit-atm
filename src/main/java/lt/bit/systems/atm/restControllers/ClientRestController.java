package lt.bit.systems.atm.restControllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lt.bit.systems.atm.security.AuthSession;
import lt.bit.systems.atm.services.ClientService;

@RestController
@RequestMapping("/")
public class ClientRestController {

	@Autowired
	ClientService client;
	AuthSession auth = AuthSession.getAuthSession();
	
	@PostMapping("/withdraw")
	public void withdrawDefinedFunds(HttpServletResponse response, @RequestParam("amount") Integer amount) throws IOException {
		client.withdrawHandler(amount);
		response.sendRedirect("menu");
	}
	
	@PostMapping("/deposit")
	public void depositFunds(HttpServletResponse response, @RequestParam("depositAmount") int amount) throws IOException {
		client.depositFunds(amount);
		response.sendRedirect("menu");
	}
	
	
}
