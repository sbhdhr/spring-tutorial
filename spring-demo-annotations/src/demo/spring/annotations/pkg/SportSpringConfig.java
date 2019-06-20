package demo.spring.annotations.pkg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("demo.spring.annotations.pkg")
@PropertySource("classpath:sport.properties")
public class SportSpringConfig {
	
	//define bean for sadfortuneservice
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	
	//define bean for swimcoach and inject dependency
	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
	
	
}
