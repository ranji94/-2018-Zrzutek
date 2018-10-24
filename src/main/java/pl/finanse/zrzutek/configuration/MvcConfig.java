package pl.finanse.zrzutek.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("redirect:/shopping");
		registry.addViewController("/").setViewName("redirect:/shopping");
		registry.addViewController("/userpanel").setViewName("redirect:/shopping");
		registry.addViewController("/login").setViewName("login");
	}

	
}
