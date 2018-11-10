package lt.bit.systems.atm.restControllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lt.bit.systems.atm.security.AuthSession;



@Controller
@RequestMapping("/")
public class AuthRestController {
		
	AuthSession auth = AuthSession.getAuthSession();
	
	@PostMapping("/enter")
	public void enterPin(@RequestParam Map<String, String> body) {
		System.out.println(body);
		auth.setSession(body.get("hashPin"), body.get("id"));
	}
	
	@PostMapping("/state")
	@ResponseBody
	public ResponseEntity<String> checkState() {
		if(AuthSession.getAuthSession().isAuth() == true) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(428).build();

		}
	}
}
 