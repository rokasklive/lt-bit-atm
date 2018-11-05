package lt.bit.systems.atm.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AtmConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
