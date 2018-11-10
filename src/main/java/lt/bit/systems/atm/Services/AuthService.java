package lt.bit.systems.atm.services;

import org.springframework.stereotype.Service;

import lt.bit.systems.atm.AuthJpaRepository;

@Service
public class AuthService {
	
	private final AuthJpaRepository rep;

	
	public AuthService(AuthJpaRepository rep) {
		this.rep = rep;
	}
	
	public String getUser(String id) {
		
		return rep.findByID(id).get(0).getId();
	}

}
