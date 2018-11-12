                                                                                                                                                                                                                                                                                                            package lt.bit.systems.atm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
	       registry.addViewController("/enter").setViewName("enter");
	       registry.addViewController("/index").setViewName("index");
	       registry.addViewController("/menu").setViewName("menu");
	       registry.addViewController("/balance").setViewName("balance");
	       registry.addViewController("/withdraw").setViewName("withdraw");
	       registry.addViewController("/otherAmount").setViewName("otherAmount");
	       registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs");
	       registry.addRedirectViewController("/api/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
	       registry.addRedirectViewController("/api/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
	       registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources");
	
}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/api/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
	    registry.addResourceHandler("/api/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	    registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
	}
}