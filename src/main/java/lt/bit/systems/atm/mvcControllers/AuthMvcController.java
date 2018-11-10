package lt.bit.systems.atm.mvcControllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lt.bit.systems.atm.AuthJpaRepository;
import lt.bit.systems.atm.User;
import lt.bit.systems.atm.security.AuthSession;
import lt.bit.systems.atm.security.PasswordEncoder;

@Controller
public class AuthMvcController {
	
	AuthJpaRepository rep;
	PasswordEncoder security;
	AuthSession auth = AuthSession.getAuthSession();;
	AuthMvcController(AuthJpaRepository rep, PasswordEncoder security){
		this.rep = rep;
		this.security = security;
	}
	
	
	@GetMapping("/")
	public String showsIndex() {
		System.out.println("Success");
		return "index";
	}
	
	@GetMapping("/mykolas")
	public String enterAsMykolas() {
		auth.setAuth(true);
		auth.setHashPin("$2a$04$GF4BY8mtkx75dHQBEsBV7e8f/07Udip2mVRgfF9.RiqL28kzYNrki");
		auth.setId("987654321");
		return "index";
	}
	
	@GetMapping("/rokas")
	public String enterAsRokas() {
		auth.setAuth(true);
		auth.setHashPin("$2a$04$fClZzL7PV5MwEuSM3P5nvu/rJt7ywhS7aGukvfAvzfK258Kgtvoom");
		auth.setId("123456789");
		return "index";
	}
	
	@PostMapping("/auth")
	public String showPin(HttpServletRequest request, Model model) throws NoSuchAlgorithmException {
		System.out.println("Entered pin: " + request.getParameter("pin"));
		AuthSession auth = AuthSession.getAuthSession();
		String pin = request.getParameter("pin").toString();
		
	        
	      
		if(security.matches(pin, auth.getHashPin())) {
			System.out.println("Pin correct");
			User user = rep.findByID(auth.getId()).get(0);
			System.out.println(rep.findByID(auth.getId()).get(0).toString());
			model.addAttribute("name", user.getName())
				 .addAttribute("lastName", user.getLastName());
			return "enter";	
		} else {
			System.out.println("Pin incorrect");
			return "index";
		}
	}
	
}	
