package lt.bit.systems.atm.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/secure/**").hasAnyRole("admin", "user").and().formLogin();
		http.csrf().disable().authorizeRequests().antMatchers("/secureAdmin/**").hasRole("admin").and().formLogin();
//		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		http.logout()                                                                
        .logoutUrl("/logout")                                                 
        .logoutSuccessUrl("/index")                                                                        
        .invalidateHttpSession(true);
	}

}
